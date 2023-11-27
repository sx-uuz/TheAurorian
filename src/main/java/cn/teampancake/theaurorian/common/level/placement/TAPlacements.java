package cn.teampancake.theaurorian.common.level.placement;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.level.feature.TAConfiguredFeatures;
import cn.teampancake.theaurorian.registry.TABlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class TAPlacements {

    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_GRASS_PLAINS = createKey("patch_aurorian_grass_plains");
    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_GRASS_LIGHT_PLAINS = createKey("patch_aurorian_grass_light_plains");
    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_GRASS_FOREST = createKey("patch_aurorian_grass_forest");
    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_GRASS_LIGHT_FOREST = createKey("patch_aurorian_grass_light_forest");
    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_FLOWER_PLAINS = createKey("patch_aurorian_flower_plains");
    public static final ResourceKey<PlacedFeature> PATCH_AURORIAN_FLOWER_FOREST = createKey("patch_aurorian_flower_forest");
    public static final ResourceKey<PlacedFeature> TREES_AURORIAN_FOREST = createKey("trees_aurorian_forest");
    public static final ResourceKey<PlacedFeature> ORE_AURORIAN_PERIDOTITE = createKey("ore_aurorian_peridotite");
    public static final ResourceKey<PlacedFeature> ORE_AURORIAN_DIRT = createKey("ore_aurorian_dirt");
    public static final ResourceKey<PlacedFeature> ORE_AURORIAN_COAL = createKey("ore_aurorian_coal");
    public static final ResourceKey<PlacedFeature> ORE_MOONSTONE = createKey("ore_moonstone");
    public static final ResourceKey<PlacedFeature> ORE_CERULEAN = createKey("ore_cerulean");
    public static final ResourceKey<PlacedFeature> ORE_GEODE = createKey("ore_geode");
    public static final ResourceKey<PlacedFeature> RANDOM_URNS = createKey("random_urns");
    public static final ResourceKey<PlacedFeature> SILENT_TREE = createKey("silent_tree");

    private static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, AurorianMod.prefix(key));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder1 = configuredFeature.getOrThrow(TAConfiguredFeatures.PATCH_AURORIAN_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder2 = configuredFeature.getOrThrow(TAConfiguredFeatures.PATCH_AURORIAN_GRASS_LIGHT);
        Holder<ConfiguredFeature<?, ?>> holder3 = configuredFeature.getOrThrow(TAConfiguredFeatures.PATCH_AURORIAN_FLOWER);
        Holder<ConfiguredFeature<?, ?>> holder4 = configuredFeature.getOrThrow(TAConfiguredFeatures.TREES_AURORIAN_FOREST);
        Holder<ConfiguredFeature<?, ?>> holder5 = configuredFeature.getOrThrow(TAConfiguredFeatures.SILENT_TREE);
        PlacementUtils.register(context, PATCH_AURORIAN_GRASS_PLAINS, holder1, NoiseThresholdCountPlacement.of((-0.8D), (5), (10)),
                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, PATCH_AURORIAN_GRASS_LIGHT_PLAINS, holder2, NoiseThresholdCountPlacement.of((-0.8D), (5), (10)),
                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        PlacementUtils.register(context, PATCH_AURORIAN_GRASS_FOREST, holder1, VegetationPlacements.worldSurfaceSquaredWithCount(2));
        PlacementUtils.register(context, PATCH_AURORIAN_GRASS_LIGHT_FOREST, holder2, VegetationPlacements.worldSurfaceSquaredWithCount(2));
        PlacementUtils.register(context, PATCH_AURORIAN_FLOWER_FOREST, holder3, CountPlacement.of(3),
                RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, PATCH_AURORIAN_FLOWER_PLAINS, holder3, NoiseThresholdCountPlacement.of((-0.8D), (15), (4)),
                RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, TREES_AURORIAN_FOREST, holder4, VegetationPlacements.treePlacement(PlacementUtils.countExtra((10), (0.1F), (1))));
        PlacementUtils.register(context, SILENT_TREE, holder5, PlacementUtils.filteredByBlockSurvival(TABlocks.SILENT_TREE_SAPLING.get()));
        PlacementUtils.register(context, ORE_AURORIAN_PERIDOTITE, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_PERIDOTITE),
                OrePlacements.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.belowTop(100))));
        PlacementUtils.register(context, ORE_AURORIAN_DIRT, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_DIRT),
                OrePlacements.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.top())));
        PlacementUtils.register(context, ORE_AURORIAN_COAL, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_COAL),
                OrePlacements.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.belowTop(160))));
        PlacementUtils.register(context, ORE_MOONSTONE, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_COAL),
                OrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.belowTop(38))));
        PlacementUtils.register(context, ORE_CERULEAN, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_COAL),
                OrePlacements.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.belowTop(75))));
        PlacementUtils.register(context, ORE_GEODE, configuredFeature.getOrThrow(TAConfiguredFeatures.ORE_AURORIAN_COAL),
                OrePlacements.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.belowTop(160))));
        PlacementUtils.register(context, RANDOM_URNS, configuredFeature.getOrThrow(TAConfiguredFeatures.RANDOM_URNS));
    }

}