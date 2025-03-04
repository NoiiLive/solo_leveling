
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.clozynoii.slsb.entity.BloodredIgrisEntity;
import net.clozynoii.slsb.SlsbMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SlsbModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SlsbMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BloodredIgrisEntity>> BLOODRED_IGRIS = register("bloodred_igris",
			EntityType.Builder.<BloodredIgrisEntity>of(BloodredIgrisEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).fireImmune().sized(1f, 3f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BloodredIgrisEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BLOODRED_IGRIS.get(), BloodredIgrisEntity.createAttributes().build());
	}
}
