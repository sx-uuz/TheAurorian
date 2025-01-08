package cn.teampancake.theaurorian.common.network;

import cn.teampancake.theaurorian.TheAurorian;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public record RuneGameAwardShardC2SPacket(String playerName, String shardName) implements CustomPacketPayload {

    public static final Type<RuneGameAwardShardC2SPacket> TYPE = new Type<>(TheAurorian.prefix("network.rune_game_award_shard"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RuneGameAwardShardC2SPacket> STREAM_CODEC =
            CustomPacketPayload.codec(RuneGameAwardShardC2SPacket::write, RuneGameAwardShardC2SPacket::new);

    public RuneGameAwardShardC2SPacket(FriendlyByteBuf buf) {
        this(buf.readUtf(), buf.readUtf());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUtf(this.playerName);
        buf.writeUtf(this.shardName);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(RuneGameAwardShardC2SPacket packet, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer serverPlayer) {
            try {
                Class<?> clazz = Class.forName("net.modfest.scatteredshards.api.ScatteredShardsAPI");
                Method method = clazz.getMethod("triggerShardCollection", ServerPlayer.class, ResourceLocation.class);
                method.invoke(null, serverPlayer, ResourceLocation.parse(packet.shardName));
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {}
        }
    }

}