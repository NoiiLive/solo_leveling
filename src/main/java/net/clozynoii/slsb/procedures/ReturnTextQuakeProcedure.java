package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnTextQuakeProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Quake" + ", ")) {
			return Component.translatable("slsb.skill.fighter.quake").getString();
		}
		return Component.translatable("slsb.skill.unknown").getString();
	}
}
