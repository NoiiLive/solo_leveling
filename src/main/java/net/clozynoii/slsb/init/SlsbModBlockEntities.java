
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.clozynoii.slsb.block.entity.VitalityTrainingMatTileEntity;
import net.clozynoii.slsb.block.entity.StrengthTrainingDumbellsTileEntity;
import net.clozynoii.slsb.block.entity.ManaTrainingOrbTileEntity;
import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;
import net.clozynoii.slsb.block.entity.BlueGateMediumTileEntity;
import net.clozynoii.slsb.block.entity.AwakeningOrbTileEntity;
import net.clozynoii.slsb.block.entity.AgilityTreadmillTileEntity;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SlsbMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> AWAKENING_ORB = register("awakening_orb", SlsbModBlocks.AWAKENING_ORB, AwakeningOrbTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BLUE_GATE_SMALL = register("blue_gate_small", SlsbModBlocks.BLUE_GATE_SMALL, BlueGateSmallTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BLUE_GATE_MEDIUM = register("blue_gate_medium", SlsbModBlocks.BLUE_GATE_MEDIUM, BlueGateMediumTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MANA_TRAINING_ORB = register("mana_training_orb", SlsbModBlocks.MANA_TRAINING_ORB, ManaTrainingOrbTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> STRENGTH_TRAINING_DUMBELLS = register("strength_training_dumbells", SlsbModBlocks.STRENGTH_TRAINING_DUMBELLS, StrengthTrainingDumbellsTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> AGILITY_TREADMILL = register("agility_treadmill", SlsbModBlocks.AGILITY_TREADMILL, AgilityTreadmillTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> VITALITY_TRAINING_MAT = register("vitality_training_mat", SlsbModBlocks.VITALITY_TRAINING_MAT, VitalityTrainingMatTileEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
