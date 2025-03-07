package net.clozynoii.slsb.block.renderer;

public class StrengthTrainingDumbellsDisplayItemRenderer extends GeoItemRenderer<StrengthTrainingDumbellsDisplayItem> {
	public StrengthTrainingDumbellsDisplayItemRenderer() {
		super(new StrengthTrainingDumbellsDisplayModel());
	}

	@Override
	public RenderType getRenderType(StrengthTrainingDumbellsDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}