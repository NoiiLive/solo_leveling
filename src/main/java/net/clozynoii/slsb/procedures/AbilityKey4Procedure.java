package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class AbilityKey4Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
			UseAbilities4aProcedure.execute(world, x, y, z, entity);
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			UseAbilities4bProcedure.execute(world, x, y, z, entity);
		}
	}
}
