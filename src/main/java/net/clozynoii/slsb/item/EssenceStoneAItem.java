
package net.clozynoii.slsb.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EssenceStoneAItem extends Item {
	public EssenceStoneAItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
