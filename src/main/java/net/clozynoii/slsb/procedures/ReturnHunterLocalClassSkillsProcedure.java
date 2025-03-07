package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnHunterLocalClassSkillsProcedure {
	public static String execute() {
		return Component.translatable("slsb.huntermenu.classskills").getString();
	}
}
