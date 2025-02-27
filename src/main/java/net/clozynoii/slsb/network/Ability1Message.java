
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

import net.clozynoii.slsb.procedures.AbilityKey1Procedure;
import net.clozynoii.slsb.SlsbMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record Ability1Message(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<Ability1Message> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "key_ability_1"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Ability1Message> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Ability1Message message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new Ability1Message(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<Ability1Message> type() {
		return TYPE;
	}

	public static void handleData(final Ability1Message message, final IPayloadContext context) {
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

			AbilityKey1Procedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			AbilityKey1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(Ability1Message.TYPE, Ability1Message.STREAM_CODEC, Ability1Message::handleData);
	}
}
