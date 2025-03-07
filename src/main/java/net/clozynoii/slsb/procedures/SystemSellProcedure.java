package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class SystemSellProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == SlsbModItems.MANA_CRYSTAL.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_E.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_D.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_C.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_B.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_A.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
				if (itemstackiterator.getItem() == SlsbModItems.ESSENCE_STONE_S.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstackiterator;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
					}
				}
			}
		}
	}
}
