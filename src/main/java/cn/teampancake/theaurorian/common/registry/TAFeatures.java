package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.level.feature.*;
import cn.teampancake.theaurorian.common.level.feature.config.FallenLogConfig;
import cn.teampancake.theaurorian.common.level.feature.ruin.MediumRuinFeature;
import cn.teampancake.theaurorian.common.level.feature.ruin.SmallRuinFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class TAFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, TheAurorian.MOD_ID);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> RANDOM_URN = FEATURES.register("random_urn", UrnFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<FallenLogConfig>> RANDOM_FALLEN_LOGS = FEATURES.register("random_fallen_logs", FallenLogFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<FilthyLakeFeature.Configuration>> FILTHY_WATER_LAKE =
            FEATURES.register("filthy_water_lake", FilthyLakeFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FILTHY_FREEZE_TOP_LAYER =
            FEATURES.register("filthy_freeze_top_layer", FilthySnowAndFreezeFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<HugeMushroomFeatureConfiguration>> HUGE_INDIGO_MUSHROOM =
            FEATURES.register("huge_indigo_mushroom", HugeIndigoMushroomFeature::new);
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_SPRING = registerMediumRuins("aurorian_forest_spring");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_REMAINS = registerMediumRuins("aurorian_forest_remains");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_MEMORY_LOOP = registerMediumRuins("aurorian_forest_memory_loop");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_RUINED_PORTAL = registerMediumRuins("aurorian_forest_ruined_portal");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_SHATTERED_WREATH = registerMediumRuins("aurorian_forest_shattered_wreath");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_SHATTERED_PILLAR = registerMediumRuins("aurorian_forest_shattered_pillar");
    public static final DeferredHolder<Feature<?>, MediumRuinFeature> AURORIAN_FOREST_SHATTERED_FOREST_PILLAR = registerMediumRuins("aurorian_forest_shattered_forest_pillar");
    public static final List<DeferredHolder<Feature<?>, SmallRuinFeature>> AURORIAN_FOREST_SMALL_RUINS = new ArrayList<>();
    
    private static DeferredHolder<Feature<?>, MediumRuinFeature> registerMediumRuins(String name) {
        return FEATURES.register(name, () -> new MediumRuinFeature(name));
    }

    private static DeferredHolder<Feature<?>, SmallRuinFeature> registerSmallRuins(String name) {
        return FEATURES.register(name, () -> new SmallRuinFeature(name));
    }

    static {
        for (int i = 1; i < 23; i++) {
            AURORIAN_FOREST_SMALL_RUINS.add(registerSmallRuins("small_ruins_" + i));
        }
    }

}