package net.clozynoii.slsb.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.entity.BloodredIgrisEntity;

public class BloodredIgrisModel extends GeoModel<BloodredIgrisEntity> {
	@Override
	public ResourceLocation getAnimationResource(BloodredIgrisEntity entity) {
		return ResourceLocation.parse("slsb:animations/bloodred_igris.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BloodredIgrisEntity entity) {
		return ResourceLocation.parse("slsb:geo/bloodred_igris.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BloodredIgrisEntity entity) {
		return ResourceLocation.parse("slsb:textures/entities/" + entity.getTexture() + ".png");
	}

}
