package net.clozynoii.slsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModMobEffects;

import com.mojang.blaze3d.platform.InputConstants;

public class AbilityDashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double cooldown = 0;
		double magnitude = 0;
		boolean gate = false;
		String ability = "";
		gate = false;
		cooldown = 3;
		ability = "Dash";
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).NoCooldowns == false) {
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 1 || entity.getData(SlsbModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1a).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2a).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability3a).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4a).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability5a).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5a = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability1b).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown1b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability2b).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown2b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability3b).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown3b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability4b).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown4b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
				if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).Ability5b).equals(ability)) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.Cooldown5b = cooldown;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		{
			SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
			_vars.InputDelay = 5;
			_vars.syncPlayerVariables(entity);
		}
		entity.invulnerableTime = 30;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(SlsbModMobEffects.NO_FALL, 30, 0, false, false));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("playsound slsb:whoosh player " + "@a" + " ~ ~ ~ 1 1"));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 20, 0.5, 0.5, 0.5, 0.1);
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_W)) {
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 1;
			vecZ = vecZ * 1;
			if (entity.onGround()) {
				vecY = 0.25;
			} else {
				vecY = entity.getLookAngle().y / magnitude;
				vecY = vecY * 0.75;
			}
			entity.push(vecX, vecY, vecZ);
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_S)) {
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * (-1);
			vecZ = vecZ * (-1);
			vecY = 0.25;
			entity.push(vecX, vecY, vecZ);
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_A)) {
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * (-1);
			vecZ = vecZ * 1;
			vecY = 0.25;
			entity.push(vecZ, vecY, vecX);
		} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_D)) {
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 1;
			vecZ = vecZ * (-1);
			vecY = 0.25;
			entity.push(vecZ, vecY, vecX);
		} else {
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecY = entity.getLookAngle().y / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 1;
			vecY = vecY * 0.75;
			vecZ = vecZ * 1;
			entity.push(vecX, vecY, vecZ);
		}
	}
}
