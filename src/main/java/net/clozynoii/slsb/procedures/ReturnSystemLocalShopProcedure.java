package net.clozynoii.slsb.procedures;

import net.minecraft.network.chat.Component;

public class ReturnSystemLocalShopProcedure {
	public static String execute() {
		return Component.translatable("slsb.systemmenu.shop").getString();
	}
}
