package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.clozynoii.slsb.init.SlsbModMobEffects;
import net.clozynoii.slsb.init.SlsbModBlocks;

public class BleedingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("bleedtick", (entity.getPersistentData().getDouble("bleedtick") + 1));
		if (entity.getPersistentData().getDouble("bleedtick") >= 20) {
			entity.getPersistentData().putDouble("bleedtick", 0);
			world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(SlsbModBlocks.BLOOD_BLOCK.get().defaultBlockState()));
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(SlsbModMobEffects.BLEEDING) ? _livEnt.getEffect(SlsbModMobEffects.BLEEDING).getAmplifier() : 0) == 1) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.05));
			} else {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.01));
			}
		}
	}
}
