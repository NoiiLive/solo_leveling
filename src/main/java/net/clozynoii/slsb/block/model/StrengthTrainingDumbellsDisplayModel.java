package net.clozynoii.slsb.block.model;

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