package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnAbility1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals("Heavy Attack")) {
				return 1;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals("Barrage")) {
				return 2;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals("Slam")) {
				return 3;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals("Uppercut")) {
				return 4;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals("Dash")) {
				return 5;
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals("Heavy Attack")) {
				return 1;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals("Barrage")) {
				return 2;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals("Slam")) {
				return 3;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals("Uppercut")) {
				return 4;
			}
			if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals("Dash")) {
				return 5;
			}
		}
		return 0;
	}
}
