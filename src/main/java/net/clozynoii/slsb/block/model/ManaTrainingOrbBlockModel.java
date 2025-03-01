package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.ManaTrainingOrbTileEntity;

public class ManaTrainingOrbBlockModel extends GeoModel<ManaTrainingOrbTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ManaTrainingOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:animations/mana_orb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ManaTrainingOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:geo/mana_orb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ManaTrainingOrbTileEntity animatable) {
		return ResourceLocation.parse("slsb:textures/block/mana_orb.png");
	}
}
