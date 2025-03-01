package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerRespawnsProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.PlayerMana = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength > 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerStrength = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Death Penalty: Stats have decreased by 1."), true);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility > 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerAgility = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Death Penalty: Stats have decreased by 1."), true);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerPerception > 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerPerception = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerPerception - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Death Penalty: Stats have decreased by 1."), true);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality > 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerVitality = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Death Penalty: Stats have decreased by 1."), true);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence > 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerIntelligence = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Death Penalty: Stats have decreased by 1."), true);
		}
	}
}
