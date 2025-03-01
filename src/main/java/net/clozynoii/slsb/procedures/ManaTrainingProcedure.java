package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModMobEffects;

public class ManaTrainingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SlsbModMobEffects.MANA_FATIGUE))) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana >= entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana / 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("INT : " + new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence) + " > "
							+ new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence + 1))), true);
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerMana = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana - entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana / 4;
					_vars.syncPlayerVariables(entity);
				}
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.ManaRegenTimer = 10;
					_vars.syncPlayerVariables(entity);
				}
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerIntelligence = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 0.5), (z + 0.5), 10, 0.1, 0.1, 0.1, 0.1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(SlsbModMobEffects.MANA_FATIGUE, 600, 0, false, false));
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You do not have enough mana to train"), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Your mana is currently fatigued"), true);
		}
	}
}
