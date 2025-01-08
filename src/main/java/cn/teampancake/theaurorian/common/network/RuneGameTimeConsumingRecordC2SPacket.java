package cn.teampancake.theaurorian.common.network;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.registry.TAAttachmentTypes;
import cn.teampancake.theaurorian.common.registry.TAStats;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Collections;
import java.util.List;

public record RuneGameTimeConsumingRecordC2SPacket(int time) implements CustomPacketPayload {

    public static final Type<RuneGameTimeConsumingRecordC2SPacket> TYPE = new Type<>(TheAurorian.prefix("network.rune_game_time_consuming"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RuneGameTimeConsumingRecordC2SPacket> STREAM_CODEC =
            CustomPacketPayload.codec(RuneGameTimeConsumingRecordC2SPacket::write, RuneGameTimeConsumingRecordC2SPacket::new);

    public RuneGameTimeConsumingRecordC2SPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.time);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(RuneGameTimeConsumingRecordC2SPacket packet, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            List<Integer> list = player.getData(TAAttachmentTypes.RUNE_GAME_TIME_CONSUMING.get());
            Stat<ResourceLocation> stat = Stats.CUSTOM.get(TAStats.RUNE_GAME_BEST_TIME.get());
            list.add(packet.time);
            Collections.sort(list);
            player.getStats().setValue(player, stat, list.getFirst());
        }
    }

}