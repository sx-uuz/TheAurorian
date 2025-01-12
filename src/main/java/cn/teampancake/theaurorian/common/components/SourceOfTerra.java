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

public record SourceOfTerra(String dimension, int selectedX, int selectedY, int selectedZ) implements TooltipProvider {

    public static final Codec<SourceOfTerra> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("dimension").forGetter(SourceOfTerra::dimension),
            Codec.INT.fieldOf("selected_x").forGetter(SourceOfTerra::selectedX),
            Codec.INT.fieldOf("selected_y").forGetter(SourceOfTerra::selectedY),
            Codec.INT.fieldOf("selected_z").forGetter(SourceOfTerra::selectedZ)).apply(instance, SourceOfTerra::new));
    public static final StreamCodec<FriendlyByteBuf, SourceOfTerra> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SourceOfTerra::dimension, ByteBufCodecs.INT, SourceOfTerra::selectedX,
            ByteBufCodecs.INT, SourceOfTerra::selectedY, ByteBufCodecs.INT, SourceOfTerra::selectedZ, SourceOfTerra::new);

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        if (!this.dimension.isEmpty()) {
            String key = "tooltips." + TheAurorian.MOD_ID + ".source_of_terra.dimension";
            String s = " (" + this.selectedX + ", " + this.selectedY + ", " + this.selectedZ + ")";
            tooltipAdder.accept(Component.translatable(key).append(this.dimension).withStyle(ChatFormatting.LIGHT_PURPLE).append(s));
        }
    }

}