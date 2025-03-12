
package net.clozynoii.slsb.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.entity.model.GoblinShadowModel;
import net.clozynoii.slsb.entity.layer.GoblinShadowLayer;
import net.clozynoii.slsb.entity.GoblinShadowEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinShadowRenderer extends GeoEntityRenderer<GoblinShadowEntity> {
	public GoblinShadowRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GoblinShadowModel());
		this.shadowRadius = 0.4f;
		this.addRenderLayer(new GoblinShadowLayer(this));
	}

	@Override
	public RenderType getRenderType(GoblinShadowEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GoblinShadowEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(GoblinShadowEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
