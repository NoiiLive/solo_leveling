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

import net.clozynoii.slsb.world.inventory.HunterSkillGUIAssassinMenu;
import net.clozynoii.slsb.procedures.ReturnTextWhirlCutProcedure;
import net.clozynoii.slsb.procedures.ReturnTextStealthProcedure;
import net.clozynoii.slsb.procedures.ReturnTextSlaughtererProcedure;
import net.clozynoii.slsb.procedures.ReturnTextQuickReflexProcedure;
import net.clozynoii.slsb.procedures.ReturnTextFlickerFangProcedure;
import net.clozynoii.slsb.procedures.ReturnTextDaggerThrowProcedure;
import net.clozynoii.slsb.procedures.ReturnTextCriticalStrikeProcedure;
import net.clozynoii.slsb.procedures.ReturnTextBackstabProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalStatusProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalSkillsProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot5bProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot5aProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot4bProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot4aProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot3bProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot3aProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot2bProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot2aProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot1bProcedure;
import net.clozynoii.slsb.procedures.ReturnSlot1aProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillWhirlCutProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillStealthProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillSlaughtererProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillQuickReflexProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillFlickerFangProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillDaggerThrowProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillCriticalStrikeProcedure;
import net.clozynoii.slsb.procedures.ReturnNoSkillBackstabProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterLocalClassSkillsProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterLocalBasicSkillsProcedure;
import net.clozynoii.slsb.network.HunterSkillGUIAssassinButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HunterSkillGUIAssassinScreen extends AbstractContainerScreen<HunterSkillGUIAssassinMenu> {
	private final static HashMap<String, Object> guistate = HunterSkillGUIAssassinMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank16x1;
	ImageButton imagebutton_blank16x2;
	ImageButton imagebutton_blank16x3;
	ImageButton imagebutton_blank16x4;
	ImageButton imagebutton_blank16x5;
	ImageButton imagebutton_blank16x6;
	ImageButton imagebutton_blank16x7;
	ImageButton imagebutton_blank16x8;
	ImageButton imagebutton_blank16x9;
	ImageButton imagebutton_tab_bottom;
	ImageButton imagebutton_blank22x;
	ImageButton imagebutton_blank22x1;
	ImageButton imagebutton_blank22x2;
	ImageButton imagebutton_blank22x3;
	ImageButton imagebutton_blank22x4;
	ImageButton imagebutton_blank22x5;
	ImageButton imagebutton_blank22x6;
	ImageButton imagebutton_blank22x7;

	public HunterSkillGUIAssassinScreen(HunterSkillGUIAssassinMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/hunter_skill_gui_assassin.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -46 && mouseY < topPos + -28)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_1"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -25 && mouseY < topPos + -7)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_2"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -4 && mouseY < topPos + 14)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_3"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + 17 && mouseY < topPos + 35)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_4"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + 38 && mouseY < topPos + 56)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_5"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + -35 && mouseY < topPos + -17)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_6"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_7"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 7 && mouseY < topPos + 25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_8"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 28 && mouseY < topPos + 46)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_9"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 49 && mouseY < topPos + 67)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui_assassin.tooltip_slot_10"), mouseX, mouseY);
		if (mouseX > leftPos + -62 && mouseX < leftPos + -38 && mouseY > topPos + -105 && mouseY < topPos + -81)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalStatusProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -37 && mouseX < leftPos + -13 && mouseY > topPos + -105 && mouseY < topPos + -81)
			guiGraphics.renderTooltip(font, Component.literal(ReturnSystemLocalSkillsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -62 && mouseX < leftPos + -38 && mouseY > topPos + 81 && mouseY < topPos + 105)
			guiGraphics.renderTooltip(font, Component.literal(ReturnHunterLocalBasicSkillsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -37 && mouseX < leftPos + -13 && mouseY > topPos + 81 && mouseY < topPos + 105)
			guiGraphics.renderTooltip(font, Component.literal(ReturnHunterLocalClassSkillsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -50 && mouseX < leftPos + -28 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextStealthProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -25 && mouseX < leftPos + -3 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextDaggerThrowProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextCriticalStrikeProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 26 && mouseX < leftPos + 48 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextSlaughtererProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -50 && mouseX < leftPos + -28 && mouseY > topPos + -24 && mouseY < topPos + -2)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextBackstabProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -25 && mouseX < leftPos + -3 && mouseY > topPos + -24 && mouseY < topPos + -2)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextQuickReflexProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -24 && mouseY < topPos + -2)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextWhirlCutProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 26 && mouseX < leftPos + 48 && mouseY > topPos + -24 && mouseY < topPos + -2)
			guiGraphics.renderTooltip(font, Component.literal(ReturnTextFlickerFangProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/gui_hunter_skills.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/top_edge.png"), this.leftPos + -63, this.topPos + -107, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + -50, this.topPos + -48, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + -25, this.topPos + -48, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + 1, this.topPos + -48, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + 26, this.topPos + -48, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/tab_bottom_edge.png"), this.leftPos + -63, this.topPos + 78, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/tab_bottom_middle.png"), this.leftPos + -38, this.topPos + 77, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + -50, this.topPos + -24, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + -25, this.topPos + -24, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + 1, this.topPos + -24, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + 26, this.topPos + -24, 0, 0, 22, 22, 22, 22);

		if (ReturnNoSkillStealthProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + -44, this.topPos + -44, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillDaggerThrowProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + -19, this.topPos + -44, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillCriticalStrikeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + 7, this.topPos + -44, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillSlaughtererProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + 32, this.topPos + -44, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillBackstabProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + -44, this.topPos + -20, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillQuickReflexProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + -19, this.topPos + -20, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillWhirlCutProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + 7, this.topPos + -20, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnNoSkillFlickerFangProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/ability_lock.png"), this.leftPos + 32, this.topPos + -20, 0, 0, 10, 14, 10, 14);
		}

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 70, this.topPos + -45, Mth.clamp((int) ReturnSlot1aProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 70, this.topPos + -24, Mth.clamp((int) ReturnSlot2aProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 70, this.topPos + -3, Mth.clamp((int) ReturnSlot3aProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 70, this.topPos + 18, Mth.clamp((int) ReturnSlot4aProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 70, this.topPos + 39, Mth.clamp((int) ReturnSlot5aProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 91, this.topPos + -34, Mth.clamp((int) ReturnSlot1bProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 91, this.topPos + -13, Mth.clamp((int) ReturnSlot2bProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 91, this.topPos + 8, Mth.clamp((int) ReturnSlot3bProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 91, this.topPos + 29, Mth.clamp((int) ReturnSlot4bProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), this.leftPos + 91, this.topPos + 50, Mth.clamp((int) ReturnSlot5bProcedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_tab_top = new ImageButton(this.leftPos + -63, this.topPos + -107, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(0, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top", imagebutton_tab_top);
		this.addRenderableWidget(imagebutton_tab_top);
		imagebutton_blank16x = new ImageButton(this.leftPos + 70, this.topPos + -45, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(1, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x", imagebutton_blank16x);
		this.addRenderableWidget(imagebutton_blank16x);
		imagebutton_blank16x1 = new ImageButton(this.leftPos + 70, this.topPos + -24, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(2, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x1", imagebutton_blank16x1);
		this.addRenderableWidget(imagebutton_blank16x1);
		imagebutton_blank16x2 = new ImageButton(this.leftPos + 70, this.topPos + -3, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(3, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x2", imagebutton_blank16x2);
		this.addRenderableWidget(imagebutton_blank16x2);
		imagebutton_blank16x3 = new ImageButton(this.leftPos + 70, this.topPos + 18, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(4, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x3", imagebutton_blank16x3);
		this.addRenderableWidget(imagebutton_blank16x3);
		imagebutton_blank16x4 = new ImageButton(this.leftPos + 70, this.topPos + 39, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(5, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x4", imagebutton_blank16x4);
		this.addRenderableWidget(imagebutton_blank16x4);
		imagebutton_blank16x5 = new ImageButton(this.leftPos + 91, this.topPos + -34, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(6, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x5", imagebutton_blank16x5);
		this.addRenderableWidget(imagebutton_blank16x5);
		imagebutton_blank16x6 = new ImageButton(this.leftPos + 91, this.topPos + -13, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(7, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x6", imagebutton_blank16x6);
		this.addRenderableWidget(imagebutton_blank16x6);
		imagebutton_blank16x7 = new ImageButton(this.leftPos + 91, this.topPos + 8, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(8, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x7", imagebutton_blank16x7);
		this.addRenderableWidget(imagebutton_blank16x7);
		imagebutton_blank16x8 = new ImageButton(this.leftPos + 91, this.topPos + 29, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(9, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x8", imagebutton_blank16x8);
		this.addRenderableWidget(imagebutton_blank16x8);
		imagebutton_blank16x9 = new ImageButton(this.leftPos + 91, this.topPos + 50, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(10, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x9", imagebutton_blank16x9);
		this.addRenderableWidget(imagebutton_blank16x9);
		imagebutton_tab_bottom = new ImageButton(this.leftPos + -63, this.topPos + 78, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_bottom.png"), ResourceLocation.parse("slsb:textures/screens/tab_bottom.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(11, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_bottom", imagebutton_tab_bottom);
		this.addRenderableWidget(imagebutton_tab_bottom);
		imagebutton_blank22x = new ImageButton(this.leftPos + -50, this.topPos + -48, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(12, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x", imagebutton_blank22x);
		this.addRenderableWidget(imagebutton_blank22x);
		imagebutton_blank22x1 = new ImageButton(this.leftPos + -25, this.topPos + -48, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(13, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x1", imagebutton_blank22x1);
		this.addRenderableWidget(imagebutton_blank22x1);
		imagebutton_blank22x2 = new ImageButton(this.leftPos + 1, this.topPos + -48, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(14, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x2", imagebutton_blank22x2);
		this.addRenderableWidget(imagebutton_blank22x2);
		imagebutton_blank22x3 = new ImageButton(this.leftPos + 26, this.topPos + -48, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(15, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x3", imagebutton_blank22x3);
		this.addRenderableWidget(imagebutton_blank22x3);
		imagebutton_blank22x4 = new ImageButton(this.leftPos + -50, this.topPos + -24, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(16, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x4", imagebutton_blank22x4);
		this.addRenderableWidget(imagebutton_blank22x4);
		imagebutton_blank22x5 = new ImageButton(this.leftPos + -25, this.topPos + -24, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(17, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x5", imagebutton_blank22x5);
		this.addRenderableWidget(imagebutton_blank22x5);
		imagebutton_blank22x6 = new ImageButton(this.leftPos + 1, this.topPos + -24, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(18, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x6", imagebutton_blank22x6);
		this.addRenderableWidget(imagebutton_blank22x6);
		imagebutton_blank22x7 = new ImageButton(this.leftPos + 26, this.topPos + -24, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIAssassinButtonMessage(19, x, y, z));
				HunterSkillGUIAssassinButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x7", imagebutton_blank22x7);
		this.addRenderableWidget(imagebutton_blank22x7);
	}
}
