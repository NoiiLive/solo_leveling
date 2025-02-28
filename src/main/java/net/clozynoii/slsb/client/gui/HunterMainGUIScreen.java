package net.clozynoii.slsb.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.slsb.world.inventory.HunterMainGUIMenu;
import net.clozynoii.slsb.procedures.ReturnPlayerProcedure;
import net.clozynoii.slsb.procedures.ReturnPlayerCashProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterVitalityProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterStrengthProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterRankProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterPerceptionProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterIntelligenceProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterGuildProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterClassProcedure;
import net.clozynoii.slsb.procedures.ReturnHunterAgilityProcedure;
import net.clozynoii.slsb.network.HunterMainGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HunterMainGUIScreen extends AbstractContainerScreen<HunterMainGUIMenu> {
	private final static HashMap<String, Object> guistate = HunterMainGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_top;

	public HunterMainGUIScreen(HunterMainGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/hunter_main_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnPlayerProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -28, this.topPos + 24, 35, 0f + (float) Math.atan((this.leftPos + -28 - mouseX) / 40.0), (float) Math.atan((this.topPos + -25 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/gui_hunter_main.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

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

				ReturnHunterRankProcedure.execute(entity), 33, -47, -14664184, false);
		guiGraphics.drawString(this.font,

				ReturnHunterClassProcedure.execute(entity), -18, 37, -14664184, false);
		guiGraphics.drawString(this.font,

				ReturnHunterGuildProcedure.execute(entity), -18, 50, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerCashProcedure.execute(entity), -18, 63, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterStrengthProcedure.execute(entity), 33, -34, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterAgilityProcedure.execute(entity), 33, -21, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterPerceptionProcedure.execute(entity), 33, -8, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterVitalityProcedure.execute(entity), 33, 5, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterIntelligenceProcedure.execute(entity), 33, 18, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnHunterRankProcedure.execute(entity), 32, -48, -8455136, false);
		guiGraphics.drawString(this.font,

				ReturnHunterClassProcedure.execute(entity), -19, 36, -8455136, false);
		guiGraphics.drawString(this.font,

				ReturnHunterGuildProcedure.execute(entity), -19, 49, -1, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerCashProcedure.execute(entity), -19, 62, -1, false);
		guiGraphics.drawString(this.font,

				ReturnHunterStrengthProcedure.execute(entity), 32, -35, -1, false);
		guiGraphics.drawString(this.font,

				ReturnHunterAgilityProcedure.execute(entity), 32, -22, -1, false);
		guiGraphics.drawString(this.font,

				ReturnHunterPerceptionProcedure.execute(entity), 32, -9, -1, false);
		guiGraphics.drawString(this.font,

				ReturnHunterVitalityProcedure.execute(entity), 32, 4, -1, false);
		guiGraphics.drawString(this.font,

				ReturnHunterIntelligenceProcedure.execute(entity), 32, 17, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_tab_top = new ImageButton(this.leftPos + -38, this.topPos + -107, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new HunterMainGUIButtonMessage(0, x, y, z));
				HunterMainGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top", imagebutton_tab_top);
		this.addRenderableWidget(imagebutton_tab_top);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
