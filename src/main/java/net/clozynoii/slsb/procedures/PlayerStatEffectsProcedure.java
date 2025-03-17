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
		double StrengthScaling = 0;
		double HealthScaling = 0;
		double AgilityScaling = 0;
		double FullSpeed = 0;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).SystemPlayer == true) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerMaxMana = Math.round(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence * 500);
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength * 0.5));
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity1.getAttribute(Attributes.MAX_HEALTH).setBaseValue((20 + Math.round(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality * 0.4)));
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity2.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((0.1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility * 0.005));
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
				_livingEntity3.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1);
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.MaxShadows = Math.round(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence / 2);
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).SystemPlayer == false) {
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("E")) {
				ManaBase = 10;
				ManaScaling = 10;
				StrengthScaling = 0.04;
				HealthScaling = 0.05;
				AgilityScaling = 0.001;
			} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("D")) {
				ManaBase = 50;
				ManaScaling = 25;
				StrengthScaling = 0.09;
				HealthScaling = 0.1;
				AgilityScaling = 0.002;
			} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("C")) {
				ManaBase = 100;
				ManaScaling = 10;
				StrengthScaling = 0.24;
				HealthScaling = 0.2;
				AgilityScaling = 0.003;
			} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("B")) {
				ManaBase = 500;
				ManaScaling = 25;
				StrengthScaling = 0.49;
				HealthScaling = 0.3;
				AgilityScaling = 0.005;
			} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("A")) {
				ManaBase = 1000;
				ManaScaling = 5;
				StrengthScaling = 0.74;
				HealthScaling = 0.5;
				AgilityScaling = 0.007;
			} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("S")) {
				ManaBase = 10000;
				ManaScaling = 10;
				StrengthScaling = 1;
				HealthScaling = 0.8;
				AgilityScaling = 0.009;
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerMaxMana = Math.round(ManaBase * (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence / ManaScaling));
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
				_livingEntity4.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength * HealthScaling));
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity6.getAttribute(Attributes.MAX_HEALTH).setBaseValue((20 + Math.round(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality * StrengthScaling)));
			if (entity.isSprinting()) {
				if (FullSpeed < 0.1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility * AgilityScaling) {
					FullSpeed = (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity8.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.01;
				} else if (FullSpeed > 0.1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility * AgilityScaling) {
					FullSpeed = 0.1 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility * AgilityScaling;
				}
			} else {
				if (FullSpeed > 0.1) {
					FullSpeed = (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) - 0.01;
				} else if (FullSpeed < 0.1) {
					FullSpeed = 0.1;
				}
			}
			if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity10.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(FullSpeed);
		}
	}
}
