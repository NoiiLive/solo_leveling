package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.StrengthTrainingDumbellsDisplayItem;

public class StrengthTrainingDumbellsDisplayModel extends GeoModel<StrengthTrainingDumbellsDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(StrengthTrainingDumbellsDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/dumbells.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StrengthTrainingDumbellsDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/dumbells.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StrengthTrainingDumbellsDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/dumbells.png");
	}
}
