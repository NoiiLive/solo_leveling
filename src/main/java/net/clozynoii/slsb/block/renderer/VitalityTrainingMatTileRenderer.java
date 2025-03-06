package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.VitalityTrainingMatBlockModel;
import net.clozynoii.slsb.block.entity.VitalityTrainingMatTileEntity;

public class VitalityTrainingMatTileRenderer extends GeoBlockRenderer<VitalityTrainingMatTileEntity> {
	public VitalityTrainingMatTileRenderer() {
		super(new VitalityTrainingMatBlockModel());
	}

	@Override
	public RenderType getRenderType(VitalityTrainingMatTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
