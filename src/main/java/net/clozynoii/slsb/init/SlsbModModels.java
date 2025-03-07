
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.slsb.client.model.Modelmining_armor;
import net.clozynoii.slsb.client.model.Modeligris_armor;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SlsbModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeligris_armor.LAYER_LOCATION, Modeligris_armor::createBodyLayer);
		event.registerLayerDefinition(Modelmining_armor.LAYER_LOCATION, Modelmining_armor::createBodyLayer);
	}
}
