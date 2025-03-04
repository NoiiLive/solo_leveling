package net.clozynoii.slsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

public class HunterEvaluationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RandomClass = 0;
		double RandomRank = 0;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAwakened == true && (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerClass).equals("Civilian")) {
			RandomClass = Mth.nextInt(RandomSource.create(), 1, 6);
			RandomRank = Mth.nextInt(RandomSource.create(), 1, 6);
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerStrength = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerAgility = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerVitality = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerPerception = 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerIntelligence = 1;
				_vars.syncPlayerVariables(entity);
			}
			if (RandomClass == 1) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Fighter";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomClass == 2) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Tanker";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomClass == 3) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Assassin";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomClass == 4) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Mage";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomClass == 5) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Healer";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomClass == 6) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerClass = "Ranger";
					_vars.syncPlayerVariables(entity);
				}
			}
			if (RandomRank == 1) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "E";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomRank == 2) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "D";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomRank == 3) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "C";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomRank == 4) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "B";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomRank == 5) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "A";
					_vars.syncPlayerVariables(entity);
				}
			} else if (RandomRank == 6) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.PlayerRank = "S";
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.welcome").getString())), false);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
			SlsbMod.queueServerWork(20, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.waiting").getString())), false);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
				SlsbMod.queueServerWork(40, () -> {
					if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("E")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:block.vault.deactivate player " + "@a" + " ~ ~ ~ 2 1"));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:block.fire.extinguish player " + "@a" + " ~ ~ ~ 0.2 1"));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1), (z + 0.5), 20, 0.5, 0.5, 0.5, 0.1);
						SlsbMod.queueServerWork(10, () -> {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.erank.response").getString())), false);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							SlsbMod.queueServerWork(30, () -> {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.erank.goodbye").getString())), false);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							});
						});
					} else if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank).equals("S")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:block.conduit.activate player " + "@a" + " ~ ~ ~ 1 1"));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:block.glass.break player " + "@a" + " ~ ~ ~ 0.5 1"));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:item.trident.thunder player " + "@a" + " ~ ~ ~ 0.2 1"));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (x + 0.5), (y + 1), (z + 0.5), 20, 0.5, 0.5, 0.5, 0.1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y + 1), (z + 0.5), 20, 0.5, 0.5, 0.5, 0.1);
						SlsbMod.queueServerWork(10, () -> {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.srank.response").getString())), false);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							SlsbMod.queueServerWork(30, () -> {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.srank.goodbye").getString())), false);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							});
						});
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("playsound minecraft:block.conduit.activate player " + "@a" + " ~ ~ ~ 1 1"));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (x + 0.5), (y + 1), (z + 0.5), 20, 0.5, 0.5, 0.5, 0.1);
						SlsbMod.queueServerWork(10, () -> {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.normalrank.response").getString() + " \u00A7f\u00A7l"
										+ entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerRank + Component.translatable("slsb.evaluator.normalrank.rank").getString())), false);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							SlsbMod.queueServerWork(30, () -> {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.normalrank.goodbye").getString())), false);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
							});
						});
					}
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerMana = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerMaxMana;
						_vars.syncPlayerVariables(entity);
					}
				});
			});
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerAwakened == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.evaluated").getString())), false);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("<Evaluator> " + Component.translatable("slsb.evaluator.unawakened").getString())), false);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:entity.item.pickup player " + entity.getDisplayName().getString() + " ~ ~ ~ 0.5 1"));
		}
	}
}
