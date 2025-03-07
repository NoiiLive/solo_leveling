package net.clozynoii.slsb.block.model;

public class StrengthTrainingDumbellsBlockModel extends GeoModel<StrengthTrainingDumbellsTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(StrengthTrainingDumbellsTileEntity animatable) {
		return ResourceLocation.parse("slsb:animations/dumbells.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StrengthTrainingDumbellsTileEntity animatable) {
		return ResourceLocation.parse("slsb:geo/dumbells.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StrengthTrainingDumbellsTileEntity animatable) {
		return ResourceLocation.parse("slsb:textures/block/dumbells.png");
	}
}