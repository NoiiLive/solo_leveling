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

import net.clozynoii.slsb.world.inventory.SystemShopArmor2Menu;
import net.clozynoii.slsb.procedures.ReturnSystemLocalStatusProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalSkillsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalShopProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemLocalQuestsProcedure;
import net.clozynoii.slsb.procedures.ReturnSystemGoldProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedTankerProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedRangerProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedMageProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedHealerProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedFighterProcedure;
import net.clozynoii.slsb.procedures.ReturnSelectedAssassinProcedure;
import net.clozynoii.slsb.network.SystemShopArmor2ButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SystemShopArmor2Screen extends AbstractContainerScreen<SystemShopArmor2Menu> {
	private final static HashMap<String, Object> guistate = SystemShopArmor2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssfsslx;
	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_tab_top2;
	ImageButton imagebutton_tab_top1;
	ImageButton imagebutton_system_arrow_right;
	ImageButton imagebutton_system_arrow_left;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank16x1;
	ImageButton imagebutton_blank16x2;
	ImageButton imagebutton_blank16x3;
	ImageButton imagebutton_blank16x4;
	ImageButton imagebutton_blank16x5;
	ImageButton imagebutton_blank16x6;
	ImageButton imagebutton_blank16x7;
	ImageButton imagebutton_icon_class_fighter;
	ImageButton imagebutton_icon_class_tanker;
	ImageButton imagebutton_icon_class_assassin;
	ImageButton imagebutton_icon_class_ranger;
	ImageButton imagebutton_icon_class_mage;
	ImageButton imagebutton_icon_class_healer;

	public SystemShopArmor2Screen(SystemShopArmor2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/system_shop_armor_2.png");

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
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_crank_helmet"), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_crank_chestplate"), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + 9 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_crank_leggings"), mouseX, mouseY);
		if (mouseX > leftPos + -69 && mouseX < leftPos + -51 && mouseY > topPos + 32 && mouseY < topPos + 50)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_crank_boots"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + -37 && mouseY < topPos + -19)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_brank_helmet"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + -14 && mouseY < topPos + 4)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_brank_chestplate"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + 9 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_brank_leggings"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 21 && mouseY > topPos + 32 && mouseY < topPos + 50)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_brank_boots"), mouseX, mouseY);
		if (mouseX > leftPos + -72 && mouseX < leftPos + -63 && mouseY > topPos + -52 && mouseY < topPos + -43)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_back"), mouseX, mouseY);
		if (mouseX > leftPos + -60 && mouseX < leftPos + -42 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_fighter"), mouseX, mouseY);
		if (mouseX > leftPos + -40 && mouseX < leftPos + -22 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_tanker"), mouseX, mouseY);
		if (mouseX > leftPos + -20 && mouseX < leftPos + -2 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_assassin"), mouseX, mouseY);
		if (mouseX > leftPos + 0 && mouseX < leftPos + 18 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_ranger"), mouseX, mouseY);
		if (mouseX > leftPos + 20 && mouseX < leftPos + 38 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_mage"), mouseX, mouseY);
		if (mouseX > leftPos + 40 && mouseX < leftPos + 58 && mouseY > topPos + 86 && mouseY < topPos + 104)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_armor_2.tooltip_healer"), mouseX, mouseY);
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

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + -70, this.topPos + 31, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + -38, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + -15, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + 8, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot.png"), this.leftPos + 2, this.topPos + 31, 0, 0, 21, 21, 21, 21);

		if (ReturnSelectedFighterProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + -61, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
		if (ReturnSelectedTankerProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + -41, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
		if (ReturnSelectedAssassinProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + -21, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
		if (ReturnSelectedRangerProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + -1, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
		if (ReturnSelectedMageProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + 19, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
		if (ReturnSelectedHealerProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_slot_20x.png"), this.leftPos + 39, this.topPos + 85, 0, 0, 20, 20, 20, 20);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k"), -47, -31, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k1"), -47, -8, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k2"), -47, 15, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k3"), -47, 38, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k4"), -48, -32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k5"), -48, -9, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k6"), -48, 14, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_500k7"), -48, 37, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m"), 25, -31, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m1"), 25, -8, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m2"), 25, 15, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m3"), 25, 38, -15657947, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m4"), 24, -32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m5"), 24, -9, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m6"), 24, 14, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.slsb.system_shop_armor_2.label_25m7"), 24, 37, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_ssfsslx = new PlainTextButton(this.leftPos + -72, this.topPos + -52, 51, 20, Component.translatable("gui.slsb.system_shop_armor_2.button_ssfsslx"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(0, x, y, z));
				SystemShopArmor2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssfsslx", button_ssfsslx);
		this.addRenderableWidget(button_ssfsslx);
		imagebutton_tab_top = new ImageButton(this.leftPos + -89, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(1, x, y, z));
				SystemShopArmor2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
				PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(2, x, y, z));
				SystemShopArmor2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
				PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(3, x, y, z));
				SystemShopArmor2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top1", imagebutton_tab_top1);
		this.addRenderableWidget(imagebutton_tab_top1);
		imagebutton_system_arrow_right = new ImageButton(this.leftPos + 82, this.topPos + -1, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_arrow_right.png"), ResourceLocation.parse("slsb:textures/screens/system_arrow_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(4, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_arrow_right", imagebutton_system_arrow_right);
		this.addRenderableWidget(imagebutton_system_arrow_right);
		imagebutton_system_arrow_left = new ImageButton(this.leftPos + -100, this.topPos + -1, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/system_arrow_left.png"), ResourceLocation.parse("slsb:textures/screens/system_arrow_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(5, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_system_arrow_left", imagebutton_system_arrow_left);
		this.addRenderableWidget(imagebutton_system_arrow_left);
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
		imagebutton_blank16x3 = new ImageButton(this.leftPos + -68, this.topPos + 33, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x3", imagebutton_blank16x3);
		this.addRenderableWidget(imagebutton_blank16x3);
		imagebutton_blank16x4 = new ImageButton(this.leftPos + 4, this.topPos + -36, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x4", imagebutton_blank16x4);
		this.addRenderableWidget(imagebutton_blank16x4);
		imagebutton_blank16x5 = new ImageButton(this.leftPos + 4, this.topPos + -13, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x5", imagebutton_blank16x5);
		this.addRenderableWidget(imagebutton_blank16x5);
		imagebutton_blank16x6 = new ImageButton(this.leftPos + 4, this.topPos + 10, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x6", imagebutton_blank16x6);
		this.addRenderableWidget(imagebutton_blank16x6);
		imagebutton_blank16x7 = new ImageButton(this.leftPos + 4, this.topPos + 33, 16, 16, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/blank16x.png"), ResourceLocation.parse("slsb:textures/screens/blank16x.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x7", imagebutton_blank16x7);
		this.addRenderableWidget(imagebutton_blank16x7);
		imagebutton_icon_class_fighter = new ImageButton(this.leftPos + -59, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_fighter.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_fighter.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(14, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_fighter", imagebutton_icon_class_fighter);
		this.addRenderableWidget(imagebutton_icon_class_fighter);
		imagebutton_icon_class_tanker = new ImageButton(this.leftPos + -39, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_tanker.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_tanker.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(15, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_tanker", imagebutton_icon_class_tanker);
		this.addRenderableWidget(imagebutton_icon_class_tanker);
		imagebutton_icon_class_assassin = new ImageButton(this.leftPos + -19, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_assassin.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_assassin.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(16, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_assassin", imagebutton_icon_class_assassin);
		this.addRenderableWidget(imagebutton_icon_class_assassin);
		imagebutton_icon_class_ranger = new ImageButton(this.leftPos + 1, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_ranger.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_ranger.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(17, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_ranger", imagebutton_icon_class_ranger);
		this.addRenderableWidget(imagebutton_icon_class_ranger);
		imagebutton_icon_class_mage = new ImageButton(this.leftPos + 21, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_mage.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_mage.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(18, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 18, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_mage", imagebutton_icon_class_mage);
		this.addRenderableWidget(imagebutton_icon_class_mage);
		imagebutton_icon_class_healer = new ImageButton(this.leftPos + 41, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/icon_class_healer.png"), ResourceLocation.parse("slsb:textures/screens/icon_class_healer.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SystemShopArmor2ButtonMessage(19, x, y, z));
						SystemShopArmor2ButtonMessage.handleButtonAction(entity, 19, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_icon_class_healer", imagebutton_icon_class_healer);
		this.addRenderableWidget(imagebutton_icon_class_healer);
	}
}
