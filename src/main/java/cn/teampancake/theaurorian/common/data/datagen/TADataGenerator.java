package cn.teampancake.theaurorian.common.data.datagen;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.data.datagen.provider.*;
import cn.teampancake.theaurorian.common.data.datagen.provider.tag.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = TheAurorian.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class TADataGenerator {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        TABlockTagsProvider blockTagsProvider = new TABlockTagsProvider(output, provider, existingFileHelper);
        DatapackBuiltinEntriesProvider dataPackProvider = new RegistryDataGenerator(output, provider);
        CompletableFuture<HolderLookup.Provider> registryProvider = dataPackProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new TAItemTagsProvider(
                output, provider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), dataPackProvider);
        generator.addProvider(event.includeServer(), new TAPaintingVariantTagsProvider(output, registryProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TAEnchantmentTagsProvider(output, registryProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TAStructureTagsProvider(output, registryProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TABiomeTagsProvider(output, registryProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TAEntityTagsProvider(output, provider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TAFluidTagsProvider(output, provider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TAPoiTagsProvider(output, provider, existingFileHelper));
        generator.addProvider(event.includeClient(), new TABlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new TAItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new TASoundProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new TALanguageProvider(output, "en_us"));
        generator.addProvider(event.includeServer(), new TALanguageProvider(output, "zh_cn"));
        generator.addProvider(event.includeServer(), new TALootTableProvider(output, provider));
        generator.addProvider(event.includeServer(), new TADataMapProvider(output, provider));
        generator.addProvider(event.includeServer(), new TARecipeProvider(output, provider));
    }

}