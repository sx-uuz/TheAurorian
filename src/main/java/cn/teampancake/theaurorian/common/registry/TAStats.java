package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class TAStats {

    public static final DeferredRegister<ResourceLocation> CUSTOM_STATS = DeferredRegister.create(Registries.CUSTOM_STAT, TheAurorian.MOD_ID);
    private static final List<Runnable> STAT_SETUP = new ArrayList<>();

    public static final DeferredHolder<ResourceLocation, ResourceLocation> RUNE_GAME_WIN_COUNT = makeCustomStat("rune_game_win_count");

    private static DeferredHolder<ResourceLocation, ResourceLocation> makeCustomStat(String key) {
        ResourceLocation value = TheAurorian.prefix(key);
        STAT_SETUP.add(() -> Stats.CUSTOM.get(value, StatFormatter.DEFAULT));
        return CUSTOM_STATS.register(key, () -> value);
    }

    public static void init() {
        STAT_SETUP.forEach(Runnable::run);
    }

}