
package net.clozynoii.slsb.command;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.clozynoii.slsb.procedures.CMDUnawakenPlayerProcedure;
import net.clozynoii.slsb.procedures.CMDSystemPlayerProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankSProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankEProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankDProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankCProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankBProcedure;
import net.clozynoii.slsb.procedures.CMDSetRankAProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassTankProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassRangerProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageWindProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageWaterProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageSummonProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageSpatialProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageIceProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageFireProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageElectricProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageEarthProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageCurseProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassMageBarrierProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassHealerProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassFighterProcedure;
import net.clozynoii.slsb.procedures.CMDSetClassAssassinProcedure;
import net.clozynoii.slsb.procedures.CMDRerollSkillsProcedure;
import net.clozynoii.slsb.procedures.CMDClearSkillsProcedure;
import net.clozynoii.slsb.procedures.CMDAwakenPlayerProcedure;

import com.mojang.brigadier.arguments.BoolArgumentType;

@EventBusSubscriber
public class SlsbCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("slsb").requires(s -> s.hasPermission(2)).then(Commands.literal("player").then(Commands.literal("awaken").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDAwakenPlayerProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("unawaken").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDUnawakenPlayerProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("system").then(Commands.argument("name", EntityArgument.player()).then(Commands.argument("logic", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSystemPlayerProcedure.execute(arguments, entity);
			return 0;
		})))).then(Commands.literal("class").then(Commands.literal("fighter").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassFighterProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("assassin").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassAssassinProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("tanker").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassTankProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("healer").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassHealerProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("ranger").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassRangerProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("mage").then(Commands.literal("barrier").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageBarrierProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("curse").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageCurseProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("spatial").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageSpatialProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("summoner").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageSummonProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("fire").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageFireProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("ice").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageIceProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("water").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageWaterProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("wind").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageWindProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("earth").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageEarthProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("lightning").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetClassMageElectricProcedure.execute(arguments, entity);
			return 0;
		}))))).then(Commands.literal("rank").then(Commands.literal("e").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankEProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("d").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankDProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("c").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankCProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("b").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankBProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("a").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankAProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("s").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDSetRankSProcedure.execute(arguments, entity);
			return 0;
		})))).then(Commands.literal("skill").then(Commands.literal("reroll").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDRerollSkillsProcedure.execute(world, x, y, z, entity);
			return 0;
		})).then(Commands.literal("clear").then(Commands.argument("name", EntityArgument.player()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CMDClearSkillsProcedure.execute(arguments, entity);
			return 0;
		}))))));
	}
}
