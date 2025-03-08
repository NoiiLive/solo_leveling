package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

public class RollMageSkillsIceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ClassRolls = 0;
		double RandomSkill = 0;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("E")) {
			ClassRolls = 1;
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
			RandomSkill = Mth.nextInt(RandomSource.create(), 1, 7);
			if (RandomSkill == 1) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Ice Wall" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Ice Wall" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 2) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Blizzard" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Blizzard" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 3) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Subzero" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Subzero" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 4) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Glacial Torrent" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Glacial Torrent" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 5) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Ice Spikes" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Ice Spikes" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 6) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Avalanche" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Avalanche" + ", ";
						_vars.syncPlayerVariables(entity);
					}
					ClassRolls = ClassRolls - 1;
				}
			} else if (RandomSkill == 7) {
				if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Icicles" + ", ")) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.UnlockedSkills = entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills + "Icicles" + ", ";
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
