package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnTextSlaughtererProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Slaughterer" + ", ")) {
			return Component.translatable("slsb.skill.assassin.slaughterer").getString();
		}
		return Component.translatable("slsb.skill.unknown").getString();
	}
}
