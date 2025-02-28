package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.AwakeningOrbDisplayModel;
import net.clozynoii.slsb.block.display.AwakeningOrbDisplayItem;

public class AwakeningOrbDisplayItemRenderer extends GeoItemRenderer<AwakeningOrbDisplayItem> {
	public AwakeningOrbDisplayItemRenderer() {
		super(new AwakeningOrbDisplayModel());
	}

	@Override
	public RenderType getRenderType(AwakeningOrbDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
