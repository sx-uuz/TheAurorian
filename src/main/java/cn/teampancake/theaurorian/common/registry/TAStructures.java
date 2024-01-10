package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.level.structure.RuinsAltarStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

public class TAStructures {

    public static final ResourceKey<Structure> RUINS_ALTAR = createKey("ruins_altar");

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, AurorianMod.prefix(name));
    }

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        Structure.StructureSettings ruinsAltarSettings = Structures.structure(
                biomes.getOrThrow(BiomeTags.IS_FOREST), TerrainAdjustment.NONE);
        context.register(RUINS_ALTAR, new RuinsAltarStructure(ruinsAltarSettings));
    }

}