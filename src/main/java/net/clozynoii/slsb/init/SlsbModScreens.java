
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.slsb.client.gui.SystemSkillsGUIScreen;
import net.clozynoii.slsb.client.gui.SystemShopWeaponsScreen;
import net.clozynoii.slsb.client.gui.SystemShopPotionsScreen;
import net.clozynoii.slsb.client.gui.SystemShopGUIScreen;
import net.clozynoii.slsb.client.gui.SystemShopArmorScreen;
import net.clozynoii.slsb.client.gui.SystemShopArmor3Screen;
import net.clozynoii.slsb.client.gui.SystemShopArmor2Screen;
import net.clozynoii.slsb.client.gui.SystemQuestGUIScreen;
import net.clozynoii.slsb.client.gui.SystemMainGUIScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUITankScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIRangerScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageWindScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageWaterScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageSummonScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageSpatialScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageLightningScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageIceScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageFireScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageEarthScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageCurseScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIMageBarrierScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIHealerScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIFighterScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIAssassinScreen;
import net.clozynoii.slsb.client.gui.HunterMainGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SlsbModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SlsbModMenus.HUNTER_MAIN_GUI.get(), HunterMainGUIScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI.get(), HunterSkillGUIScreen::new);
		event.register(SlsbModMenus.SYSTEM_MAIN_GUI.get(), SystemMainGUIScreen::new);
		event.register(SlsbModMenus.SYSTEM_SKILLS_GUI.get(), SystemSkillsGUIScreen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_GUI.get(), SystemShopGUIScreen::new);
		event.register(SlsbModMenus.SYSTEM_QUEST_GUI.get(), SystemQuestGUIScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_FIGHTER.get(), HunterSkillGUIFighterScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_ASSASSIN.get(), HunterSkillGUIAssassinScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_TANK.get(), HunterSkillGUITankScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_HEALER.get(), HunterSkillGUIHealerScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_RANGER.get(), HunterSkillGUIRangerScreen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_WEAPONS.get(), SystemShopWeaponsScreen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_ARMOR.get(), SystemShopArmorScreen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_POTIONS.get(), SystemShopPotionsScreen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_ARMOR_2.get(), SystemShopArmor2Screen::new);
		event.register(SlsbModMenus.SYSTEM_SHOP_ARMOR_3.get(), SystemShopArmor3Screen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_BARRIER.get(), HunterSkillGUIMageBarrierScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_CURSE.get(), HunterSkillGUIMageCurseScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_SPATIAL.get(), HunterSkillGUIMageSpatialScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_SUMMON.get(), HunterSkillGUIMageSummonScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_FIRE.get(), HunterSkillGUIMageFireScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_ICE.get(), HunterSkillGUIMageIceScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_WATER.get(), HunterSkillGUIMageWaterScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_EARTH.get(), HunterSkillGUIMageEarthScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_WIND.get(), HunterSkillGUIMageWindScreen::new);
		event.register(SlsbModMenus.HUNTER_SKILL_GUI_MAGE_LIGHTNING.get(), HunterSkillGUIMageLightningScreen::new);
	}
}
