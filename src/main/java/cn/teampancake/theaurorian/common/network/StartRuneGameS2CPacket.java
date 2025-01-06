package cn.teampancake.theaurorian.common.network;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.client.gui.RuneGameScreen;
import cn.teampancake.theaurorian.common.utils.AlgorithmUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record StartRuneGameS2CPacket(String level) implements CustomPacketPayload {

    public static final Type<StartRuneGameS2CPacket> TYPE = new Type<>(TheAurorian.prefix("network.rune_game"));
    public static final StreamCodec<RegistryFriendlyByteBuf, StartRuneGameS2CPacket> STREAM_CODEC =
            CustomPacketPayload.codec(StartRuneGameS2CPacket::write, StartRuneGameS2CPacket::new);

    public StartRuneGameS2CPacket(FriendlyByteBuf buf) {
        this(buf.readUtf());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUtf(this.level);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(StartRuneGameS2CPacket packet, IPayloadContext context) {
        if (!packet.level.isEmpty() && context.flow().isClientbound()) {
            int[][][] randomLevel = AlgorithmUtils.convertStringTo3D(packet.level);
            context.enqueueWork(() -> openScreen(randomLevel));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void openScreen(int[][][] randomLevel) {
        Minecraft.getInstance().setScreen(new RuneGameScreen(randomLevel));
    }

}