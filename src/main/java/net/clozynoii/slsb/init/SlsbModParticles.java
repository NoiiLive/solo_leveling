
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.slsb.client.particle.CircleSmallParticle;
import net.clozynoii.slsb.client.particle.CircleMediumParticle;
import net.clozynoii.slsb.client.particle.CircleLargeParticle;
import net.clozynoii.slsb.client.particle.CircleBarrageParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SlsbModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(SlsbModParticleTypes.CIRCLE_LARGE.get(), CircleLargeParticle::provider);
		event.registerSpriteSet(SlsbModParticleTypes.CIRCLE_MEDIUM.get(), CircleMediumParticle::provider);
		event.registerSpriteSet(SlsbModParticleTypes.CIRCLE_SMALL.get(), CircleSmallParticle::provider);
		event.registerSpriteSet(SlsbModParticleTypes.CIRCLE_BARRAGE.get(), CircleBarrageParticle::provider);
	}
}
