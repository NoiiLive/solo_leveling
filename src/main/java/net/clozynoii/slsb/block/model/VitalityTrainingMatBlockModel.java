package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.VitalityTrainingMatTileEntity;

public class VitalityTrainingMatBlockModel extends GeoModel<VitalityTrainingMatTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(VitalityTrainingMatTileEntity animatable) {
		return ResourceLocation.parse("slsb:animations/training_mat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VitalityTrainingMatTileEntity animatable) {
		return ResourceLocation.parse("slsb:geo/training_mat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VitalityTrainingMatTileEntity animatable) {
		return ResourceLocation.parse("slsb:textures/block/training_mat.png");
	}
}
