package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerTickUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay > 0) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = entity.getData(SlsbModVariables.PLAYER_VARIABLES).InputDelay - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana > entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerMana = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).ManaRegenTimer == 0) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana < entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerMana = Math
							.round(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMana + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana / 50 + entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence);
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SlsbModMobEffects.MANA_FATIGUE)) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.ManaRegenTimer = 10;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.ManaRegenTimer = Math.round(5 - entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerIntelligence / 25);
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AwakeningTimer == 1) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerAwakened = true;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("title " + entity.getDisplayName().getString() + " title {\"text\":\"Awakened\",\"bold\":true,\"color\":\"aqua\"}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("title " + entity.getDisplayName().getString() + " subtitle {\"text\":\"Find someone to evaluate this power...\",\"color\":\"dark_aqua\"}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:item.trident.thunder player " + "@a" + " ~ ~ ~ 0.3 1"));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, (y + 1), z, 20, 0.25, 0.25, 0.25, 0.1);
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.AwakeningTimer = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
