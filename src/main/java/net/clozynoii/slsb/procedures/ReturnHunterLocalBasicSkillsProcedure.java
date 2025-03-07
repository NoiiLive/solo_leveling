package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class ReturnHunterLocalBasicSkillsProcedure {
	public static String execute() {
		return Component.translatable("slsb.huntermenu.basicskills").getString();
	}
}
