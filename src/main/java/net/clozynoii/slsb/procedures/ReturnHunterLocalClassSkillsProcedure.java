package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class ReturnHunterLocalClassSkillsProcedure {
	public static String execute() {
		return Component.translatable("slsb.huntermenu.classskills").getString();
	}
}
