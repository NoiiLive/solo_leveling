package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.clozynoii.slsb.network.SlsbModVariables;

public class AbilityBarrageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double cooldown = 0;
		boolean gate = false;
		String ability = "";
		gate = false;
		cooldown = 5;
		ability = "Barrage";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.Barraging = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = 99999;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == false) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.Barraging = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = 10;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).NoCooldowns == false) {
				if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1 || entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown1a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown2a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability3a).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown3a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown4a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability5a).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown5a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown1b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2b).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown2b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability3b).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown3b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4b).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown4b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability5b).equals(ability)) {
						{
							SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
							_vars.Cooldown5b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
			if (world.isClientSide()) {
				SetupAnimationsProcedure.setAnimationClientside((Player) entity, "", false);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player)
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.SlsbModAnimationMessage("", entity.getId(), false));
			}
		}
	}
}
