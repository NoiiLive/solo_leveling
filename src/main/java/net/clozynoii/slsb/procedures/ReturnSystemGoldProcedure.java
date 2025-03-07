package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class ReturnSystemGoldProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##").format() + "G";
	}
}
