package cn.teampancake.theaurorian.common.level.biome;

import cn.teampancake.theaurorian.common.level.chunk.TATerrainColumn;
import cn.teampancake.theaurorian.common.registry.TABiomes;
import it.unimi.dsi.fastutil.floats.Float2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectSortedMap;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.List;
import java.util.function.Consumer;

public class TABiomeBuilder {

    public static List<TATerrainColumn> makeBiomeList(HolderGetter<Biome> biomeRegistry) {
        return List.of(biomeColumnWithUnderground(0.3F, 0.3F, biomeRegistry, TABiomes.AURORIAN_PLAINS),
                biomeColumnWithUnderground(0.3F, 0.3F, biomeRegistry, TABiomes.AURORIAN_FOREST),
                biomeColumnWithUnderground(0.4F, 0.4F, biomeRegistry, TABiomes.AURORIAN_FOREST_HILL),
                biomeColumnWithUnderground(0.25F, 0.3F, biomeRegistry, TABiomes.EQUINOX_FLOWER_PLAINS),
                biomeColumnWithUnderground(0.3F, 0.4F, biomeRegistry, TABiomes.WEEPING_WILLOW_FOREST),
                biomeColumnWithUnderground(0.3F, 0.4F, biomeRegistry, TABiomes.BRIGHT_MOON_DESERT),
                biomeColumnWithUnderground(-1.65F, 0.0F, biomeRegistry, TABiomes.AURORIAN_RIVER),
                biomeColumnWithUnderground(-1.65F, 0.0F, biomeRegistry, TABiomes.AURORIAN_LAKE));
    }

    private static TATerrainColumn biomeColumnWithUnderground(float noiseDepth, float noiseScale, HolderGetter<Biome> biomeRegistry, ResourceKey<Biome> key) {
        Holder.Reference<Biome> biomeHolder = biomeRegistry.getOrThrow(key);
        biomeHolder.bindKey(key);
        return makeColumn(noiseDepth, noiseScale, biomeHolder, treeMap -> {
            treeMap.put(Math.min(noiseDepth - 1, -1), biomeHolder);
            treeMap.put(Math.min(noiseDepth - 3, -3), biomeRegistry.getOrThrow(TABiomes.UNDERGROUND));
        });
    }

    private static TATerrainColumn makeColumn(float noiseDepth, float noiseScale, Holder<Biome> biomeHolder, Consumer<Float2ObjectSortedMap<Holder<Biome>>> layerBuilder) {
        return new TATerrainColumn(biomeHolder, Util.make(new Float2ObjectAVLTreeMap<>(), layerBuilder), noiseDepth, noiseScale);
    }

}