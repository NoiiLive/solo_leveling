package net.clozynoii.slsb.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.slsb.world.inventory.SystemShopPotionsMenu;
import net.clozynoii.slsb.procedures.ReturnSystemLocalStatusProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalSkillsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalShopProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalQuestsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemGoldProcedure;
import net.clozynoii.slsb.network.SystemShopPotionsButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SystemShopPotionsScreen extends AbstractContainerScreen<SystemShopPotionsMenu> {
	private final static HashMap<String, Object> guistate = SystemShopPotionsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssfsslx;
	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_tab_top2;
	ImageButton imagebutton_tab_top1;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank16x1;
	ImageButton imagebutton_blank16x2;
	ImageButton imagebutton_blank16x3;
	ImageButton imagebutton_blank16x4;
	ImageButton imagebutton_blank16x5;

	public SystemShopPotionsScreen(SystemShopPotionsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/system_shop_potions.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalStatusProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalSkillsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -38 && mouseX < leftPos + -14 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalShopProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -13 && mouseX < leftPos + 11 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalQuestsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + -37 && mouseY < topPos + -19)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_low_heal"), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_med_heal"), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + 9 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_high_heal"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + -37 && mouseY < topPos + -19)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_low_mana"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_med_mana"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + 9 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_high_mana"), mouseX, mouseY);
		if (mouseX > leftPos + -72 && mouseX < leftPos + -63 && mouseY > topPos + -52 && mouseY < topPos + -43)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_potions.tooltip_back"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_menu_buy.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/top_edge.png"), this.leftPos + -89, this.topPos + -109, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/tab_top_system.png"), this.leftPos + -39, this.topPos + -111, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + -70, this.topPos + -15, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + -70, this.topPos + 8, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + -38, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + -15, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + 8, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_heal_low.png"), this.leftPos + -68, this.topPos + -36, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_heal_med.png"), this.leftPos + -68, this.topPos + -13, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_heal_high.png"), this.leftPos + -68, this.topPos + 10, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_mana_low.png"), this.leftPos + 4, this.topPos + -36, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_mana_med.png"), this.leftPos + 4, this.topPos + -13, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/shop_mana_high.png"), this.leftPos + 4, this.topPos + 10, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnSystemGoldProcedure.execute(entity), -71, 59, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemGoldProcedure.execute(entity), -72, 58, -13210, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_1k"), -47, -31, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_1k1"), 25, -31, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_5k"), -47, -8, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_5k1"), 25, -8, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_10k"), -47, 15, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_10k1"), 25, 15, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_1k2"), -48, -32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_1k3"), 24, -32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_5k2"), -48, -9, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_5k3"), 24, -9, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_10k2"), -48, 14, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_potions.label_10k3"), 24, 14, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_ssfsslx = new PlainTextButton(this.leftPos + -72, this.topPos + -52, 51, 20, Component.translatable("gui.slsb.system_shop_potions.button_ssfsslx"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopPotionsButtonMessage(0, x, y, z));
				SystemShopPotionsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssfsslx", button_ssfsslx);
		this.addRenderableWidget(button_ssfsslx);
		imagebutton_tab_top = new ImageButton(this.leftPos + -89, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopPotionsButtonMessage(1, x, y, z));
				SystemShopPotionsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top", imagebutton_tab_top);
		this.addRenderableWidget(imagebutton_tab_top);
		imagebutton_tab_top2 = new ImageButton(this.leftPos + -64, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopPotionsButtonMessage(2, x, y, z));
				SystemShopPotionsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top2", imagebutton_tab_top2);
		this.addRenderableWidget(imagebutton_tab_top2);
		imagebutton_tab_top1 = new ImageButton(this.leftPos + -14, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopPotionsButtonMessage(3, x, y, z));
				SystemShopPotionsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top1", imagebutton_tab_top1);
		this.addRenderableWidget(imagebutton_tab_top1);
		imagebutton_blank16x = new ImageButton(this.leftPos + -68, this.topPos + -36, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x", imagebutton_blank16x);
		this.addRenderableWidget(imagebutton_blank16x);
		imagebutton_blank16x1 = new ImageButton(this.leftPos + -68, this.topPos + -13, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x1", imagebutton_blank16x1);
		this.addRenderableWidget(imagebutton_blank16x1);
		imagebutton_blank16x2 = new ImageButton(this.leftPos + -68, this.topPos + 10, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x2", imagebutton_blank16x2);
		this.addRenderableWidget(imagebutton_blank16x2);
		imagebutton_blank16x3 = new ImageButton(this.leftPos + 4, this.topPos + -36, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x3", imagebutton_blank16x3);
		this.addRenderableWidget(imagebutton_blank16x3);
		imagebutton_blank16x4 = new ImageButton(this.leftPos + 4, this.topPos + -13, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x4", imagebutton_blank16x4);
		this.addRenderableWidget(imagebutton_blank16x4);
		imagebutton_blank16x5 = new ImageButton(this.leftPos + 4, this.topPos + 10, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x5", imagebutton_blank16x5);
		this.addRenderableWidget(imagebutton_blank16x5);
	}
}
