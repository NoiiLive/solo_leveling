
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

import net.clozynoii.slsb.world.inventory.SystemShopWeaponsMenu;
import net.clozynoii.slsb.procedures.SystemSelectedClassTankerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassRangerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassMageProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassHealerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassFighterProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassAssassinProcedure;
import net.clozynoii.slsb.procedures.SystemOpenStatusProcedure;
import net.clozynoii.slsb.procedures.SystemOpenSkillsProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopProcedure;
import net.clozynoii.slsb.procedures.SystemOpenQuestsProcedure;
import net.clozynoii.slsb.SlsbMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SystemShopWeaponsButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SystemShopWeaponsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "system_shop_weapons_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SystemShopWeaponsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SystemShopWeaponsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SystemShopWeaponsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SystemShopWeaponsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SystemShopWeaponsButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = SystemShopWeaponsMenu.guistate;
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
		if (buttonID == 10) {

			SystemSelectedClassFighterProcedure.execute(entity);
		}
		if (buttonID == 11) {

			SystemSelectedClassTankerProcedure.execute(entity);
		}
		if (buttonID == 12) {

			SystemSelectedClassAssassinProcedure.execute(entity);
		}
		if (buttonID == 13) {

			SystemSelectedClassRangerProcedure.execute(entity);
		}
		if (buttonID == 14) {

			SystemSelectedClassMageProcedure.execute(entity);
		}
		if (buttonID == 15) {

			SystemSelectedClassHealerProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SystemShopWeaponsButtonMessage.TYPE, SystemShopWeaponsButtonMessage.STREAM_CODEC, SystemShopWeaponsButtonMessage::handleData);
	}
}
