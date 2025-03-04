
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
import net.clozynoii.slsb.world.inventory.SystemShopGUIMenu;
import net.clozynoii.slsb.world.inventory.SystemQuestGUIMenu;
import net.clozynoii.slsb.world.inventory.SystemMainGUIMenu;
import net.clozynoii.slsb.world.inventory.HunterSkillGUIMenu;
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
}
