
package net.clozynoii.slsb.item;

public class ManaStonePickaxeItem extends PickaxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 10000;
		}

		@Override
		public float getSpeed() {
			return 14f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 20;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(SlsbModItems.ESSENCE_STONE_E.get()), new ItemStack(SlsbModItems.DELETED_MOD_ELEMENT.get()));
		}
	};

	public ManaStonePickaxeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 7f, -2.4f)).fireResistant());
	}
}
