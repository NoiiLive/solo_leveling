
package net.clozynoii.slsb.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.entity.model.GoblinRogueShadowModel;
import net.clozynoii.slsb.entity.layer.GoblinRogueShadowLayer;
import net.clozynoii.slsb.entity.GoblinRogueShadowEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinRogueShadowRenderer extends GeoEntityRenderer<GoblinRogueShadowEntity> {
	public GoblinRogueShadowRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GoblinRogueShadowModel());
		this.shadowRadius = 0.4f;
		this.addRenderLayer(new GoblinRogueShadowLayer(this));
	}

	@Override
	public RenderType getRenderType(GoblinRogueShadowEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GoblinRogueShadowEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(GoblinRogueShadowEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
