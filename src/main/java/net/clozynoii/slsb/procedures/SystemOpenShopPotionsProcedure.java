package net.clozynoii.slsb.procedures;

import net.neoforged.bus.api.Event;

public class SystemOpenShopPotionsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("SystemShopPotions");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new SystemShopPotionsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}
