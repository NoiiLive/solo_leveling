
package net.clozynoii.slsb.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.slsb.procedures.ReturnPlayerIsHunterProcedure;
import net.clozynoii.slsb.procedures.ReturnManaProcedure;
import net.clozynoii.slsb.procedures.ReturnManaAmountProcedure;
import net.clozynoii.slsb.procedures.ReturnAbilityBar2Procedure;
import net.clozynoii.slsb.procedures.ReturnAbilityBar1Procedure;
import net.clozynoii.slsb.procedures.ReturnAbility5Procedure;
import net.clozynoii.slsb.procedures.ReturnAbility4Procedure;
import net.clozynoii.slsb.procedures.ReturnAbility3Procedure;
import net.clozynoii.slsb.procedures.ReturnAbility2Procedure;
import net.clozynoii.slsb.procedures.ReturnAbility1Procedure;
import net.clozynoii.slsb.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class PlayerOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
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
			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_bar.png"), 8, h - 42, 0, 0, 140, 34, 140, 34);

			if (ReturnPlayerIsHunterProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_bar_mana.png"), 8, h - 42, 0, 0, 140, 34, 140, 34);
			}
			if (ReturnAbilityBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_bar_2.png"), 107, h - 30, 0, 0, 5, 18, 5, 18);
			}
			if (ReturnAbilityBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/ability_bar_1.png"), 107, h - 30, 0, 0, 5, 18, 5, 18);
			}

			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), 13, h - 29, Mth.clamp((int) ReturnAbility1Procedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), 32, h - 29, Mth.clamp((int) ReturnAbility2Procedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), 51, h - 29, Mth.clamp((int) ReturnAbility3Procedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), 70, h - 29, Mth.clamp((int) ReturnAbility4Procedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/abilities.png"), 89, h - 29, Mth.clamp((int) ReturnAbility5Procedure.execute(entity) * 16, 0, 80), 0, 16, 16, 96, 16);

			if (ReturnPlayerIsHunterProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("slsb:textures/screens/mana_bar.png"), 8, h - 42, Mth.clamp((int) ReturnManaAmountProcedure.execute(entity) * 140, 0, 1540), 0, 140, 11, 1680, 11);
			}
			if (ReturnPlayerIsHunterProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnManaProcedure.execute(entity), 13, h - 50, -16764544, false);
			if (ReturnPlayerIsHunterProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnManaProcedure.execute(entity), 12, h - 51, -15014145, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
