package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.BlueGateMediumDisplayModel;
import net.clozynoii.slsb.block.display.BlueGateMediumDisplayItem;

public class BlueGateMediumDisplayItemRenderer extends GeoItemRenderer<BlueGateMediumDisplayItem> {
	public BlueGateMediumDisplayItemRenderer() {
		super(new BlueGateMediumDisplayModel());
	}

	@Override
	public RenderType getRenderType(BlueGateMediumDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
