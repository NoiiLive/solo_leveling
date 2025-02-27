
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.clozynoii.slsb.SlsbMod;

public class SlsbModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, SlsbMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> WHOOSH = REGISTRY.register("whoosh", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("slsb", "whoosh")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BASIC_HIT = REGISTRY.register("basic_hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("slsb", "basic_hit")));
}
