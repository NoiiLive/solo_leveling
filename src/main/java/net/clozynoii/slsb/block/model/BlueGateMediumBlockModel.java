package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.BlueGateMediumTileEntity;

public class BlueGateMediumBlockModel extends GeoModel<BlueGateMediumTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueGateMediumTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:animations/bluegatemedium.animation.json");
		return ResourceLocation.parse("slsb:animations/bluegatemedium.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueGateMediumTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:geo/bluegatemedium.geo.json");
		return ResourceLocation.parse("slsb:geo/bluegatemedium.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueGateMediumTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:textures/block/mediumredgatetexture.png");
		return ResourceLocation.parse("slsb:textures/block/mediumbluegatetexture.png");
	}
}
