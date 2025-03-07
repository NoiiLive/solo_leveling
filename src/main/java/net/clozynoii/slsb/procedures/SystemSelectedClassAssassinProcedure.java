package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class SystemSelectedClassAssassinProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.GUISelectedClass = "Assassin";
			_vars.syncPlayerVariables(entity);
		}
	}
}
