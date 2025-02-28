package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ReturnHunterGuildProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGuild;
	}
}
