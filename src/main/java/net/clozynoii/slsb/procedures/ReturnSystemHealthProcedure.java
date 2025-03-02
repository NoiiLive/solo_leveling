package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnSystemHealthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
	}
}
