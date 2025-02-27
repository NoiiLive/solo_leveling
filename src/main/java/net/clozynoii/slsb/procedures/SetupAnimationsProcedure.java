package net.clozynoii.slsb.procedures;

import net.clozynoii.slsb.SlsbMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import javax.annotation.Nullable;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.modifier.AbstractFadeModifier;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonMode;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonConfiguration;

import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.util.thread.EffectiveSide;

@EventBusSubscriber(modid = "slsb", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupAnimationsProcedure {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		PlayerAnimationAccess.REGISTER_ANIMATION_EVENT.register((player, animationStack) -> {
			ModifierLayer<IAnimation> layer = new ModifierLayer<>();
			animationStack.addAnimLayer(69, layer);
			PlayerAnimationAccess.getPlayerAssociatedData(player).set(ResourceLocation.fromNamespaceAndPath("slsb", "player_animation"), layer);
		});
	}

	@EventBusSubscriber(modid = "slsb", bus = EventBusSubscriber.Bus.MOD)
public static record SlsbModAnimationMessage(String animation, int target, boolean override) 
        implements CustomPacketPayload {

    public static final Type<SlsbModAnimationMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SlsbMod.MODID, "setup_animations"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SlsbModAnimationMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SlsbModAnimationMessage message) -> {
        buffer.writeUtf(message.animation);
        buffer.writeInt(message.target);
        buffer.writeBoolean(message.override);
    }, (RegistryFriendlyByteBuf buffer) -> new SlsbModAnimationMessage(buffer.readUtf(), buffer.readInt(), buffer.readBoolean()));

    @Override
    public Type<SlsbModAnimationMessage> type() {
        return TYPE;
    }

    public String getAnimation() {
        return animation;
    }

    public boolean isOverride() {
        return override;
    }

    public int getTarget() {
        return target;
    }

    public static void handleData(final SlsbModAnimationMessage message, final IPayloadContext context) {
        if (context.flow() == PacketFlow.CLIENTBOUND) {
            context.enqueueWork(() -> {
                Level level = context.player().level();
                if (level.getEntity(message.target) instanceof Player player) {
                    if (FMLEnvironment.dist == Dist.CLIENT) {
                        ClientOnlyHandler.handleAnimation(message, player);
                    }
                }
            }).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }
    
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        SlsbMod.addNetworkMessage(SlsbModAnimationMessage.TYPE, SlsbModAnimationMessage.STREAM_CODEC, SlsbModAnimationMessage::handleData);
    }
}

@OnlyIn(Dist.CLIENT)
public static void setAnimationClientside(Player player, String anim, boolean override) {
    if (player instanceof net.minecraft.client.player.AbstractClientPlayer player_) {
        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player_)
            .get(ResourceLocation.fromNamespaceAndPath("slsb", "player_animation"));

        if (anim.isEmpty()) {
            if (animation == null || !animation.isActive()) {
                return;
            }
        }

        if (animation != null && (override || !animation.isActive())) {
            animation.replaceAnimationWithFade(
                AbstractFadeModifier.functionalFadeIn(20, (modelName, type, value) -> value),
                PlayerAnimationRegistry.getAnimation(ResourceLocation.fromNamespaceAndPath("slsb", anim)).playAnimation()
                    .setFirstPersonMode(FirstPersonMode.THIRD_PERSON_MODEL)
                    .setFirstPersonConfiguration(new FirstPersonConfiguration().setShowRightArm(true).setShowLeftItem(false))
            );
        }
    }
}


	@OnlyIn(Dist.CLIENT)
	public static void stopAnimationClientside(Player player) {
    	if (player instanceof net.minecraft.client.player.AbstractClientPlayer player_) {
        	var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player_)
            .get(ResourceLocation.fromNamespaceAndPath("slsb", "player_animation"));
        
        	if (animation != null && animation.isActive()) {
            	animation.setAnimation(null);
        	}
    	}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}