package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

import java.util.ArrayList;

public class GlobalCooldownsProcedure {
	public static void execute(LevelAccessor world) {
		if (SlsbModVariables.MapVariables.get(world).GlobalCooldownCounter == 0) {
			SlsbModVariables.MapVariables.get(world).GlobalCooldownCounter = 20;
			SlsbModVariables.MapVariables.get(world).syncData(world);
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown1a > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1a = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown1a - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown2a > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2a = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown2a - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3a > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3a = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3a - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown4a > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4a = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown4a - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5a > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5a = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5a - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown1b > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1b = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown1b - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown2b > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2b = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown2b - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3b > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3b = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown3b - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown4b > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4b = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown4b - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5b > 0) {
					{
						SlsbModVariables.PlayerVariables _vars = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5b = entityiterator.getData(SlsbModVariables.PLAYER_VARIABLES).Cooldown5b - 1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
			}
		}
		if (SlsbModVariables.MapVariables.get(world).GlobalCooldownCounter > 0) {
			SlsbModVariables.MapVariables.get(world).GlobalCooldownCounter = SlsbModVariables.MapVariables.get(world).GlobalCooldownCounter - 1;
			SlsbModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
