
package net.clozynoii.slsb.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SystemShopPotionsButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SystemShopPotionsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "system_shop_potions_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, SystemShopPotionsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SystemShopPotionsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SystemShopPotionsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SystemShopPotionsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SystemShopPotionsButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SystemShopPotionsMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			SystemOpenShopProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SystemOpenStatusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SystemOpenSkillsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SystemOpenQuestsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SystemShopPotionsButtonMessage.TYPE, SystemShopPotionsButtonMessage.STREAM_CODEC, SystemShopPotionsButtonMessage::handleData);
	}

}
