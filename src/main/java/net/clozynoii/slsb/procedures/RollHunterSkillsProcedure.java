package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class RollHunterSkillsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Fighter")) {
			RollFighterSkillsProcedure.execute(entity);
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Assassin")) {
			RollAssassinSkillsProcedure.execute(entity);
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Tanker")) {
			BraceRollTankerSkillsProcedure.execute(entity);
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Ranger")) {
			RollRangerSkillsProcedure.execute(entity);
		} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Healer")) {
			RollHealerSkillsProcedure.execute(entity);
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Mage")) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Barrier")) {
				RollMageSkillsBarrierProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Curse")) {
				RollMageSkillsCurseProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Spatial")) {
				RollMageSkillsSpatialProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Summon")) {
				RollMageSkillsSummonerProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Fire")) {
				RollMageSkillsFireProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Ice")) {
				RollMageSkillsIceProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Water")) {
				RollMageSkillsWaterProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Earth")) {
				RollMageSkillsEarthProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Wind")) {
				RollMageSkillsWindProcedure.execute(entity);
			} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass.contains("Electric")) {
				RollMageSkillsLightningProcedure.execute(entity);
			}
		}
	}
}
