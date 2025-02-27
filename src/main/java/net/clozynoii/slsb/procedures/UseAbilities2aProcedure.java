package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class UseAbilities2aProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown2a == 0) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay == 0 && entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true || entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == false) {
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals("Barrage")) {
				}
			}
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).Barraging == false) {
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals("Heavy Attack")) {
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals("Uppercut")) {
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals("Slam")) {
					}
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals("Dash")) {
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
