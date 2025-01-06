package cn.teampancake.theaurorian.common.network;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.components.RuneGame;
import cn.teampancake.theaurorian.common.registry.TADataComponents;
import cn.teampancake.theaurorian.common.registry.TAItems;
import cn.teampancake.theaurorian.common.registry.TAStats;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record WinRuneGameC2SPacket(boolean isWin) implements CustomPacketPayload {

    public static final Type<WinRuneGameC2SPacket> TYPE = new Type<>(TheAurorian.prefix("network.win_rune_game"));
    public static final StreamCodec<RegistryFriendlyByteBuf, WinRuneGameC2SPacket> STREAM_CODEC =
            CustomPacketPayload.codec(WinRuneGameC2SPacket::write, WinRuneGameC2SPacket::new);

    public WinRuneGameC2SPacket(FriendlyByteBuf buf) {
        this(buf.readBoolean());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.isWin);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(WinRuneGameC2SPacket packet, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            ItemStack itemInHand = player.getItemInHand(player.getUsedItemHand());
            DataComponentType<RuneGame> component = TADataComponents.RUNE_GAME.get();
            String playerName = player.getName().getString();
            String playerUUID = player.getStringUUID();
            RuneGame runeGame = itemInHand.get(component);
            boolean isUndone = runeGame != null && !runeGame.isDone();
            if (itemInHand.is(TAItems.RUNE_KNOWLEDGE_FRAGMENT) && isUndone) {
                itemInHand.set(component, new RuneGame(packet.isWin, playerName, playerUUID));
                itemInHand.set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, packet.isWin);
                player.awardStat(TAStats.RUNE_GAME_WIN_COUNT.get());
            }
        }
    }

}