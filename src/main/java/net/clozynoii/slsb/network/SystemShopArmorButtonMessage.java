
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

import net.clozynoii.slsb.world.inventory.SystemShopArmorMenu;
import net.clozynoii.slsb.procedures.SystemSelectedClassTankerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassRangerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassMageProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassHealerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassFighterProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassAssassinProcedure;
import net.clozynoii.slsb.procedures.SystemOpenStatusProcedure;
import net.clozynoii.slsb.procedures.SystemOpenSkillsProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmor3Procedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmor2Procedure;
import net.clozynoii.slsb.procedures.SystemOpenQuestsProcedure;
import net.clozynoii.slsb.SlsbMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SystemShopArmorButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SystemShopArmorButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "system_shop_armor_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SystemShopArmorButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SystemShopArmorButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SystemShopArmorButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SystemShopArmorButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SystemShopArmorButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = SystemShopArmorMenu.guistate;
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

			SystemOpenShopArmor2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SystemOpenShopArmor3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			SystemSelectedClassFighterProcedure.execute(entity);
		}
		if (buttonID == 15) {

			SystemSelectedClassTankerProcedure.execute(entity);
		}
		if (buttonID == 16) {

			SystemSelectedClassAssassinProcedure.execute(entity);
		}
		if (buttonID == 17) {

			SystemSelectedClassRangerProcedure.execute(entity);
		}
		if (buttonID == 18) {

			SystemSelectedClassMageProcedure.execute(entity);
		}
		if (buttonID == 19) {

			SystemSelectedClassHealerProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SystemShopArmorButtonMessage.TYPE, SystemShopArmorButtonMessage.STREAM_CODEC, SystemShopArmorButtonMessage::handleData);
	}
}
