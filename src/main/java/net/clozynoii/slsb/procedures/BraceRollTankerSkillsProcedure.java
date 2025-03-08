package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

public class BraceRollTankerSkillsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClassRolls = 0;
		double RandomSkill = 0;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("E")) {
			ClassRolls = 0;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("D")) {
			ClassRolls = 1;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("C")) {
			ClassRolls = 1;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("B")) {
			ClassRolls = 2;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("A")) {
			ClassRolls = 2;
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("S")) {
			ClassRolls = 3;
		}
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Taunt" + ", ";
			_vars.syncPlayerVariables(entity);
		}
		while (ClassRolls > 0) {
			RandomSkill = Mth.nextInt(RandomSource.create(), 1, 9);
			if (RandomSkill == 1) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Collapse" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Collapse" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 2) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Power Smash" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Power Smash" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 3) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Mana Shield" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Mana Shield" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 4) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Strengthening" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Strengthening" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 5) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Charge" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Charge" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 6) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Stride" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Stride" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 7) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Unyielding Roar" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Unyielding Roar" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 8) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Iron Grasp" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Iron Grasp" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			}
			if (ClassRolls == 0) {
				SlsbMod.LOGGER.debug(entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills);
				break;
			} else {
				continue;
			}
		}
	}
}
