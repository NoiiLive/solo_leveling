
package net.clozynoii.slsb.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.entity.model.BloodredIgrisModel;
import net.clozynoii.slsb.entity.layer.BloodredIgrisLayer;
import net.clozynoii.slsb.entity.BloodredIgrisEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BloodredIgrisRenderer extends GeoEntityRenderer<BloodredIgrisEntity> {
	public BloodredIgrisRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BloodredIgrisModel());
		this.shadowRadius = 0.6f;
		this.addRenderLayer(new BloodredIgrisLayer(this));
	}

	@Override
	public RenderType getRenderType(BloodredIgrisEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, BloodredIgrisEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1.1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(BloodredIgrisEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
