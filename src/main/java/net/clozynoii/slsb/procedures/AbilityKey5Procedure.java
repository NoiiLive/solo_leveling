package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class AbilityKey5Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == false) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.KeyHeld = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.KeyHeld = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			UseAbilities5aProcedure.execute(entity);
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			UseAbilities5bProcedure.execute(entity);
		}
	}
}
