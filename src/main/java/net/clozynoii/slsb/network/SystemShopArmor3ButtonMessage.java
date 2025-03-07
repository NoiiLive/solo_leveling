
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
import net.minecraft.core.BlockPos;

import net.clozynoii.slsb.world.inventory.SystemShopArmor3Menu;
import net.clozynoii.slsb.procedures.SystemOpenStatusProcedure;
import net.clozynoii.slsb.procedures.SystemOpenSkillsProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmorProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmor2Procedure;
import net.clozynoii.slsb.procedures.SystemOpenQuestsProcedure;
import net.clozynoii.slsb.SlsbMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SystemShopArmor3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SystemShopArmor3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "system_shop_armor_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SystemShopArmor3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SystemShopArmor3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SystemShopArmor3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SystemShopArmor3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SystemShopArmor3ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SystemShopArmor3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SystemOpenShopProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SystemOpenStatusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SystemOpenSkillsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SystemOpenQuestsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SystemOpenShopArmorProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SystemOpenShopArmor2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SystemShopArmor3ButtonMessage.TYPE, SystemShopArmor3ButtonMessage.STREAM_CODEC, SystemShopArmor3ButtonMessage::handleData);
	}
}
