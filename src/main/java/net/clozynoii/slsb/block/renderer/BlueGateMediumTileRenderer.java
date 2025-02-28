package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.BlueGateMediumBlockModel;
import net.clozynoii.slsb.block.entity.BlueGateMediumTileEntity;

public class BlueGateMediumTileRenderer extends GeoBlockRenderer<BlueGateMediumTileEntity> {
	public BlueGateMediumTileRenderer() {
		super(new BlueGateMediumBlockModel());
	}

	@Override
	public RenderType getRenderType(BlueGateMediumTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
