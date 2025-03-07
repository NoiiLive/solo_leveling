package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class ReturnSystemEXPProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##").format() + "/" + new java.text.DecimalFormat("##").format() + " EXP";
	}
}
