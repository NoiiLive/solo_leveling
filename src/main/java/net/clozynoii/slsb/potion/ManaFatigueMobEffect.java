
package net.clozynoii.slsb.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.Set;

public class ManaFatigueMobEffect extends MobEffect {
	public ManaFatigueMobEffect() {
		super(MobEffectCategory.HARMFUL, -9622628);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}
}
