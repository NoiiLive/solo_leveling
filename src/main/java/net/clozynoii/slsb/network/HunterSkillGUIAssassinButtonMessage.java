
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

import net.clozynoii.slsb.world.inventory.HunterSkillGUIAssassinMenu;
import net.clozynoii.slsb.procedures.TabHunterSkillsProcedure;
import net.clozynoii.slsb.procedures.TabHunterMainProcedure;
import net.clozynoii.slsb.procedures.SkillButtonWhirlCutProcedure;
import net.clozynoii.slsb.procedures.SkillButtonStealthProcedure;
import net.clozynoii.slsb.procedures.SkillButtonSlaughtererProcedure;
import net.clozynoii.slsb.procedures.SkillButtonQuickReflexProcedure;
import net.clozynoii.slsb.procedures.SkillButtonFlickerFangProcedure;
import net.clozynoii.slsb.procedures.SkillButtonDaggerThrowProcedure;
import net.clozynoii.slsb.procedures.SkillButtonCriticalStrikeProcedure;
import net.clozynoii.slsb.procedures.SkillButtonBackstabProcedure;
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
public record HunterSkillGUIAssassinButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<HunterSkillGUIAssassinButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "hunter_skill_gui_assassin_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HunterSkillGUIAssassinButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HunterSkillGUIAssassinButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HunterSkillGUIAssassinButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<HunterSkillGUIAssassinButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HunterSkillGUIAssassinButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = HunterSkillGUIAssassinMenu.guistate;
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

			SkillButtonStealthProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			SkillButtonDaggerThrowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			SkillButtonCriticalStrikeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			SkillButtonSlaughtererProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			SkillButtonBackstabProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			SkillButtonQuickReflexProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			SkillButtonWhirlCutProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			SkillButtonFlickerFangProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(HunterSkillGUIAssassinButtonMessage.TYPE, HunterSkillGUIAssassinButtonMessage.STREAM_CODEC, HunterSkillGUIAssassinButtonMessage::handleData);
	}
}
