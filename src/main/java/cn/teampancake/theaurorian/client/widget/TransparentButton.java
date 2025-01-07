package cn.teampancake.theaurorian.client.widget;

import cn.teampancake.theaurorian.TheAurorian;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TransparentButton extends Button {

    private static final WidgetSprites TA_SPRITES = new WidgetSprites(
            TheAurorian.prefix("widget/button"),
            TheAurorian.prefix("widget/button_disabled"),
            TheAurorian.prefix("widget/button_highlighted"));

    public TransparentButton(int x, int y, int width, int height, Component message, OnPress onPress) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        ResourceLocation sprite = TA_SPRITES.get(this.active, this.isHoveredOrFocused());
        guiGraphics.blitSprite(sprite, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        int color = this.getFGColor() | Mth.ceil(this.alpha * 255.0F) << 24;
        this.renderString(guiGraphics, minecraft.font, color);
    }

}