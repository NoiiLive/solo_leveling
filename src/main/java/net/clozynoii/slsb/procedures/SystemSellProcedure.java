package net.clozynoii.slsb.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.init.SlsbModItems;

public class SystemSellProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == SlsbModItems.MANA_CRYSTAL.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 100;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_E.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 100;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_D.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 500;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_C.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 1000;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_B.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 10000;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_A.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 50000;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_S.get()) {
					{
						SlsbModVariables.PlayerVariables _vars = entity.getData(SlsbModVariables.PLAYER_VARIABLES);
						_vars.PlayerGold = entity.getData(SlsbModVariables.PLAYER_VARIABLES).PlayerGold + itemstackiterator.getCount() * 100000;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
			}
		}
	}
}
