package net.clozynoii.slsb.procedures;

import net.minecraft.client.Minecraft;

public class HideOverlayF1Procedure {
	public static boolean execute() {
		if (!(Minecraft.getInstance().options.hideGui)) {
			return true;
		}
		return false;
	}
}
