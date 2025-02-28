
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.clozynoii.slsb.SlsbMod;

public class SlsbModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SlsbMod.MODID);
	public static final DeferredItem<Item> BLOOD_BLOCK = block(SlsbModBlocks.BLOOD_BLOCK);
	public static final DeferredItem<Item> TEST_BLOCK = block(SlsbModBlocks.TEST_BLOCK);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
