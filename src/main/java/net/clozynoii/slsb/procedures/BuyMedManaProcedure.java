package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModItems;

public class BuyMedManaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold >= 5000) {
			{
				SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
				_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold - 5000;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(SlsbModItems.MED_MANA_POTION.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
