
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.slsb.SlsbMod;

public class SlsbModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlsbMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SL_ITEMS = REGISTRY.register("sl_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.slsb.sl_items")).icon(() -> new ItemStack(SlsbModItems.ITEMS_TAB.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SlsbModItems.MANA_CRYSTAL.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_E.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_D.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_C.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_B.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_A.get());
				tabData.accept(SlsbModItems.ESSENCE_STONE_S.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SL_BLOCKS = REGISTRY.register("sl_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.slsb.sl_blocks")).icon(() -> new ItemStack(SlsbModBlocks.AWAKENING_ORB.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SlsbModBlocks.AWAKENING_ORB.get().asItem());
				tabData.accept(SlsbModBlocks.MANA_TRAINING_ORB.get().asItem());
			}).withTabsBefore(SL_ITEMS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SL_GEAR = REGISTRY.register("sl_gear",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.slsb.sl_gear")).icon(() -> new ItemStack(SlsbModItems.KASAKAS_FANG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SlsbModItems.MANA_STONE_PICKAXE.get());
				tabData.accept(SlsbModItems.KASAKAS_FANG.get());
				tabData.accept(SlsbModItems.RED_KNIGHTS_ARMOR_HELMET.get());
				tabData.accept(SlsbModItems.RED_KNIGHTS_ARMOR_CHESTPLATE.get());
				tabData.accept(SlsbModItems.RED_KNIGHTS_ARMOR_LEGGINGS.get());
				tabData.accept(SlsbModItems.RED_KNIGHTS_ARMOR_BOOTS.get());
			}).withTabsBefore(SL_BLOCKS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SL_MOBS = REGISTRY.register("sl_mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.slsb.sl_mobs")).icon(() -> new ItemStack(SlsbModItems.BLOODRED_IGRIS_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SlsbModItems.BLOODRED_IGRIS_SPAWN_EGG.get());
			}).withTabsBefore(SL_GEAR.getId()).build());
}
