package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.VitalityTrainingMatDisplayItem;

public class VitalityTrainingMatDisplayModel extends GeoModel<VitalityTrainingMatDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(VitalityTrainingMatDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/training_mat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VitalityTrainingMatDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/training_mat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VitalityTrainingMatDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/training_mat.png");
	}
}
