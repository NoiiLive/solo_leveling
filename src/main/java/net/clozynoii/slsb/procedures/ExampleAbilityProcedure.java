package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ExampleAbilityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double cooldown = 0;
		boolean gate = false;
		String ability = "";
		gate = false;
		cooldown = 3;
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.InputDelay = 10;
			_vars.syncPlayerVariables(entity);
		}
		ability = "Example";
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
	}
}
