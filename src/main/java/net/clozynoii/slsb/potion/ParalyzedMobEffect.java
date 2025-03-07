
package net.clozynoii.slsb.potion;

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
		ParalyzedTickProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}