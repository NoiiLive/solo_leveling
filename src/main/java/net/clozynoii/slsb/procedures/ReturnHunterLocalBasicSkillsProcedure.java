package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnHunterLocalBasicSkillsProcedure {
	public static String execute() {
		return Component.translatable("slsb.huntermenu.basicskills").getString();
	}
}
