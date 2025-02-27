package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModBlocks;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class BarrageTickProcedure {
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
		boolean single = false;
		boolean gate = false;
		double targets = 0;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == true && entity.getData(SlsbModVariables.PLAYER_VARIABLES).Barraging == true) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.Barraging = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = 99999;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _plr0)
				_plr0.resetAttackStrengthTicker();
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).BarrageCooldown == 0) {
				targets = 0;
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.Barraging = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.InputDelay = 99999;
					_vars.syncPlayerVariables(entity);
				}
				gate = false;
				single = false;
				if (world.isClientSide()) {
					SetupAnimationsProcedure.setAnimationClientside((Player) entity, "barrage", false);
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player)
						PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.SlsbModAnimationMessage("barrage", entity.getId(), false));
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle slsb:circle_barrage ^ ^1.5 ^1.5 0.01 0.01 0.01 0 1 force");
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("playsound slsb:whoosh player " + "@a" + " ~ ~ ~ 1 1"));
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("slsb:non_targetable")))) {
							if (gate == false) {
								entityiterator.invulnerableTime = 0;
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), 1);
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ()), Block.getId(SlsbModBlocks.BLOOD_BLOCK.get().defaultBlockState()));
								entityiterator.invulnerableTime = 0;
								entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
								targets = targets + 1;
								if (targets >= 1) {
									gate = true;
								}
							}
							if (single == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("playsound slsb:basic_hit player " + "@a" + " ~ ~ ~ 1 1"));
								single = true;
							}
						}
					}
				}
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.BarrageCooldown = 6;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).BarrageCooldown > 0) {
				{
					SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
					_vars.BarrageCooldown = entity.getData(SlsbModVariables.PLAYER_VARIABLES).BarrageCooldown - 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).KeyHeld == false && entity.getData(SlsbModVariables.PLAYER_VARIABLES).Barraging == true) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.Barraging = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
