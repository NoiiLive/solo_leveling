
package net.clozynoii.slsb.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.entity.model.IgrisShadowModel;
import net.clozynoii.slsb.entity.layer.IgrisShadowLayer;
import net.clozynoii.slsb.entity.IgrisShadowEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class IgrisShadowRenderer extends GeoEntityRenderer<IgrisShadowEntity> {
	public IgrisShadowRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new IgrisShadowModel());
		this.shadowRadius = 0.6f;
		this.addRenderLayer(new IgrisShadowLayer(this));
	}

	@Override
	public RenderType getRenderType(IgrisShadowEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, IgrisShadowEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1.1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(IgrisShadowEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
