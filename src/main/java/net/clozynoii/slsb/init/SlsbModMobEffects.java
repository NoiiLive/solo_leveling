
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.clozynoii.slsb.potion.ParalyzedMobEffect;
import net.clozynoii.slsb.potion.NoFallMobEffect;
import net.clozynoii.slsb.potion.ManaFatigueMobEffect;
import net.clozynoii.slsb.potion.BleedingMobEffect;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, SlsbMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> NO_FALL = REGISTRY.register("no_fall", () -> new NoFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MANA_FATIGUE = REGISTRY.register("mana_fatigue", () -> new ManaFatigueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PARALYZED = REGISTRY.register("paralyzed", () -> new ParalyzedMobEffect());
}
