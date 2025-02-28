package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.AwakeningOrbTileEntity;

public class AwakeningOrbBlockModel extends GeoModel<AwakeningOrbTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AwakeningOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:animations/awakeningorb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AwakeningOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:geo/awakeningorb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AwakeningOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:textures/block/awakeningorbtexture.png");
	}
}
