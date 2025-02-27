package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class UseAbilities4aProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown4a == 0) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay == 0 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true || entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == false) {
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals("Barrage")) {
					AbilityBarrageProcedure.execute(world, entity);
				}
			}
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Barraging == false) {
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals("Heavy Attack")) {
						AbilityHeavyAttackProcedure.execute(world, x, y, z, entity);
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals("Uppercut")) {
						AbilityUppercutProcedure.execute(world, x, y, z, entity);
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals("Slam")) {
						AbilitySlamProcedure.execute(world, x, y, z, entity);
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals("Dash")) {
						AbilityDashProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		} else {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7c" + Component.translatable("slsb.ability.cooldown").getString())), true);
			}
		}
	}
}
