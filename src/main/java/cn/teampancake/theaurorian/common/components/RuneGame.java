package cn.teampancake.theaurorian.common.components;

import cn.teampancake.theaurorian.TheAurorian;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;

public record RuneGame(boolean isDone, String playerName, String playerUUID) implements TooltipProvider {

    public static final RuneGame EMPTY = new RuneGame(Boolean.FALSE, "", "");
    public static final Codec<RuneGame> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("is_done").forGetter(RuneGame::isDone),
            Codec.STRING.fieldOf("player_name").forGetter(RuneGame::playerName),
            Codec.STRING.fieldOf("player_uuid").forGetter(RuneGame::playerUUID)).apply(instance, RuneGame::new));
    public static final StreamCodec<FriendlyByteBuf, RuneGame> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, RuneGame::isDone, ByteBufCodecs.STRING_UTF8, RuneGame::playerName,
            ByteBufCodecs.STRING_UTF8, RuneGame::playerUUID, RuneGame::new);

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        String key = "tooltips." + TheAurorian.MOD_ID + ".rune_game.";
        Component doneText = Component.translatable(key + "done").withStyle(ChatFormatting.GREEN);
        Component undoneText = Component.translatable(key + "undone").withStyle(ChatFormatting.RED);
        tooltipAdder.accept(Component.translatable(key + "status").append(this.isDone ? doneText : undoneText));
        if (!this.playerName.isEmpty()) {
            Component playerName = Component.literal(this.playerName).withStyle(ChatFormatting.GOLD);
            tooltipAdder.accept(Component.translatable(key + "player").append(playerName));
        }
    }

}