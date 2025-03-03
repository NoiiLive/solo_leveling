package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerStatEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double ManaBase = 0;
		double ManaScaling = 0;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("E")) {
			ManaBase = 10;
			ManaScaling = 10;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("D")) {
			ManaBase = 50;
			ManaScaling = 25;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("C")) {
			ManaBase = 100;
			ManaScaling = 10;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("B")) {
			ManaBase = 500;
			ManaScaling = 25;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("A")) {
			ManaBase = 1000;
			ManaScaling = 5;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("S")) {
			ManaBase = 10000;
			ManaScaling = 10;
		}
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.PlayerMaxMana = Math.round(ManaBase * (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence / ManaScaling));
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
			_livingEntity0.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1);
		if (entity.isAlive()) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength / 20));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity3.getAttribute(Attributes.MAX_HEALTH).setBaseValue((20 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality / 2.5));
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity4.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((0.1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility / 120));
		}
	}
}
