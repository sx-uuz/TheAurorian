package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.api.IRune;
import cn.teampancake.theaurorian.common.rune.BaseRune;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class TARunes {

    public static final ResourceKey<Registry<IRune>> RUNE_KEY = ResourceKey.createRegistryKey(TheAurorian.prefix("rune"));
    public static final DeferredRegister<IRune> RUNES = DeferredRegister.create(RUNE_KEY, TheAurorian.MOD_ID);
    public static final Registry<IRune> REGISTRY = new RegistryBuilder<>(RUNE_KEY).create();

    public static final DeferredHolder<IRune, IRune> AURORIAN = register("aurorian");
    public static final DeferredHolder<IRune, IRune> AURORIANITE = register("aurorianite");
    public static final DeferredHolder<IRune, IRune> BRIGHT_MOON = register("bright_moon");
    public static final DeferredHolder<IRune, IRune> CERULEAN = register("cerulean");
    public static final DeferredHolder<IRune, IRune> CREEPER = register("creeper");
    public static final DeferredHolder<IRune, IRune> CRYSTALLINE = register("crystalline");
    public static final DeferredHolder<IRune, IRune> FOREVER = register("forever");
    public static final DeferredHolder<IRune, IRune> MOONSTONE = register("moonstone");
    public static final DeferredHolder<IRune, IRune> NETHER = register("nether");
    public static final DeferredHolder<IRune, IRune> POISON = register("poison");
    public static final DeferredHolder<IRune, IRune> UMBRA = register("umbra");
    public static final DeferredHolder<IRune, IRune> WEALTH = register("wealth");

    private static DeferredHolder<IRune, IRune> register(String name) {
        return RUNES.register(name, () -> new BaseRune(name));
    }

}