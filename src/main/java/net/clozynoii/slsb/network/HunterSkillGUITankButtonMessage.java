
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

import net.clozynoii.slsb.world.inventory.HunterSkillGUITankMenu;
import net.clozynoii.slsb.procedures.TabHunterSkillsProcedure;
import net.clozynoii.slsb.procedures.TabHunterMainProcedure;
import net.clozynoii.slsb.procedures.SkillButtonUnyieldingRoarProcedure;
import net.clozynoii.slsb.procedures.SkillButtonTauntProcedure;
import net.clozynoii.slsb.procedures.SkillButtonStrideProcedure;
import net.clozynoii.slsb.procedures.SkillButtonStrengtheningProcedure;
import net.clozynoii.slsb.procedures.SkillButtonPowerSmashProcedure;
import net.clozynoii.slsb.procedures.SkillButtonManaShieldProcedure;
import net.clozynoii.slsb.procedures.SkillButtonIronGraspProcedure;
import net.clozynoii.slsb.procedures.SkillButtonCollapseProcedure;
import net.clozynoii.slsb.procedures.SkillButtonChargeProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot5bProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot5aProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot4bProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot4aProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot3bProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot3aProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot2bProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot2aProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot1bProcedure;
import net.clozynoii.slsb.procedures.GUISkillSlot1aProcedure;
import net.clozynoii.slsb.SlsbMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record HunterSkillGUITankButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<HunterSkillGUITankButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "hunter_skill_gui_tank_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HunterSkillGUITankButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HunterSkillGUITankButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HunterSkillGUITankButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<HunterSkillGUITankButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HunterSkillGUITankButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = HunterSkillGUITankMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TabHunterMainProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			GUISkillSlot1aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUISkillSlot2aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GUISkillSlot3aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUISkillSlot4aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			GUISkillSlot5aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			GUISkillSlot1bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GUISkillSlot2bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			GUISkillSlot3bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			GUISkillSlot4bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			GUISkillSlot5bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			TabHunterSkillsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			SkillButtonTauntProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			SkillButtonCollapseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			SkillButtonPowerSmashProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			SkillButtonManaShieldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			SkillButtonStrengtheningProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			SkillButtonChargeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			SkillButtonStrideProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			SkillButtonUnyieldingRoarProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 20) {

			SkillButtonIronGraspProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(HunterSkillGUITankButtonMessage.TYPE, HunterSkillGUITankButtonMessage.STREAM_CODEC, HunterSkillGUITankButtonMessage::handleData);
	}
}
