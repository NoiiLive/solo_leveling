package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnCooldown5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5a > 0) {
				return true;
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5b > 0) {
				return true;
			}
		}
		return false;
	}
}
