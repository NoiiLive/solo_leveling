package net.clozynoii.slsb.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
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

	@Override
	public void setCustomAnimations(BloodredIgrisEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
