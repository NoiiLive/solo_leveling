package net.clozynoii.slsb.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.clozynoii.slsb.SlsbMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SlsbModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, SlsbMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		SlsbMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.Ability1a = original.Ability1a;
			clone.Ability1b = original.Ability1b;
			clone.Ability2a = original.Ability2a;
			clone.Ability2b = original.Ability2b;
			clone.Ability3a = original.Ability3a;
			clone.Ability3b = original.Ability3b;
			clone.Ability4a = original.Ability4a;
			clone.Ability4b = original.Ability4b;
			clone.Ability5a = original.Ability5a;
			clone.Ability5b = original.Ability5b;
			clone.Cooldown1a = original.Cooldown1a;
			clone.Cooldown1b = original.Cooldown1b;
			clone.Cooldown2a = original.Cooldown2a;
			clone.Cooldown2b = original.Cooldown2b;
			clone.Cooldown3a = original.Cooldown3a;
			clone.Cooldown3b = original.Cooldown3b;
			clone.Cooldown4a = original.Cooldown4a;
			clone.Cooldown4b = original.Cooldown4b;
			clone.Cooldown5a = original.Cooldown5a;
			clone.Cooldown5b = original.Cooldown5b;
			clone.NoCooldowns = original.NoCooldowns;
			clone.JoinedWorld = original.JoinedWorld;
			clone.SystemPlayer = original.SystemPlayer;
			clone.PlayerClass = original.PlayerClass;
			clone.PlayerRank = original.PlayerRank;
			clone.PlayerCash = original.PlayerCash;
			clone.PlayerGuild = original.PlayerGuild;
			clone.PlayerStrength = original.PlayerStrength;
			clone.PlayerAgility = original.PlayerAgility;
			clone.PlayerPerception = original.PlayerPerception;
			clone.PlayerVitality = original.PlayerVitality;
			clone.PlayerIntelligence = original.PlayerIntelligence;
			clone.AwakeningTimer = original.AwakeningTimer;
			clone.PlayerAwakened = original.PlayerAwakened;
			clone.PlayerMana = original.PlayerMana;
			clone.PlayerMaxMana = original.PlayerMaxMana;
			clone.ManaRegenTimer = original.ManaRegenTimer;
			clone.UnlockedSkills = original.UnlockedSkills;
			clone.PlayerLevel = original.PlayerLevel;
			clone.PlayerSkillPoints = original.PlayerSkillPoints;
			clone.PlayerTitle = original.PlayerTitle;
			clone.PlayerEXP = original.PlayerEXP;
			clone.PlayerMaxEXP = original.PlayerMaxEXP;
			clone.PlayerGold = original.PlayerGold;
			if (!event.isWasDeath()) {
				clone.AbilityBar = original.AbilityBar;
				clone.GUISelectedEntry = original.GUISelectedEntry;
				clone.KeyHeld = original.KeyHeld;
				clone.InputDelay = original.InputDelay;
				clone.Barraging = original.Barraging;
				clone.BarrageCooldown = original.BarrageCooldown;
				clone.GUISelectedClass = original.GUISelectedClass;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "slsb_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "slsb_mapvars";
		public double GlobalCooldownCounter = 0.0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			GlobalCooldownCounter = nbt.getDouble("GlobalCooldownCounter");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("GlobalCooldownCounter", GlobalCooldownCounter);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String Ability1a = "None";
		public String Ability1b = "None";
		public String Ability2a = "None";
		public String Ability2b = "None";
		public String Ability3a = "None";
		public String Ability3b = "None";
		public String Ability4a = "None";
		public String Ability4b = "None";
		public String Ability5a = "None";
		public String Ability5b = "None";
		public double AbilityBar = 1.0;
		public double Cooldown1a = 0.0;
		public double Cooldown1b = 0.0;
		public double Cooldown2a = 0.0;
		public double Cooldown2b = 0.0;
		public double Cooldown3a = 0.0;
		public double Cooldown3b = 0.0;
		public double Cooldown4a = 0.0;
		public double Cooldown4b = 0.0;
		public double Cooldown5a = 0.0;
		public double Cooldown5b = 0.0;
		public String GUISelectedEntry = "";
		public boolean KeyHeld = false;
		public double InputDelay = 0.0;
		public boolean NoCooldowns = false;
		public boolean JoinedWorld = false;
		public boolean Barraging = false;
		public double BarrageCooldown = 0.0;
		public boolean SystemPlayer = false;
		public String PlayerClass = "Civilian";
		public String PlayerRank = "F";
		public double PlayerCash = 1000.0;
		public String PlayerGuild = "None";
		public double PlayerStrength = 0.0;
		public double PlayerAgility = 0.0;
		public double PlayerPerception = 0.0;
		public double PlayerVitality = 0.0;
		public double PlayerIntelligence = 0.0;
		public double AwakeningTimer = 100.0;
		public boolean PlayerAwakened = false;
		public double PlayerMana = 100.0;
		public double PlayerMaxMana = 100.0;
		public double ManaRegenTimer = 0.0;
		public String UnlockedSkills = "";
		public double PlayerLevel = 1.0;
		public double PlayerSkillPoints = 0.0;
		public String PlayerTitle = "None";
		public double PlayerEXP = 0.0;
		public double PlayerMaxEXP = 100.0;
		public double PlayerGold = 1000.0;
		public String GUISelectedClass = "";

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Ability1a", Ability1a);
			nbt.putString("Ability1b", Ability1b);
			nbt.putString("Ability2a", Ability2a);
			nbt.putString("Ability2b", Ability2b);
			nbt.putString("Ability3a", Ability3a);
			nbt.putString("Ability3b", Ability3b);
			nbt.putString("Ability4a", Ability4a);
			nbt.putString("Ability4b", Ability4b);
			nbt.putString("Ability5a", Ability5a);
			nbt.putString("Ability5b", Ability5b);
			nbt.putDouble("AbilityBar", AbilityBar);
			nbt.putDouble("Cooldown1a", Cooldown1a);
			nbt.putDouble("Cooldown1b", Cooldown1b);
			nbt.putDouble("Cooldown2a", Cooldown2a);
			nbt.putDouble("Cooldown2b", Cooldown2b);
			nbt.putDouble("Cooldown3a", Cooldown3a);
			nbt.putDouble("Cooldown3b", Cooldown3b);
			nbt.putDouble("Cooldown4a", Cooldown4a);
			nbt.putDouble("Cooldown4b", Cooldown4b);
			nbt.putDouble("Cooldown5a", Cooldown5a);
			nbt.putDouble("Cooldown5b", Cooldown5b);
			nbt.putString("GUISelectedEntry", GUISelectedEntry);
			nbt.putBoolean("KeyHeld", KeyHeld);
			nbt.putDouble("InputDelay", InputDelay);
			nbt.putBoolean("NoCooldowns", NoCooldowns);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putBoolean("Barraging", Barraging);
			nbt.putDouble("BarrageCooldown", BarrageCooldown);
			nbt.putBoolean("SystemPlayer", SystemPlayer);
			nbt.putString("PlayerClass", PlayerClass);
			nbt.putString("PlayerRank", PlayerRank);
			nbt.putDouble("PlayerCash", PlayerCash);
			nbt.putString("PlayerGuild", PlayerGuild);
			nbt.putDouble("PlayerStrength", PlayerStrength);
			nbt.putDouble("PlayerAgility", PlayerAgility);
			nbt.putDouble("PlayerPerception", PlayerPerception);
			nbt.putDouble("PlayerVitality", PlayerVitality);
			nbt.putDouble("PlayerIntelligence", PlayerIntelligence);
			nbt.putDouble("AwakeningTimer", AwakeningTimer);
			nbt.putBoolean("PlayerAwakened", PlayerAwakened);
			nbt.putDouble("PlayerMana", PlayerMana);
			nbt.putDouble("PlayerMaxMana", PlayerMaxMana);
			nbt.putDouble("ManaRegenTimer", ManaRegenTimer);
			nbt.putString("UnlockedSkills", UnlockedSkills);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putDouble("PlayerSkillPoints", PlayerSkillPoints);
			nbt.putString("PlayerTitle", PlayerTitle);
			nbt.putDouble("PlayerEXP", PlayerEXP);
			nbt.putDouble("PlayerMaxEXP", PlayerMaxEXP);
			nbt.putDouble("PlayerGold", PlayerGold);
			nbt.putString("GUISelectedClass", GUISelectedClass);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Ability1a = nbt.getString("Ability1a");
			Ability1b = nbt.getString("Ability1b");
			Ability2a = nbt.getString("Ability2a");
			Ability2b = nbt.getString("Ability2b");
			Ability3a = nbt.getString("Ability3a");
			Ability3b = nbt.getString("Ability3b");
			Ability4a = nbt.getString("Ability4a");
			Ability4b = nbt.getString("Ability4b");
			Ability5a = nbt.getString("Ability5a");
			Ability5b = nbt.getString("Ability5b");
			AbilityBar = nbt.getDouble("AbilityBar");
			Cooldown1a = nbt.getDouble("Cooldown1a");
			Cooldown1b = nbt.getDouble("Cooldown1b");
			Cooldown2a = nbt.getDouble("Cooldown2a");
			Cooldown2b = nbt.getDouble("Cooldown2b");
			Cooldown3a = nbt.getDouble("Cooldown3a");
			Cooldown3b = nbt.getDouble("Cooldown3b");
			Cooldown4a = nbt.getDouble("Cooldown4a");
			Cooldown4b = nbt.getDouble("Cooldown4b");
			Cooldown5a = nbt.getDouble("Cooldown5a");
			Cooldown5b = nbt.getDouble("Cooldown5b");
			GUISelectedEntry = nbt.getString("GUISelectedEntry");
			KeyHeld = nbt.getBoolean("KeyHeld");
			InputDelay = nbt.getDouble("InputDelay");
			NoCooldowns = nbt.getBoolean("NoCooldowns");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			Barraging = nbt.getBoolean("Barraging");
			BarrageCooldown = nbt.getDouble("BarrageCooldown");
			SystemPlayer = nbt.getBoolean("SystemPlayer");
			PlayerClass = nbt.getString("PlayerClass");
			PlayerRank = nbt.getString("PlayerRank");
			PlayerCash = nbt.getDouble("PlayerCash");
			PlayerGuild = nbt.getString("PlayerGuild");
			PlayerStrength = nbt.getDouble("PlayerStrength");
			PlayerAgility = nbt.getDouble("PlayerAgility");
			PlayerPerception = nbt.getDouble("PlayerPerception");
			PlayerVitality = nbt.getDouble("PlayerVitality");
			PlayerIntelligence = nbt.getDouble("PlayerIntelligence");
			AwakeningTimer = nbt.getDouble("AwakeningTimer");
			PlayerAwakened = nbt.getBoolean("PlayerAwakened");
			PlayerMana = nbt.getDouble("PlayerMana");
			PlayerMaxMana = nbt.getDouble("PlayerMaxMana");
			ManaRegenTimer = nbt.getDouble("ManaRegenTimer");
			UnlockedSkills = nbt.getString("UnlockedSkills");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			PlayerSkillPoints = nbt.getDouble("PlayerSkillPoints");
			PlayerTitle = nbt.getString("PlayerTitle");
			PlayerEXP = nbt.getDouble("PlayerEXP");
			PlayerMaxEXP = nbt.getDouble("PlayerMaxEXP");
			PlayerGold = nbt.getDouble("PlayerGold");
			GUISelectedClass = nbt.getString("GUISelectedClass");
		}

		public void syncPlayerVariables(Entity entity) {
			if (!entity.level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(entity.level().players())) {
					if (entityiterator instanceof ServerPlayer serverPlayer)
						PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this, entity.getId()));
				}
			}
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int target) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess()));
			buffer.writeInt(message.target()); // Write the entity ID to the buffer
		}, (RegistryFriendlyByteBuf buffer) -> {
			var nbt = buffer.readNbt();
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserializeNBT(buffer.registryAccess(), nbt);
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().level().getEntity(message.target()).getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess())))
						.exceptionally(e -> {
							context.connection().disconnect(Component.literal(e.getMessage()));
							return null;
						});
			}
		}
	}
}
