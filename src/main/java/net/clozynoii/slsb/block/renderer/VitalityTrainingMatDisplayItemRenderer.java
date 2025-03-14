package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.VitalityTrainingMatDisplayModel;
import net.clozynoii.slsb.block.display.VitalityTrainingMatDisplayItem;

public class VitalityTrainingMatDisplayItemRenderer extends GeoItemRenderer<VitalityTrainingMatDisplayItem> {
	public VitalityTrainingMatDisplayItemRenderer() {
		super(new VitalityTrainingMatDisplayModel());
	}

	@Override
	public RenderType getRenderType(VitalityTrainingMatDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
