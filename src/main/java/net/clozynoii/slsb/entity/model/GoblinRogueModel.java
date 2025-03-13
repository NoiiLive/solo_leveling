package net.clozynoii.slsb.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.entity.GoblinRogueEntity;

public class GoblinRogueModel extends GeoModel<GoblinRogueEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinRogueEntity entity) {
		return ResourceLocation.parse("slsb:animations/goblin_rogue.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinRogueEntity entity) {
		return ResourceLocation.parse("slsb:geo/goblin_rogue.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinRogueEntity entity) {
		return ResourceLocation.parse("slsb:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(GoblinRogueEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
