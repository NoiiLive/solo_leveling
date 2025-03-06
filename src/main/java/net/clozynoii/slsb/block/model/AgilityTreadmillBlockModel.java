package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.AgilityTreadmillTileEntity;

public class AgilityTreadmillBlockModel extends GeoModel<AgilityTreadmillTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AgilityTreadmillTileEntity animatable) {
		return ResourceLocation.parse("slsb:animations/treadmill.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AgilityTreadmillTileEntity animatable) {
		return ResourceLocation.parse("slsb:geo/treadmill.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AgilityTreadmillTileEntity animatable) {
		return ResourceLocation.parse("slsb:textures/block/treadmill.png");
	}
}
