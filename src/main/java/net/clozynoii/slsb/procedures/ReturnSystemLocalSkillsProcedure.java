package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnSystemLocalSkillsProcedure {
	public static String execute() {
		return Component.translatable("slsb.systemmenu.skills").getString();
	}
}
