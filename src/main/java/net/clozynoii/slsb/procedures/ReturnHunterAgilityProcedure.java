package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnHunterAgilityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 1 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 20) {
			return "[E]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 20 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 35) {
			return "[D]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 35 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 50) {
			return "[C]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 50 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 65) {
			return "[B]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 65 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 85) {
			return "[A]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility >= 85 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAgility < 100) {
			return "[S]";
		}
		return "[F]";
	}
}
