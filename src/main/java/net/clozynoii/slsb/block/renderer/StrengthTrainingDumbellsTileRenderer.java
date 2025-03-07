package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.StrengthTrainingDumbellsBlockModel;
import net.clozynoii.slsb.block.entity.StrengthTrainingDumbellsTileEntity;

public class StrengthTrainingDumbellsTileRenderer extends GeoBlockRenderer<StrengthTrainingDumbellsTileEntity> {
	public StrengthTrainingDumbellsTileRenderer() {
		super(new StrengthTrainingDumbellsBlockModel());
	}

	@Override
	public RenderType getRenderType(StrengthTrainingDumbellsTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
