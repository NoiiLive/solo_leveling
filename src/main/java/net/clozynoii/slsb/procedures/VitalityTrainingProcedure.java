package net.clozynoii.slsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModMobEffects;

public class VitalityTrainingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAwakened == true && entity.getData(SlsbModVariables.PLAYER_VARIABLES).SystemPlayer == false) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SlsbModMobEffects.MUSCLE_FATIGUE))) {
				if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality < 100) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7cVIT : " + new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality) + " > "
								+ new java.text.DecimalFormat("##").format(entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality + 1))), true);
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerVitality = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerVitality + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (x + 0.5), (y + 0.5), (z + 0.5), 10, 0.1, 0.1, 0.1, 0.1);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("playsound minecraft:block.wool.break player " + "@a" + " ~ ~ ~ 1 1"));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(SlsbModMobEffects.MUSCLE_FATIGUE, 300, 0, true, false));
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7c" + Component.translatable("slsb.training.musclefatigue").getString())), true);
			}
		}
	}
}
