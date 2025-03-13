
package net.clozynoii.slsb.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.entity.model.GoblinRogueModel;
import net.clozynoii.slsb.entity.layer.GoblinRogueLayer;
import net.clozynoii.slsb.entity.GoblinRogueEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinRogueRenderer extends GeoEntityRenderer<GoblinRogueEntity> {
	public GoblinRogueRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GoblinRogueModel());
		this.shadowRadius = 0.4f;
		this.addRenderLayer(new GoblinRogueLayer(this));
	}

	@Override
	public RenderType getRenderType(GoblinRogueEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GoblinRogueEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(GoblinRogueEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
