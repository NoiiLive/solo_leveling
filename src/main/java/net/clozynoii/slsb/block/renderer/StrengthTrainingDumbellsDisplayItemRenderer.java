package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.StrengthTrainingDumbellsDisplayModel;
import net.clozynoii.slsb.block.display.StrengthTrainingDumbellsDisplayItem;

public class StrengthTrainingDumbellsDisplayItemRenderer extends GeoItemRenderer<StrengthTrainingDumbellsDisplayItem> {
	public StrengthTrainingDumbellsDisplayItemRenderer() {
		super(new StrengthTrainingDumbellsDisplayModel());
	}

	@Override
	public RenderType getRenderType(StrengthTrainingDumbellsDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
