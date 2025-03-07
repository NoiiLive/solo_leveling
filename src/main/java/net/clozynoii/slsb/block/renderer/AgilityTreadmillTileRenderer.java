package net.clozynoii.slsb.block.renderer;

public class AgilityTreadmillTileRenderer extends GeoBlockRenderer<AgilityTreadmillTileEntity> {
	public AgilityTreadmillTileRenderer() {
		super(new AgilityTreadmillBlockModel());
	}

	@Override
	public RenderType getRenderType(AgilityTreadmillTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}