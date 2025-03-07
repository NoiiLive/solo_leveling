
package net.clozynoii.slsb.potion;

public class MuscleFatigueMobEffect extends MobEffect {
	public MuscleFatigueMobEffect() {
		super(MobEffectCategory.HARMFUL, -39322);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "effect.muscle_fatigue_0"), -0.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "effect.muscle_fatigue_1"), -0.01, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}
}