package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnCooldownText3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			return "\u00A7c" + new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3a);
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			return "\u00A7c" + new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3b);
		}
		return "";
	}
}
