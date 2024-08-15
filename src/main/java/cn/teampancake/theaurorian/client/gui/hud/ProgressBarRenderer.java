package cn.teampancake.theaurorian.client.gui.hud;

import cn.teampancake.theaurorian.TheAurorian;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

public class ProgressBarRenderer {

    public static ResourceLocation STAMINA = TheAurorian.prefix("textures/gui/stamina.png");
    public static final int TEXTURE_WIDTH = 32;
    public static final int TEXTURE_HEIGHT = 16;
    public static final int STAMINA_WIDTH = 32;
    public static final int STAMINA_HEIGHT = 6;
    public static final int STAMINA_BAR_WIDTH = 26;
    public static final int STAMINA_BAR_HEIGHT = 2;
    public static final int STAMINA_BAR_X = 3;
    public static final int STAMINA_BAR_Y = 2;

    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        RenderSystem.enableBlend();
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            int width = guiGraphics.guiWidth();
            int height = guiGraphics.guiHeight();
            ItemStack useItem = player.getUseItem();
            int maxUseDuration = useItem.getUseDuration(player);
            int useDuration = player.getUseItemRemainingTicks();
            if (useDuration < 0 || maxUseDuration <= 0) {
                return;
            }

            float stamina = (float) useDuration / (float) maxUseDuration;
            float staminaBarWidth = STAMINA_BAR_WIDTH * (1 - stamina);
            int off_x = width / 2 - STAMINA_WIDTH / 2;
            int off_y = height / 2 + height / 4;
            if (useItem.getItem() instanceof ProjectileWeaponItem || useItem.getItem() == Items.TRIDENT) {
                int maxTick = 20;
                int i = maxUseDuration - maxTick;
                stamina = ((float) useDuration - i) / (float) maxTick;
                staminaBarWidth = STAMINA_BAR_WIDTH * (1 - stamina);
                if (useDuration - i < 0) {
                    staminaBarWidth = STAMINA_BAR_WIDTH;
                    useDuration = 0;
                }
            }

            guiGraphics.blit(STAMINA, off_x, off_y, 0, 0, STAMINA_WIDTH, STAMINA_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            guiGraphics.blit(STAMINA, off_x + STAMINA_BAR_X, height / 2 + height / 4 + STAMINA_BAR_Y, 3, 12, (int) staminaBarWidth, STAMINA_BAR_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            if (useDuration == 0) {
                guiGraphics.blit(STAMINA, off_x, off_y, 0, 6, STAMINA_WIDTH, STAMINA_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
                guiGraphics.blit(STAMINA, off_x + STAMINA_BAR_X, height / 2 + height / 4 + STAMINA_BAR_Y, 3, 14, STAMINA_BAR_WIDTH, STAMINA_BAR_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            }
        }

        RenderSystem.disableBlend();
    }

    public static void registerProgressBarOverlay(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, TheAurorian.prefix("progress_bar"), ProgressBarRenderer::render);
    }

}