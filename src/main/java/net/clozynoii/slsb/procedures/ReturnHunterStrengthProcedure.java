package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnHunterStrengthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 1 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 20) {
			return "[E]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 20 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 35) {
			return "[D]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 35 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 50) {
			return "[C]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 50 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 65) {
			return "[B]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 65 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 85) {
			return "[A]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength >= 85 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerStrength < 100) {
			return "[S]";
		}
		return "[F]";
	}
}
