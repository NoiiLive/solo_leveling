package net.clozynoii.slsb.client.gui;

public class SystemShopGUIScreen extends AbstractContainerScreen<SystemShopGUIMenu> {

	private final static HashMap<String, Object> guistate = SystemShopGUIMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_ssfsslarmor;
	Button button_ssfsslweaps;
	Button button_ssfsslpots;
	Button button_ssfsslsell;

	ImageButton imagebutton_tab_top;
	ImageButton imagebutton_tab_top2;
	ImageButton imagebutton_tab_top1;

	public SystemShopGUIScreen(SystemShopGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("slsb:textures/screens/system_shop_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnSystemLocalStatusProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnSystemLocalSkillsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -38 && mouseX < leftPos + -14 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnSystemLocalShopProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -13 && mouseX < leftPos + 11 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnSystemLocalQuestsProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -46 && mouseX < leftPos + -6 && mouseY > topPos + -18 && mouseY < topPos + -7)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_gui.tooltip_weapons"), mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 44 && mouseY > topPos + -18 && mouseY < topPos + -7)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_gui.tooltip_armor"), mouseX, mouseY);
		if (mouseX > leftPos + -21 && mouseX < leftPos + 19 && mouseY > topPos + 28 && mouseY < topPos + 39)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_gui.tooltip_potions"), mouseX, mouseY);
		if (mouseX > leftPos + -47 && mouseX < leftPos + 46 && mouseY > topPos + 45 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.slsb.system_shop_gui.tooltip_sell_crystalsstones"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/system_menu_shop.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/top_edge.png"), this.leftPos + -89, this.topPos + -109, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("slsb:textures/screens/tab_top_system.png"), this.leftPos + -39, this.topPos + -111, 0, 0, 26, 32, 26, 32);

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

		button_ssfsslarmor = new PlainTextButton(this.leftPos + 7, this.topPos + -18, 34, 20, Component.translatable("gui.slsb.system_shop_gui.button_ssfsslarmor"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(0, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);

		guistate.put("button:button_ssfsslarmor", button_ssfsslarmor);
		this.addRenderableWidget(button_ssfsslarmor);

		button_ssfsslweaps = new PlainTextButton(this.leftPos + -43, this.topPos + -18, 34, 20, Component.translatable("gui.slsb.system_shop_gui.button_ssfsslweaps"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(1, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);

		guistate.put("button:button_ssfsslweaps", button_ssfsslweaps);
		this.addRenderableWidget(button_ssfsslweaps);

		button_ssfsslpots = new PlainTextButton(this.leftPos + -13, this.topPos + 28, 28, 20, Component.translatable("gui.slsb.system_shop_gui.button_ssfsslpots"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(2, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);

		guistate.put("button:button_ssfsslpots", button_ssfsslpots);
		this.addRenderableWidget(button_ssfsslpots);

		button_ssfsslsell = new PlainTextButton(this.leftPos + -11, this.topPos + 49, 21, 20, Component.translatable("gui.slsb.system_shop_gui.button_ssfsslsell"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(3, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);

		guistate.put("button:button_ssfsslsell", button_ssfsslsell);
		this.addRenderableWidget(button_ssfsslsell);

		imagebutton_tab_top = new ImageButton(this.leftPos + -89, this.topPos + -109, 26, 32, new WidgetSprites(ResourceLocation.parse("slsb:textures/screens/tab_top.png"), ResourceLocation.parse("slsb:textures/screens/tab_top.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(4, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
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
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(5, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
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
				PacketDistributor.sendToServer(new SystemShopGUIButtonMessage(6, x, y, z));
				SystemShopGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};

		guistate.put("button:imagebutton_tab_top1", imagebutton_tab_top1);
		this.addRenderableWidget(imagebutton_tab_top1);

	}

}
