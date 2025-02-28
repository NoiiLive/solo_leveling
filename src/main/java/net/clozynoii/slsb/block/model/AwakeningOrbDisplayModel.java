package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.AwakeningOrbDisplayItem;

public class AwakeningOrbDisplayModel extends GeoModel<AwakeningOrbDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AwakeningOrbDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/awakeningorb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AwakeningOrbDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/awakeningorb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AwakeningOrbDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/awakeningorbtexture.png");
	}
}
