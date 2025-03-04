
package net.clozynoii.slsb.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.clozynoii.slsb.procedures.ParalyzedTickProcedure;

import java.util.Set;

public class ParalyzedMobEffect extends MobEffect {
	public ParalyzedMobEffect() {
		super(MobEffectCategory.HARMFUL, -16724992);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ParalyzedTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
