
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.clozynoii.slsb.block.BlueGateSmallBlock;
import net.clozynoii.slsb.block.BlueGateMediumBlock;
import net.clozynoii.slsb.block.BloodBlockBlock;
import net.clozynoii.slsb.block.AwakeningOrbBlock;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SlsbMod.MODID);
	public static final DeferredBlock<Block> BLOOD_BLOCK = REGISTRY.register("blood_block", BloodBlockBlock::new);
	public static final DeferredBlock<Block> AWAKENING_ORB = REGISTRY.register("awakening_orb", AwakeningOrbBlock::new);
	public static final DeferredBlock<Block> BLUE_GATE_SMALL = REGISTRY.register("blue_gate_small", BlueGateSmallBlock::new);
	public static final DeferredBlock<Block> BLUE_GATE_MEDIUM = REGISTRY.register("blue_gate_medium", BlueGateMediumBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
