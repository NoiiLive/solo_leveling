
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.clozynoii.slsb.network.MainMenuMessage;
import net.clozynoii.slsb.network.ChangeAbilityBarMessage;
import net.clozynoii.slsb.network.Ability5Message;
import net.clozynoii.slsb.network.Ability4Message;
import net.clozynoii.slsb.network.Ability3Message;
import net.clozynoii.slsb.network.Ability2Message;
import net.clozynoii.slsb.network.Ability1Message;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SlsbModKeyMappings {
	public static final KeyMapping ABILITY_1 = new KeyMapping("key.slsb.ability_1", GLFW.GLFW_KEY_Z, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Ability1Message(0, 0));
				Ability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_1_LASTPRESS);
				PacketDistributor.sendToServer(new Ability1Message(1, dt));
				Ability1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_2 = new KeyMapping("key.slsb.ability_2", GLFW.GLFW_KEY_X, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Ability2Message(0, 0));
				Ability2Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_2_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_2_LASTPRESS);
				PacketDistributor.sendToServer(new Ability2Message(1, dt));
				Ability2Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_3 = new KeyMapping("key.slsb.ability_3", GLFW.GLFW_KEY_C, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Ability3Message(0, 0));
				Ability3Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_3_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_3_LASTPRESS);
				PacketDistributor.sendToServer(new Ability3Message(1, dt));
				Ability3Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_4 = new KeyMapping("key.slsb.ability_4", GLFW.GLFW_KEY_V, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Ability4Message(0, 0));
				Ability4Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_4_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_4_LASTPRESS);
				PacketDistributor.sendToServer(new Ability4Message(1, dt));
				Ability4Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_5 = new KeyMapping("key.slsb.ability_5", GLFW.GLFW_KEY_B, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new Ability5Message(0, 0));
				Ability5Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_5_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_5_LASTPRESS);
				PacketDistributor.sendToServer(new Ability5Message(1, dt));
				Ability5Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGE_ABILITY_BAR = new KeyMapping("key.slsb.change_ability_bar", GLFW.GLFW_KEY_R, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CHANGE_ABILITY_BAR_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - CHANGE_ABILITY_BAR_LASTPRESS);
				PacketDistributor.sendToServer(new ChangeAbilityBarMessage(1, dt));
				ChangeAbilityBarMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MAIN_MENU = new KeyMapping("key.slsb.main_menu", GLFW.GLFW_KEY_G, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MAIN_MENU_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MAIN_MENU_LASTPRESS);
				PacketDistributor.sendToServer(new MainMenuMessage(1, dt));
				MainMenuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long ABILITY_1_LASTPRESS = 0;
	private static long ABILITY_2_LASTPRESS = 0;
	private static long ABILITY_3_LASTPRESS = 0;
	private static long ABILITY_4_LASTPRESS = 0;
	private static long ABILITY_5_LASTPRESS = 0;
	private static long CHANGE_ABILITY_BAR_LASTPRESS = 0;
	private static long MAIN_MENU_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ABILITY_1);
		event.register(ABILITY_2);
		event.register(ABILITY_3);
		event.register(ABILITY_4);
		event.register(ABILITY_5);
		event.register(CHANGE_ABILITY_BAR);
		event.register(MAIN_MENU);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				ABILITY_1.consumeClick();
				ABILITY_2.consumeClick();
				ABILITY_3.consumeClick();
				ABILITY_4.consumeClick();
				ABILITY_5.consumeClick();
				CHANGE_ABILITY_BAR.consumeClick();
				MAIN_MENU.consumeClick();
			}
		}
	}
}
