package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.data.datagen.tags.TABiomeTags;
import cn.teampancake.theaurorian.common.level.structure.structures.RuinsAltarStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TAStructures {

    public static final ResourceKey<Structure> RUINS_ALTAR = createKey("ruins_altar");

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, TheAurorian.prefix(name));
    }

    public static void bootstrap(BootstrapContext<Structure> context) {
        Structure.StructureSettings ruinsAltarSettings = new Structure.StructureSettings(context.lookup(Registries.BIOME).getOrThrow(TABiomeTags.HAS_RUINS_ALTAR),
                Arrays.stream(MobCategory.values()).collect(Collectors.toMap(category -> category, category -> new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, WeightedRandomList.create()))),
                GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE);
        context.register(RUINS_ALTAR, new RuinsAltarStructure(ruinsAltarSettings));
    }

}