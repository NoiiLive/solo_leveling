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

import net.clozynoii.slsb.world.inventory.HunterSkillGUIMenu;
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
import net.clozynoii.slsb.network.HunterSkillGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HunterSkillGUIScreen extends AbstractContainerScreen<HunterSkillGUIMenu> {
	private final static HashMap<String, Object> guistate = HunterSkillGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_blank22x;
	ImageButton imagebutton_blank22x1;
	ImageButton imagebutton_blank22x2;
	ImageButton imagebutton_blank22x3;
	ImageButton imagebutton_blank22x4;
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

	public HunterSkillGUIScreen(HunterSkillGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/hunter_skill_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -50 && mouseX < leftPos + -28 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_heavy_attack"), mouseX, mouseY);
		if (mouseX > leftPos + -25 && mouseX < leftPos + -3 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_barrage"), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_uppercut"), mouseX, mouseY);
		if (mouseX > leftPos + 26 && mouseX < leftPos + 48 && mouseY > topPos + -48 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slam"), mouseX, mouseY);
		if (mouseX > leftPos + -50 && mouseX < leftPos + -28 && mouseY > topPos + -24 && mouseY < topPos + -2)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_dash"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -46 && mouseY < topPos + -28)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_1"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -25 && mouseY < topPos + -7)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_2"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + -4 && mouseY < topPos + 14)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_3"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + 17 && mouseY < topPos + 35)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_4"), mouseX, mouseY);
		if (mouseX > leftPos + 69 && mouseX < leftPos + 87 && mouseY > topPos + 38 && mouseY < topPos + 56)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_5"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + -35 && mouseY < topPos + -17)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_6"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_7"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 7 && mouseY < topPos + 25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_8"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 28 && mouseY < topPos + 46)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_9"), mouseX, mouseY);
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 49 && mouseY < topPos + 67)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.hunter_skill_gui.tooltip_slot_10"), mouseX, mouseY);
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

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/blank_skill.png"), this.leftPos + -50, this.topPos + -24, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/skill_heavy.png"), this.leftPos + -47, this.topPos + -45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/skill_barrage.png"), this.leftPos + -22, this.topPos + -45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/skill_uppercut.png"), this.leftPos + 4, this.topPos + -45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/skill_slam.png"), this.leftPos + 29, this.topPos + -45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/skill_dash.png"), this.leftPos + -47, this.topPos + -21, 0, 0, 16, 16, 16, 16);

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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(0, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top", imagebutton_tab_top);
		this.addRenderableWidget(imagebutton_tab_top);
		imagebutton_blank22x = new ImageButton(this.leftPos + -50, this.topPos + -48, 22, 22, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank22x.png"), ResourceLocation.parse("slsb:textures/screens/blank22x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(1, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(2, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(3, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(4, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(5, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x4", imagebutton_blank22x4);
		this.addRenderableWidget(imagebutton_blank22x4);
		imagebutton_blank16x = new ImageButton(this.leftPos + 70, this.topPos + -45, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(6, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(7, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(8, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(9, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(10, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(11, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(12, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 12, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(13, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 13, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(14, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 14, x, y, z);
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
				PacketDistributor.sendToServer(new HunterSkillGUIButtonMessage(15, x, y, z));
				HunterSkillGUIButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x9", imagebutton_blank16x9);
		this.addRenderableWidget(imagebutton_blank16x9);
	}
}
