package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

public class RollHealerSkillsProcedure {
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
			_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Heal" + ", ";
			_vars.syncPlayerVariables(entity);
		}
		while (ClassRolls > 0) {
			RandomSkill = Mth.nextInt(RandomSource.create(), 1, 5);
			if (RandomSkill == 1) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Hasten" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Hasten" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 2) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Strengthen" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Strengthen" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 3) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Sacred Shield" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Sacred Shield" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 4) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Purify" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Purify" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 5) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Safeguard" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Safeguard" + ", ";
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
