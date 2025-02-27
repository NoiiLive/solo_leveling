
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.clozynoii.slsb.SlsbMod;

public class SlsbModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, SlsbMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_LARGE = REGISTRY.register("circle_large", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_MEDIUM = REGISTRY.register("circle_medium", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_SMALL = REGISTRY.register("circle_small", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_BARRAGE = REGISTRY.register("circle_barrage", () -> new SimpleParticleType(true));
}
