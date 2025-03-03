
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.slsb.client.gui.SystemSkillsGUIScreen;
import net.clozynoii.slsb.client.gui.SystemShopGUIScreen;
import net.clozynoii.slsb.client.gui.SystemQuestGUIScreen;
import net.clozynoii.slsb.client.gui.SystemMainGUIScreen;
import net.clozynoii.slsb.client.gui.HunterSkillGUIScreen;
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
	}
}
