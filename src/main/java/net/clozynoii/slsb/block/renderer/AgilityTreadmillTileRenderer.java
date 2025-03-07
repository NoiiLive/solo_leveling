package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.AgilityTreadmillBlockModel;
import net.clozynoii.slsb.block.entity.AgilityTreadmillTileEntity;

public class AgilityTreadmillTileRenderer extends GeoBlockRenderer<AgilityTreadmillTileEntity> {
	public AgilityTreadmillTileRenderer() {
		super(new AgilityTreadmillBlockModel());
	}

	@Override
	public RenderType getRenderType(AgilityTreadmillTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
