package net.clozynoii.slsb.block.renderer;

public class VitalityTrainingMatTileRenderer extends GeoBlockRenderer<VitalityTrainingMatTileEntity> {
	public VitalityTrainingMatTileRenderer() {
		super(new VitalityTrainingMatBlockModel());
	}

	@Override
	public RenderType getRenderType(VitalityTrainingMatTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}