package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnSystemLocalStatusProcedure {
	public static String execute() {
		return Component.translatable("slsb.systemmenu.status").getString();
	}
}
