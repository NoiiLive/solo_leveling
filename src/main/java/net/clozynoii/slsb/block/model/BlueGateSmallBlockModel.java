package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;

public class BlueGateSmallBlockModel extends GeoModel<BlueGateSmallTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueGateSmallTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:animations/bluegatesmall.animation.json");
		return ResourceLocation.parse("slsb:animations/bluegatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueGateSmallTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:geo/bluegatesmall.geo.json");
		return ResourceLocation.parse("slsb:geo/bluegatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueGateSmallTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return ResourceLocation.parse("slsb:textures/block/smallredgatetexture.png");
		return ResourceLocation.parse("slsb:textures/block/smallbluegatetexture.png");
	}
}
