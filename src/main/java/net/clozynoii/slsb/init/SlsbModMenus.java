
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.clozynoii.slsb.world.inventory.SystemSkillsGUIMenu;
import net.clozynoii.slsb.world.inventory.SystemShopWeaponsMenu;
import net.clozynoii.slsb.world.inventory.SystemShopPotionsMenu;
import net.clozynoii.slsb.world.inventory.SystemShopGUIMenu;
import net.clozynoii.slsb.world.inventory.SystemShopArmorMenu;
import net.clozynoii.slsb.world.inventory.SystemShopArmor3Menu;
import net.clozynoii.slsb.world.inventory.SystemShopArmor2Menu;
import net.clozynoii.slsb.world.inventory.SystemQuestGUIMenu;
import net.clozynoii.slsb.world.inventory.SystemMainGUIMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUITankMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIRangerMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIHealerMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIFighterMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIAssassinMenu;
import net.clozynoii.slsb.world.inventory.HunterMainGUIMenu;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, SlsbMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMainGUIMenu>> HUNTER_MAIN_GUI = REGISTRY.register("hunter_main_gui", () -> IMenuTypeExtension.create(HunterMainGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUIMenu>> HUNTER_SKILL_GUI = REGISTRY.register("hunter_skill_gui", () -> IMenuTypeExtension.create(HunterSkillGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemMainGUIMenu>> SYSTEM_MAIN_GUI = REGISTRY.register("system_main_gui", () -> IMenuTypeExtension.create(SystemMainGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemSkillsGUIMenu>> SYSTEM_SKILLS_GUI = REGISTRY.register("system_skills_gui", () -> IMenuTypeExtension.create(SystemSkillsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopGUIMenu>> SYSTEM_SHOP_GUI = REGISTRY.register("system_shop_gui", () -> IMenuTypeExtension.create(SystemShopGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemQuestGUIMenu>> SYSTEM_QUEST_GUI = REGISTRY.register("system_quest_gui", () -> IMenuTypeExtension.create(SystemQuestGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUIFighterMenu>> HUNTER_SKILL_GUI_FIGHTER = REGISTRY.register("hunter_skill_gui_fighter", () -> IMenuTypeExtension.create(HunterSkillGUIFighterMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUIAssassinMenu>> HUNTER_SKILL_GUI_ASSASSIN = REGISTRY.register("hunter_skill_gui_assassin", () -> IMenuTypeExtension.create(HunterSkillGUIAssassinMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUITankMenu>> HUNTER_SKILL_GUI_TANK = REGISTRY.register("hunter_skill_gui_tank", () -> IMenuTypeExtension.create(HunterSkillGUITankMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUIHealerMenu>> HUNTER_SKILL_GUI_HEALER = REGISTRY.register("hunter_skill_gui_healer", () -> IMenuTypeExtension.create(HunterSkillGUIHealerMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterSkillGUIRangerMenu>> HUNTER_SKILL_GUI_RANGER = REGISTRY.register("hunter_skill_gui_ranger", () -> IMenuTypeExtension.create(HunterSkillGUIRangerMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopWeaponsMenu>> SYSTEM_SHOP_WEAPONS = REGISTRY.register("system_shop_weapons", () -> IMenuTypeExtension.create(SystemShopWeaponsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopArmorMenu>> SYSTEM_SHOP_ARMOR = REGISTRY.register("system_shop_armor", () -> IMenuTypeExtension.create(SystemShopArmorMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopPotionsMenu>> SYSTEM_SHOP_POTIONS = REGISTRY.register("system_shop_potions", () -> IMenuTypeExtension.create(SystemShopPotionsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopArmor2Menu>> SYSTEM_SHOP_ARMOR_2 = REGISTRY.register("system_shop_armor_2", () -> IMenuTypeExtension.create(SystemShopArmor2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SystemShopArmor3Menu>> SYSTEM_SHOP_ARMOR_3 = REGISTRY.register("system_shop_armor_3", () -> IMenuTypeExtension.create(SystemShopArmor3Menu::new));
}
