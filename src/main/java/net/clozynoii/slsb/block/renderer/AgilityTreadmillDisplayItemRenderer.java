package net.clozynoii.slsb.block.renderer;

public class AgilityTreadmillDisplayItemRenderer extends GeoItemRenderer<AgilityTreadmillDisplayItem> {
	public AgilityTreadmillDisplayItemRenderer() {
		super(new AgilityTreadmillDisplayModel());
	}

	@Override
	public RenderType getRenderType(AgilityTreadmillDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}