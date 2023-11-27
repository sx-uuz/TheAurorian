package cn.teampancake.theaurorian.common.level.feature;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.level.placement.TAPlacements;
import cn.teampancake.theaurorian.registry.TABlocks;
import cn.teampancake.theaurorian.registry.TAFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class TAConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AURORIAN_GRASS = createKey("patch_aurorian_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AURORIAN_GRASS_LIGHT = createKey("patch_aurorian_grass_light");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AURORIAN_FLOWER = createKey("patch_aurorian_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_AURORIAN_FOREST = createKey("trees_aurorian_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_AURORIAN_PERIDOTITE = createKey("ore_aurorian_peridotite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_AURORIAN_DIRT = createKey("ore_aurorian_dirt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_AURORIAN_COAL = createKey("ore_aurorian_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MOONSTONE = createKey("ore_moonstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CERULEAN = createKey("ore_cerulean");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GEODE = createKey("ore_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOM_URNS = createKey("random_urns");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILENT_TREE = createKey("silent_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, AurorianMod.prefix(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ruleTest = new BlockMatchTest(TABlocks.AURORIAN_STONE.get());
        Holder<PlacedFeature> silentTreeLikeSpruce = context.lookup(Registries.PLACED_FEATURE).getOrThrow(TAPlacements.SILENT_TREE);
        FeatureUtils.register(context, PATCH_AURORIAN_GRASS, Feature.RANDOM_PATCH, VegetationFeatures.grassPatch(
                BlockStateProvider.simple(TABlocks.AURORIAN_GRASS.get()), 32));
        FeatureUtils.register(context, PATCH_AURORIAN_GRASS_LIGHT, Feature.RANDOM_PATCH, VegetationFeatures.grassPatch(
                BlockStateProvider.simple(TABlocks.AURORIAN_GRASS_LIGHT.get()), 32));
        FeatureUtils.register(context, PATCH_AURORIAN_FLOWER, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L,
                        new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F,
                        List.of(TABlocks.LAVENDER_PLANT.get().defaultBlockState(),
                        TABlocks.PETUNIA_PLANT.get().defaultBlockState(), TABlocks.SILK_BERRY_CROP.get().defaultBlockState()))))));
        FeatureUtils.register(context, TREES_AURORIAN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(silentTreeLikeSpruce, 0.7F)), silentTreeLikeSpruce));
        FeatureUtils.register(context, SILENT_TREE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TABlocks.SILENT_TREE_LOG.get()),
                        new StraightTrunkPlacer(13, 6, 0), BlockStateProvider.simple(TABlocks.SILENT_TREE_LEAVES.get()),
                        new SpruceFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(1), UniformInt.of(4, 6)),
                        new TwoLayersFeatureSize(3, 3, 3)).dirt(BlockStateProvider.simple(TABlocks.AURORIAN_DIRT.get()))).ignoreVines().build());
        FeatureUtils.register(context, ORE_AURORIAN_PERIDOTITE, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.AURORIAN_PERIDOTITE.get().defaultBlockState(), 33));
        FeatureUtils.register(context, ORE_AURORIAN_DIRT, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.AURORIAN_DIRT.get().defaultBlockState(), 33));
        FeatureUtils.register(context, ORE_AURORIAN_COAL, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.AURORIAN_COAL_ORE.get().defaultBlockState(), 12));
        FeatureUtils.register(context, ORE_MOONSTONE, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.MOONSTONE_ORE.get().defaultBlockState(), 9));
        FeatureUtils.register(context, ORE_CERULEAN, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.CERULEAN_ORE.get().defaultBlockState(), 7));
        FeatureUtils.register(context, ORE_GEODE, Feature.ORE, new OreConfiguration(ruleTest, TABlocks.GEODE_ORE.get().defaultBlockState(), 5));
        FeatureUtils.register(context, RANDOM_URNS, TAFeatures.RANDOM_URNS.get());
    }

}