package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.ManaTrainingOrbDisplayItem;

public class ManaTrainingOrbDisplayModel extends GeoModel<ManaTrainingOrbDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ManaTrainingOrbDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/mana_orb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ManaTrainingOrbDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/mana_orb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ManaTrainingOrbDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/mana_orb.png");
	}
}
