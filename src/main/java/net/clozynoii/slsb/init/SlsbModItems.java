
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.clozynoii.slsb.item.RedKnightsArmorItem;
import net.clozynoii.slsb.item.ManaStonePickaxeItem;
import net.clozynoii.slsb.item.ManaCrystalItem;
import net.clozynoii.slsb.item.KasakasFangItem;
import net.clozynoii.slsb.item.ItemsTabItem;
import net.clozynoii.slsb.item.EssenceStoneSItem;
import net.clozynoii.slsb.item.EssenceStoneEItem;
import net.clozynoii.slsb.item.EssenceStoneDItem;
import net.clozynoii.slsb.item.EssenceStoneCItem;
import net.clozynoii.slsb.item.EssenceStoneBItem;
import net.clozynoii.slsb.item.EssenceStoneAItem;
import net.clozynoii.slsb.block.display.ManaTrainingOrbDisplayItem;
import net.clozynoii.slsb.block.display.BlueGateSmallDisplayItem;
import net.clozynoii.slsb.block.display.BlueGateMediumDisplayItem;
import net.clozynoii.slsb.block.display.AwakeningOrbDisplayItem;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SlsbMod.MODID);
	public static final DeferredItem<Item> BLOOD_BLOCK = block(SlsbModBlocks.BLOOD_BLOCK);
	public static final DeferredItem<Item> AWAKENING_ORB = REGISTRY.register(SlsbModBlocks.AWAKENING_ORB.getId().getPath(), () -> new AwakeningOrbDisplayItem(SlsbModBlocks.AWAKENING_ORB.get(), new Item.Properties()));
	public static final DeferredItem<Item> BLUE_GATE_SMALL = REGISTRY.register(SlsbModBlocks.BLUE_GATE_SMALL.getId().getPath(), () -> new BlueGateSmallDisplayItem(SlsbModBlocks.BLUE_GATE_SMALL.get(), new Item.Properties()));
	public static final DeferredItem<Item> BLUE_GATE_MEDIUM = REGISTRY.register(SlsbModBlocks.BLUE_GATE_MEDIUM.getId().getPath(), () -> new BlueGateMediumDisplayItem(SlsbModBlocks.BLUE_GATE_MEDIUM.get(), new Item.Properties()));
	public static final DeferredItem<Item> BARRIER_SLAB = block(SlsbModBlocks.BARRIER_SLAB);
	public static final DeferredItem<Item> BARRIER_WALL = block(SlsbModBlocks.BARRIER_WALL);
	public static final DeferredItem<Item> MANA_TRAINING_ORB = REGISTRY.register(SlsbModBlocks.MANA_TRAINING_ORB.getId().getPath(), () -> new ManaTrainingOrbDisplayItem(SlsbModBlocks.MANA_TRAINING_ORB.get(), new Item.Properties()));
	public static final DeferredItem<Item> GREEN_DOOR = doubleBlock(SlsbModBlocks.GREEN_DOOR);
	public static final DeferredItem<Item> BROWN_TRIMMED_PANEL = block(SlsbModBlocks.BROWN_TRIMMED_PANEL);
	public static final DeferredItem<Item> BROWN_PANEL = block(SlsbModBlocks.BROWN_PANEL);
	public static final DeferredItem<Item> TAN_PANEL = block(SlsbModBlocks.TAN_PANEL);
	public static final DeferredItem<Item> TAN_TRIMMED_PANEL_WALL = block(SlsbModBlocks.TAN_TRIMMED_PANEL_WALL);
	public static final DeferredItem<Item> TAN_PANEL_WALL = block(SlsbModBlocks.TAN_PANEL_WALL);
	public static final DeferredItem<Item> METAL_FRAMED_WINDOW = block(SlsbModBlocks.METAL_FRAMED_WINDOW);
	public static final DeferredItem<Item> BLOODRED_IGRIS_SPAWN_EGG = REGISTRY.register("bloodred_igris_spawn_egg", () -> new DeferredSpawnEggItem(SlsbModEntities.BLOODRED_IGRIS, -10346969, -5956837, new Item.Properties()));
	public static final DeferredItem<Item> KASAKAS_FANG = REGISTRY.register("kasakas_fang", KasakasFangItem::new);
	public static final DeferredItem<Item> RED_KNIGHTS_ARMOR_HELMET = REGISTRY.register("red_knights_armor_helmet", RedKnightsArmorItem.Helmet::new);
	public static final DeferredItem<Item> RED_KNIGHTS_ARMOR_CHESTPLATE = REGISTRY.register("red_knights_armor_chestplate", RedKnightsArmorItem.Chestplate::new);
	public static final DeferredItem<Item> RED_KNIGHTS_ARMOR_LEGGINGS = REGISTRY.register("red_knights_armor_leggings", RedKnightsArmorItem.Leggings::new);
	public static final DeferredItem<Item> RED_KNIGHTS_ARMOR_BOOTS = REGISTRY.register("red_knights_armor_boots", RedKnightsArmorItem.Boots::new);
	public static final DeferredItem<Item> ESSENCE_STONE_E = REGISTRY.register("essence_stone_e", EssenceStoneEItem::new);
	public static final DeferredItem<Item> ESSENCE_STONE_D = REGISTRY.register("essence_stone_d", EssenceStoneDItem::new);
	public static final DeferredItem<Item> ESSENCE_STONE_C = REGISTRY.register("essence_stone_c", EssenceStoneCItem::new);
	public static final DeferredItem<Item> ESSENCE_STONE_B = REGISTRY.register("essence_stone_b", EssenceStoneBItem::new);
	public static final DeferredItem<Item> ESSENCE_STONE_A = REGISTRY.register("essence_stone_a", EssenceStoneAItem::new);
	public static final DeferredItem<Item> ESSENCE_STONE_S = REGISTRY.register("essence_stone_s", EssenceStoneSItem::new);
	public static final DeferredItem<Item> MANA_CRYSTAL = REGISTRY.register("mana_crystal", ManaCrystalItem::new);
	public static final DeferredItem<Item> ITEMS_TAB = REGISTRY.register("items_tab", ItemsTabItem::new);
	public static final DeferredItem<Item> MANA_STONE_PICKAXE = REGISTRY.register("mana_stone_pickaxe", ManaStonePickaxeItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
