package net.clozynoii.slsb.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.clozynoii.slsb.init.SlsbModBlockEntities;
import net.clozynoii.slsb.block.renderer.VitalityTrainingMatTileRenderer;
import net.clozynoii.slsb.block.renderer.StrengthTrainingDumbellsTileRenderer;
import net.clozynoii.slsb.block.renderer.ManaTrainingOrbTileRenderer;
import net.clozynoii.slsb.block.renderer.BlueGateSmallTileRenderer;
import net.clozynoii.slsb.block.renderer.BlueGateMediumTileRenderer;
import net.clozynoii.slsb.block.renderer.AwakeningOrbTileRenderer;
import net.clozynoii.slsb.block.renderer.AgilityTreadmillTileRenderer;
import net.clozynoii.slsb.block.entity.VitalityTrainingMatTileEntity;
import net.clozynoii.slsb.block.entity.StrengthTrainingDumbellsTileEntity;
import net.clozynoii.slsb.block.entity.ManaTrainingOrbTileEntity;
import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;
import net.clozynoii.slsb.block.entity.BlueGateMediumTileEntity;
import net.clozynoii.slsb.block.entity.AwakeningOrbTileEntity;
import net.clozynoii.slsb.block.entity.AgilityTreadmillTileEntity;
import net.clozynoii.slsb.SlsbMod;

@EventBusSubscriber(modid = SlsbMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<AwakeningOrbTileEntity>) SlsbModBlockEntities.AWAKENING_ORB.get(), context -> new AwakeningOrbTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<BlueGateSmallTileEntity>) SlsbModBlockEntities.BLUE_GATE_SMALL.get(), context -> new BlueGateSmallTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<BlueGateMediumTileEntity>) SlsbModBlockEntities.BLUE_GATE_MEDIUM.get(), context -> new BlueGateMediumTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<ManaTrainingOrbTileEntity>) SlsbModBlockEntities.MANA_TRAINING_ORB.get(), context -> new ManaTrainingOrbTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<StrengthTrainingDumbellsTileEntity>) SlsbModBlockEntities.STRENGTH_TRAINING_DUMBELLS.get(), context -> new StrengthTrainingDumbellsTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<VitalityTrainingMatTileEntity>) SlsbModBlockEntities.VITALITY_TRAINING_MAT.get(), context -> new VitalityTrainingMatTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<AgilityTreadmillTileEntity>) SlsbModBlockEntities.AGILITY_TREADMILL.get(), context -> new AgilityTreadmillTileRenderer());
	}
}
