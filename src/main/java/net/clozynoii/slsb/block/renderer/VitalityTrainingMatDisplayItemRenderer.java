package net.clozynoii.slsb.block.renderer;

public class VitalityTrainingMatDisplayItemRenderer extends GeoItemRenderer<VitalityTrainingMatDisplayItem> {
	public VitalityTrainingMatDisplayItemRenderer() {
		super(new VitalityTrainingMatDisplayModel());
	}

	@Override
	public RenderType getRenderType(VitalityTrainingMatDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}