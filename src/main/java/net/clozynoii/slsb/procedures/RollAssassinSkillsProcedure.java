package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

public class RollAssassinSkillsProcedure {
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
		while (ClassRolls > 0) {
			RandomSkill = Mth.nextInt(RandomSource.create(), 1, 8);
			if (RandomSkill == 1) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Stealth" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Stealth" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 2) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Dagger Throw" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Dagger Throw" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 3) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Critical Strike" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Critical Strike" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 4) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Slaughterer" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Slaughterer" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 5) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Backstab" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Backstab" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 6) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Quick Reflex" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Quick Reflex" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 7) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Whirl Cut" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Whirl Cut" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 8) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Flicker Fang" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Flicker Fang" + ", ";
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
