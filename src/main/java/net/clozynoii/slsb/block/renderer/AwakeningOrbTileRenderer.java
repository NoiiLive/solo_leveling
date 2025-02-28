package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.AwakeningOrbBlockModel;
import net.clozynoii.slsb.block.entity.AwakeningOrbTileEntity;

public class AwakeningOrbTileRenderer extends GeoBlockRenderer<AwakeningOrbTileEntity> {
	public AwakeningOrbTileRenderer() {
		super(new AwakeningOrbBlockModel());
	}

	@Override
	public RenderType getRenderType(AwakeningOrbTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
