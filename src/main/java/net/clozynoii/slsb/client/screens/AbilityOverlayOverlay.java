
package net.clozynoii.slsb.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.slsb.procedures.ReturnCooldownText5Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldownText4Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldownText3Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldownText2Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldownText1Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldown5Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldown4Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldown3Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldown2Procedure;
import net.clozynoii.slsb.procedures.ReturnCooldown1Procedure;
import net.clozynoii.slsb.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class AbilityOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (HideOverlayF1Procedure.execute()) {
			if (ReturnCooldown1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_cooldown.png"), 13, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_cooldown.png"), 32, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_cooldown.png"), 51, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_cooldown.png"), 70, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_cooldown.png"), 89, h - 29, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown1Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCooldownText1Procedure.execute(entity), 18, h - 25, -1, false);
			if (ReturnCooldown2Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCooldownText2Procedure.execute(entity), 37, h - 25, -1, false);
			if (ReturnCooldown3Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCooldownText3Procedure.execute(entity), 56, h - 25, -1, false);
			if (ReturnCooldown4Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCooldownText4Procedure.execute(entity), 75, h - 25, -1, false);
			if (ReturnCooldown5Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnCooldownText5Procedure.execute(entity), 94, h - 25, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
