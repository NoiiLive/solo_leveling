package net.clozynoii.slsb.block.renderer;

public class StrengthTrainingDumbellsTileRenderer extends GeoBlockRenderer<StrengthTrainingDumbellsTileEntity> {
	public StrengthTrainingDumbellsTileRenderer() {
		super(new StrengthTrainingDumbellsBlockModel());
	}

	@Override
	public RenderType getRenderType(StrengthTrainingDumbellsTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}