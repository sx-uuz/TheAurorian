package cn.teampancake.theaurorian.client.rune_game;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.api.IRune;
import cn.teampancake.theaurorian.client.widget.RuneGameButton;
import cn.teampancake.theaurorian.common.registry.TARunes;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RuneGameBrand {

    public static final int BRAND_SIZE = 20;
    private static final int DIFF = 20;
    private final ResourceLocation texture;
    protected RuneGameRectangle runeGameRectangle;
    private RuneGameButton button;
    private boolean isGray = false;
    private int hasBrand = 0;
    private int x;
    private int y;

    public RuneGameBrand(IRune rune) {
        this.texture = TheAurorian.prefix("textures/gui/rune/sprite_rune_" + rune.name() + ".png");
    }

    public static IRune randomElement() {
        Collection<DeferredHolder<IRune, ? extends IRune>> entries = TARunes.RUNES.getEntries();
        return entries.stream().toList().get(RandomSource.create().nextInt(entries.size())).get();
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public RuneGameBrand setPos(int x, int y) {
        this.x = x;
        this.y = y;
        this.button.setPos(x, y);
        this.runeGameRectangle = new RuneGameRectangle(x, y, BRAND_SIZE, BRAND_SIZE);
        return this;
    }

    public RuneGameBrand bindButton(RuneGameButton button) {
        this.button = button;
        return this;
    }

    public RuneGameButton getButton() {
        return button;
    }

    public int hasBrand() {
        return this.hasBrand;
    }

    public boolean isGray() {
        return this.isGray;
    }

    public void setGray(boolean gray) {
        this.isGray = gray;
    }

    public RuneGameRectangle getRectangle() {
        return this.runeGameRectangle;
    }

    public void setHasBrand(int hasBrand) {
        this.hasBrand = hasBrand;
    }

    public void renderBrand(@NotNull GuiGraphics graphics) {
        if (this.isGray) {
            graphics.blit(this.texture, x, y, BRAND_SIZE, DIFF, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE * 2);
        } else {
            graphics.blit(this.texture, x, y, 0, 0, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE * 2);
        }
    }

    public void renderBrandEliminate(@NotNull GuiGraphics graphics, int x, int y) {
        graphics.blit(this.texture, x, y, 0, 0, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE, BRAND_SIZE * 2);
    }

    public static List<RuneGameBrand> randomBrandList(int[][][] level) {
        int validCount = getValidCount(level);
        List<RuneGameBrand> brandList = Lists.newArrayList();
        for (int i = 0; i < validCount; i = i + 3) {
            IRune rune = randomElement();
            brandList.add(new RuneGameBrand(rune));
            brandList.add(new RuneGameBrand(rune));
            brandList.add(new RuneGameBrand(rune));
        }

        Collections.shuffle(brandList);
        return brandList;
    }

    public static int getValidCount(int[][][] level) {
        return Arrays.stream(level).flatMap(Arrays::stream).flatMapToInt(Arrays::stream)
                .reduce(0, (count, value) -> value != 0 ? count + 1 : count);
    }

}