
package net.clozynoii.slsb.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.clozynoii.slsb.procedures.TrueKasakaFangEffectsProcedure;
import net.clozynoii.slsb.init.SlsbModItems;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TrueKasakasFangItem extends SwordItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 0;
		}

		@Override
		public float getSpeed() {
			return 4f;
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
			return 0;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of();
		}
	};

	public TrueKasakasFangItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 249f, -2f)).fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(SlsbModItems.TRUE_KASAKAS_FANG.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TrueKasakaFangEffectsProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_0"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_1"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_2"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_3"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_4"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_5"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_6"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_7"));
		list.add(Component.translatable("item.slsb.true_kasakas_fang.description_8"));
	}
}
