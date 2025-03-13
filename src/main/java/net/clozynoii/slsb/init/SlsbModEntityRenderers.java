
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.slsb.client.renderer.IgrisShadowRenderer;
import net.clozynoii.slsb.client.renderer.GoblinShadowRenderer;
import net.clozynoii.slsb.client.renderer.GoblinRogueShadowRenderer;
import net.clozynoii.slsb.client.renderer.GoblinRogueRenderer;
import net.clozynoii.slsb.client.renderer.GoblinRenderer;
import net.clozynoii.slsb.client.renderer.BloodredIgrisRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SlsbModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SlsbModEntities.BLOODRED_IGRIS.get(), BloodredIgrisRenderer::new);
		event.registerEntityRenderer(SlsbModEntities.GOBLIN.get(), GoblinRenderer::new);
		event.registerEntityRenderer(SlsbModEntities.GOBLIN_SHADOW.get(), GoblinShadowRenderer::new);
		event.registerEntityRenderer(SlsbModEntities.IGRIS_SHADOW.get(), IgrisShadowRenderer::new);
		event.registerEntityRenderer(SlsbModEntities.GOBLIN_ROGUE.get(), GoblinRogueRenderer::new);
		event.registerEntityRenderer(SlsbModEntities.GOBLIN_ROGUE_SHADOW.get(), GoblinRogueShadowRenderer::new);
	}
}
