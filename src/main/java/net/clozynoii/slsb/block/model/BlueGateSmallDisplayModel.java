package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.BlueGateSmallDisplayItem;

public class BlueGateSmallDisplayModel extends GeoModel<BlueGateSmallDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BlueGateSmallDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/bluegatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueGateSmallDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/bluegatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueGateSmallDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/smallbluegatetexture.png");
	}
}
