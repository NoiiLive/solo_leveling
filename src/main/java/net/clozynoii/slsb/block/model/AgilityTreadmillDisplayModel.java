package net.clozynoii.slsb.block.model;

public class AgilityTreadmillDisplayModel extends GeoModel<AgilityTreadmillDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AgilityTreadmillDisplayItem animatable) {
		return ResourceLocation.parse("slsb:animations/treadmill.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AgilityTreadmillDisplayItem animatable) {
		return ResourceLocation.parse("slsb:geo/treadmill.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AgilityTreadmillDisplayItem entity) {
		return ResourceLocation.parse("slsb:textures/block/treadmill.png");
	}
}