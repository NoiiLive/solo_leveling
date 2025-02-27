package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class AbilityBarKeyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		gate = false;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1 && gate == false) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.AbilityBar = 2;
				_vars.syncPlayerVariables(entity);
			}
			gate = true;
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2 && gate == false) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.AbilityBar = 1;
				_vars.syncPlayerVariables(entity);
			}
			gate = true;
		}
	}
}
