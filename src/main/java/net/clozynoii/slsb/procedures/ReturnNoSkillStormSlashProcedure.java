package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnNoSkillStormSlashProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Storm Slash" + ", ")) {
			return true;
		}
		return false;
	}
}
