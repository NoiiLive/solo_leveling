package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.AgilityTreadmillDisplayModel;
import net.clozynoii.slsb.block.display.AgilityTreadmillDisplayItem;

public class AgilityTreadmillDisplayItemRenderer extends GeoItemRenderer<AgilityTreadmillDisplayItem> {
	public AgilityTreadmillDisplayItemRenderer() {
		super(new AgilityTreadmillDisplayModel());
	}

	@Override
	public RenderType getRenderType(AgilityTreadmillDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
