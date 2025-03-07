package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnSelectedRangerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).GUISelectedClass).equals("Ranger")) {
			return true;
		}
		return false;
	}
}
