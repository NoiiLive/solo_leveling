
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.clozynoii.slsb.block.TanTrimmedPanelWallBlock;
import net.clozynoii.slsb.block.TanPanelWallBlock;
import net.clozynoii.slsb.block.TanPanelBlock;
import net.clozynoii.slsb.block.MetalFramedWindowBlock;
import net.clozynoii.slsb.block.ManaTrainingOrbBlock;
import net.clozynoii.slsb.block.ManaCrystalOreBlock;
import net.clozynoii.slsb.block.ManaCrystalClusterBlock;
import net.clozynoii.slsb.block.GreenDoorBlock;
import net.clozynoii.slsb.block.BrownTrimmedPanelBlock;
import net.clozynoii.slsb.block.BrownPanelBlock;
import net.clozynoii.slsb.block.BlueGateSmallBlock;
import net.clozynoii.slsb.block.BlueGateMediumBlock;
import net.clozynoii.slsb.block.BloodBlockBlock;
import net.clozynoii.slsb.block.BarrierWallBlock;
import net.clozynoii.slsb.block.BarrierSlabBlock;
import net.clozynoii.slsb.block.AwakeningOrbBlock;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SlsbMod.MODID);
	public static final DeferredBlock<Block> BLOOD_BLOCK = REGISTRY.register("blood_block", BloodBlockBlock::new);
	public static final DeferredBlock<Block> AWAKENING_ORB = REGISTRY.register("awakening_orb", AwakeningOrbBlock::new);
	public static final DeferredBlock<Block> BLUE_GATE_SMALL = REGISTRY.register("blue_gate_small", BlueGateSmallBlock::new);
	public static final DeferredBlock<Block> BLUE_GATE_MEDIUM = REGISTRY.register("blue_gate_medium", BlueGateMediumBlock::new);
	public static final DeferredBlock<Block> BARRIER_SLAB = REGISTRY.register("barrier_slab", BarrierSlabBlock::new);
	public static final DeferredBlock<Block> BARRIER_WALL = REGISTRY.register("barrier_wall", BarrierWallBlock::new);
	public static final DeferredBlock<Block> MANA_TRAINING_ORB = REGISTRY.register("mana_training_orb", ManaTrainingOrbBlock::new);
	public static final DeferredBlock<Block> GREEN_DOOR = REGISTRY.register("green_door", GreenDoorBlock::new);
	public static final DeferredBlock<Block> BROWN_TRIMMED_PANEL = REGISTRY.register("brown_trimmed_panel", BrownTrimmedPanelBlock::new);
	public static final DeferredBlock<Block> BROWN_PANEL = REGISTRY.register("brown_panel", BrownPanelBlock::new);
	public static final DeferredBlock<Block> TAN_PANEL = REGISTRY.register("tan_panel", TanPanelBlock::new);
	public static final DeferredBlock<Block> TAN_TRIMMED_PANEL_WALL = REGISTRY.register("tan_trimmed_panel_wall", TanTrimmedPanelWallBlock::new);
	public static final DeferredBlock<Block> TAN_PANEL_WALL = REGISTRY.register("tan_panel_wall", TanPanelWallBlock::new);
	public static final DeferredBlock<Block> METAL_FRAMED_WINDOW = REGISTRY.register("metal_framed_window", MetalFramedWindowBlock::new);
	public static final DeferredBlock<Block> MANA_CRYSTAL_ORE = REGISTRY.register("mana_crystal_ore", ManaCrystalOreBlock::new);
	public static final DeferredBlock<Block> MANA_CRYSTAL_CLUSTER = REGISTRY.register("mana_crystal_cluster", ManaCrystalClusterBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
