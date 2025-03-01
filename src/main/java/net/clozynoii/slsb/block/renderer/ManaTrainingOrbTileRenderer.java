package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.ManaTrainingOrbBlockModel;
import net.clozynoii.slsb.block.entity.ManaTrainingOrbTileEntity;

public class ManaTrainingOrbTileRenderer extends GeoBlockRenderer<ManaTrainingOrbTileEntity> {
	public ManaTrainingOrbTileRenderer() {
		super(new ManaTrainingOrbBlockModel());
	}

	@Override
	public RenderType getRenderType(ManaTrainingOrbTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
