package net.clozynoii.slsb.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.slsb.network.SlsbModVariables;

public class GUISkillSlot4aProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		gate = false;
		if ((entity.getData(SlsbModVariables.PLAYER_VARIABLES).GUISelectedEntry).equals("") && gate == false) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.GUISelectedEntry = "None";
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:item.book.put master " + entity.getDisplayName().getString() + " ~ ~ ~ 2 1"));
			gate = true;
		}
		if (!(entity.getData(SlsbModVariables.PLAYER_VARIABLES).GUISelectedEntry).equals("") && gate == false) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.Ability4a = entity.getData(SlsbModVariables.PLAYER_VARIABLES).GUISelectedEntry;
				_vars.syncPlayerVariables(entity);
			}
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.GUISelectedEntry = "";
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound minecraft:entity.experience_orb.pickup master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.7 1"));
			gate = true;
		}
	}
}
