package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.StrengthTrainingDumbellsTileEntity;

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
