package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

public class NoFallEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
