package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class ParalyzedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
	}
}
