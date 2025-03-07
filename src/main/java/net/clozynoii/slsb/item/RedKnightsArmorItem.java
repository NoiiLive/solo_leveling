
package net.clozynoii.slsb.item;

import java.util.function.Consumer;
import net.minecraft.client.model.Model;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class RedKnightsArmorItem extends ArmorItem {

	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 8);
			}), 0, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")), () -> Ingredient.of(), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("slsb:empty"))), 3f, 0.1f);
			registerHelper.register(ResourceLocation.parse("slsb:red_knights_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("head", new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, SlsbModItems.RED_KNIGHTS_ARMOR_HELMET.get());

		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).Body, "left_arm",
						new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).LeftArm, "right_arm",
						new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, SlsbModItems.RED_KNIGHTS_ARMOR_CHESTPLATE.get());

		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("left_leg", new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).LeftLeg, "right_leg",
								new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).RightLeg, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, SlsbModItems.RED_KNIGHTS_ARMOR_LEGGINGS.get());

		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("left_leg", new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).LeftBoot, "right_leg",
								new Modeligris_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modeligris_armor.LAYER_LOCATION)).RightBoot, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, SlsbModItems.RED_KNIGHTS_ARMOR_BOOTS.get());
	}

	public RedKnightsArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends RedKnightsArmorItem {

		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(1000)).fireResistant());
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("slsb:textures/entities/igris_armor.png");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_0"));
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_1"));
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_2"));
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_3"));
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_4"));
			list.add(Component.translatable("item.slsb.red_knights_armor_helmet.description_5"));
		}

	}

	public static class Chestplate extends RedKnightsArmorItem {

		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(1000)).fireResistant());
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("slsb:textures/entities/igris_armor.png");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_0"));
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_1"));
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_2"));
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_3"));
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_4"));
			list.add(Component.translatable("item.slsb.red_knights_armor_chestplate.description_5"));
		}

	}

	public static class Leggings extends RedKnightsArmorItem {

		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(1000)).fireResistant());
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("slsb:textures/entities/igris_armor.png");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_0"));
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_1"));
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_2"));
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_3"));
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_4"));
			list.add(Component.translatable("item.slsb.red_knights_armor_leggings.description_5"));
		}

	}

	public static class Boots extends RedKnightsArmorItem {

		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(1000)).fireResistant());
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("slsb:textures/entities/igris_armor.png");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_0"));
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_1"));
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_2"));
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_3"));
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_4"));
			list.add(Component.translatable("item.slsb.red_knights_armor_boots.description_5"));
		}

	}

}
