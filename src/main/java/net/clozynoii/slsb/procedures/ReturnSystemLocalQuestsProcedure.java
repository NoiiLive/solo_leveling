package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnSystemLocalQuestsProcedure {
	public static String execute() {
		return Component.translatable("slsb.systemmenu.quests").getString();
	}
}
