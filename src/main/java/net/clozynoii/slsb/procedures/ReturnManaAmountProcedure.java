package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnManaAmountProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 9
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 0) {
			return 1;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 18
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 9) {
			return 2;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 27
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 18) {
			return 3;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 36
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 27) {
			return 4;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 45
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 36) {
			return 5;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 54
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 45) {
			return 6;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 63
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 54) {
			return 7;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 72
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 63) {
			return 8;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 81
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 72) {
			return 9;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 90
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 81) {
			return 10;
		}
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 <= 100
				&& (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana / entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) * 100 > 90) {
			return 11;
		}
		return 0;
	}
}
