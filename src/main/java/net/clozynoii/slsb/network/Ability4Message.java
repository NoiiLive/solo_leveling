
package net.clozynoii.slsb.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.clozynoii.slsb.procedures.AbilityKey4Procedure;
import net.clozynoii.slsb.SlsbMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record Ability4Message(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<Ability4Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "key_ability_4"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Ability4Message> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Ability4Message message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new Ability4Message(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<Ability4Message> type() {
		return TYPE;
	}

	public static void handleData(final Ability4Message message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			AbilityKey4Procedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			AbilityKey4Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(Ability4Message.TYPE, Ability4Message.STREAM_CODEC, Ability4Message::handleData);
	}
}
