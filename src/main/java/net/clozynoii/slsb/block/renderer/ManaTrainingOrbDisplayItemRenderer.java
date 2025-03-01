package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.ManaTrainingOrbDisplayModel;
import net.clozynoii.slsb.block.display.ManaTrainingOrbDisplayItem;

public class ManaTrainingOrbDisplayItemRenderer extends GeoItemRenderer<ManaTrainingOrbDisplayItem> {
	public ManaTrainingOrbDisplayItemRenderer() {
		super(new ManaTrainingOrbDisplayModel());
	}

	@Override
	public RenderType getRenderType(ManaTrainingOrbDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
