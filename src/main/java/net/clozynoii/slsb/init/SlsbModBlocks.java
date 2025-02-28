
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.clozynoii.slsb.block.TestBlockBlock;
import net.clozynoii.slsb.block.BloodBlockBlock;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SlsbMod.MODID);
	public static final DeferredBlock<Block> BLOOD_BLOCK = REGISTRY.register("blood_block", BloodBlockBlock::new);
	public static final DeferredBlock<Block> TEST_BLOCK = REGISTRY.register("test_block", TestBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
