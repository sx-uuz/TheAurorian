package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class TAProcessorList {

    public static final ResourceKey<StructureProcessorList> STREET_CAVE = ResourceKey.create(Registries.PROCESSOR_LIST, TheAurorian.prefix("street_cave"));

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        register(context, STREET_CAVE, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new BlockMatchTest(Blocks.CALCITE),
                new BlockMatchTest(Blocks.WATER), Blocks.OAK_PLANKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.CALCITE, 0.1F),
                AlwaysTrueTest.INSTANCE, Blocks.GRASS_BLOCK.defaultBlockState()), new ProcessorRule(new BlockMatchTest(Blocks.GRASS_BLOCK),
                new BlockMatchTest(Blocks.WATER), Blocks.WATER.defaultBlockState()), new ProcessorRule(new BlockMatchTest(Blocks.DIRT),
                new BlockMatchTest(Blocks.WATER), Blocks.WATER.defaultBlockState())))));
    }

    private static void register(
            BootstrapContext<StructureProcessorList> context,
            ResourceKey<StructureProcessorList> key,
            List<StructureProcessor> processorList) {
        context.register(key, new StructureProcessorList(processorList));
    }

}