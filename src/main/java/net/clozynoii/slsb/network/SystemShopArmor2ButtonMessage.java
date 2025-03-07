
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

import net.clozynoii.slsb.world.inventory.SystemShopArmor2Menu;
import net.clozynoii.slsb.procedures.SystemSelectedClassTankerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassRangerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassMageProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassHealerProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassFighterProcedure;
import net.clozynoii.slsb.procedures.SystemSelectedClassAssassinProcedure;
import net.clozynoii.slsb.procedures.SystemOpenStatusProcedure;
import net.clozynoii.slsb.procedures.SystemOpenSkillsProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmorProcedure;
import net.clozynoii.slsb.procedures.SystemOpenShopArmor3Procedure;
import net.clozynoii.slsb.procedures.SystemOpenQuestsProcedure;
import net.clozynoii.slsb.SlsbMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SystemShopArmor2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SystemShopArmor2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "system_shop_armor_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SystemShopArmor2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SystemShopArmor2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SystemShopArmor2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SystemShopArmor2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SystemShopArmor2ButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = SystemShopArmor2Menu.guistate;
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

			SystemOpenShopArmor3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SystemOpenShopArmorProcedure.execute(world, x, y, z, entity);
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
		SlsbMod.addNetworkMessage(SystemShopArmor2ButtonMessage.TYPE, SystemShopArmor2ButtonMessage.STREAM_CODEC, SystemShopArmor2ButtonMessage::handleData);
	}
}
