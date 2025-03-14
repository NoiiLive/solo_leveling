package net.clozynoii.slsb.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.slsb.world.inventory.SystemMainGUIMenu;
import net.clozynoii.slsb.procedures.ReturnSystemVitalityProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemTitleProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemStrengthProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemSkillPointsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemPerceptionProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemManaProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalStatusProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalSkillsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalShopProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalQuestsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLevelProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemIntelligenceProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemHealthProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemHasPointsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemEXPProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemAgilityProcedure;
import net.clozynoii.slsb.procedures.ReturnManaAmountProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterClassProcedure;
import net.clozynoii.slsb.procedures.ReturnHealthAmountProcedure;
import net.clozynoii.slsb.network.SystemMainGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SystemMainGUIScreen extends AbstractContainerScreen<SystemMainGUIMenu> {
	private final static HashMap<String, Object> guistate = SystemMainGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_system_stat_button;
	ImageButton imagebutton_system_stat_button1;
	ImageButton imagebutton_system_stat_button2;
	ImageButton imagebutton_system_stat_button3;
	ImageButton imagebutton_system_stat_button4;
	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_tab_top1;
	ImageButton imagebutton_tab_top2;

	public SystemMainGUIScreen(SystemMainGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/system_main_gui.png");

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
		if (mouseX > leftPos + -72 && mouseX < leftPos + -13 && mouseY > topPos + -51 && mouseY < topPos + -41)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemEXPProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_menu_main.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_bar.png"), this.leftPos + -61, this.topPos + -6, Mth.clamp((int) ReturnHealthAmountProcedure.execute(entity) * 86, 0, 946), 0, 86, 10, 1032, 10);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_bar.png"), this.leftPos + -61, this.topPos + 5, Mth.clamp((int) ReturnManaAmountProcedure.execute(entity) * 86, 0, 946), 0, 86, 10, 1032, 10);

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

				ReturnHunterClassProcedure.execute(entity), -47, -36, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnHunterClassProcedure.execute(entity), -48, -37, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemManaProcedure.execute(entity), 27, 7, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemHealthProcedure.execute(entity), 27, -4, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemManaProcedure.execute(entity), 26, 6, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemHealthProcedure.execute(entity), 26, -5, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemSkillPointsProcedure.execute(entity), 36, 52, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemSkillPointsProcedure.execute(entity), 35, 51, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemLevelProcedure.execute(entity), -36, -49, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemTitleProcedure.execute(entity), -42, -23, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemLevelProcedure.execute(entity), -37, -50, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemTitleProcedure.execute(entity), -43, -24, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemStrengthProcedure.execute(entity), -33, 28, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemAgilityProcedure.execute(entity), -33, 40, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemPerceptionProcedure.execute(entity), -33, 52, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemVitalityProcedure.execute(entity), 36, 28, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemIntelligenceProcedure.execute(entity), 36, 40, -15657947, false);
		guiGraphics.drawString(this.font,

				ReturnSystemStrengthProcedure.execute(entity), -34, 27, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemAgilityProcedure.execute(entity), -34, 39, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemPerceptionProcedure.execute(entity), -34, 51, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemVitalityProcedure.execute(entity), 35, 27, -1, false);
		guiGraphics.drawString(this.font,

				ReturnSystemIntelligenceProcedure.execute(entity), 35, 39, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_system_stat_button = new ImageButton(this.leftPos + -14, this.topPos + 25, 12, 12,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_stat_button.png"), ResourceLocation.parse("slsb:textures/screens/system_stat_button.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnSystemHasPointsProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_stat_button", imagebutton_system_stat_button);
		this.addRenderableWidget(imagebutton_system_stat_button);
		imagebutton_system_stat_button1 = new ImageButton(this.leftPos + -14, this.topPos + 37, 12, 12,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_stat_button.png"), ResourceLocation.parse("slsb:textures/screens/system_stat_button.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnSystemHasPointsProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_stat_button1", imagebutton_system_stat_button1);
		this.addRenderableWidget(imagebutton_system_stat_button1);
		imagebutton_system_stat_button2 = new ImageButton(this.leftPos + -14, this.topPos + 49, 12, 12,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_stat_button.png"), ResourceLocation.parse("slsb:textures/screens/system_stat_button.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnSystemHasPointsProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_stat_button2", imagebutton_system_stat_button2);
		this.addRenderableWidget(imagebutton_system_stat_button2);
		imagebutton_system_stat_button3 = new ImageButton(this.leftPos + 55, this.topPos + 25, 12, 12,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_stat_button.png"), ResourceLocation.parse("slsb:textures/screens/system_stat_button.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnSystemHasPointsProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_stat_button3", imagebutton_system_stat_button3);
		this.addRenderableWidget(imagebutton_system_stat_button3);
		imagebutton_system_stat_button4 = new ImageButton(this.leftPos + 55, this.topPos + 37, 12, 12,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_stat_button.png"), ResourceLocation.parse("slsb:textures/screens/system_stat_button.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnSystemHasPointsProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_stat_button4", imagebutton_system_stat_button4);
		this.addRenderableWidget(imagebutton_system_stat_button4);
		imagebutton_tab_top = new ImageButton(this.leftPos + -64, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemMainGUIButtonMessage(5, x, y, z));
				SystemMainGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top", imagebutton_tab_top);
		this.addRenderableWidget(imagebutton_tab_top);
		imagebutton_tab_top1 = new ImageButton(this.leftPos + -39, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemMainGUIButtonMessage(6, x, y, z));
				SystemMainGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top1", imagebutton_tab_top1);
		this.addRenderableWidget(imagebutton_tab_top1);
		imagebutton_tab_top2 = new ImageButton(this.leftPos + -14, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemMainGUIButtonMessage(7, x, y, z));
				SystemMainGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top2", imagebutton_tab_top2);
		this.addRenderableWidget(imagebutton_tab_top2);
	}
}
