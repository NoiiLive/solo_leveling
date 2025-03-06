package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnHunterIntelligenceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 1 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence < 20) {
			return "[E]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 20 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence < 35) {
			return "[D]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 35 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence < 50) {
			return "[C]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 50 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence < 65) {
			return "[B]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 65 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence < 85) {
			return "[A]";
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence >= 85 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence <= 100) {
			return "[S]";
		}
		return "[F]";
	}
}
