package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnTextManaShieldProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Mana Shield" + ", ")) {
			return Component.translatable("slsb.skill.tanker.manashield").getString();
		}
		return Component.translatable("slsb.skill.unknown").getString();
	}
}
