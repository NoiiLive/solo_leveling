
package net.clozynoii.slsb.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.SlsbMod;

import java.util.Set;

public class ParalyzedMobEffect extends MobEffect {
	public ParalyzedMobEffect() {
		super(MobEffectCategory.HARMFUL, -16724992);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "effect.paralyzed_0"), -5, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}
}
