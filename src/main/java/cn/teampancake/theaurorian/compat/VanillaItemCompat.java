package cn.teampancake.theaurorian.compat;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.items.CeruleanArrow;
import cn.teampancake.theaurorian.common.items.CrystalArrow;
import cn.teampancake.theaurorian.common.items.MoonFishBucket;
import cn.teampancake.theaurorian.registry.TABlocks;
import cn.teampancake.theaurorian.registry.TAItems;
import cn.teampancake.theaurorian.utils.TACommonUtils;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
@Mod.EventBusSubscriber(modid = AurorianMod.MOD_ID)
public class VanillaItemCompat {

    @SubscribeEvent
    public static void registerFurnaceFuels(FurnaceFuelBurnTimeEvent event) {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        map.put(TABlocks.SILENT_WOOD_CRAFTING_TABLE.get().asItem(), 300);
        map.put(TABlocks.SILENT_WOOD_LADDER.get().asItem(), 300);
        map.put(TAItems.SILENT_WOOD_STICK.get(), 100);
        map.put(TAItems.SILENT_WOOD_BOW.get(), 300);
        map.put(TAItems.AURORIAN_COAL.get(), 1500);
        for (Item item : map.keySet()) {
            if (event.getItemStack().getItem() == item) {
                event.setBurnTime(map.get(item));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = AurorianMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BusModEvents {

        @SubscribeEvent
        public static void registerCompostables(FMLCommonSetupEvent event) {
            ComposterBlock.add(0.3F, TABlocks.AURORIAN_GRASS.get().asItem());
            ComposterBlock.add(0.3F, TABlocks.AURORIAN_GRASS_LIGHT.get().asItem());
            ComposterBlock.add(0.3F, TABlocks.SILENT_TREE_SAPLING.get().asItem());
            ComposterBlock.add(0.3F, TABlocks.SILENT_BUSH_LEAVES.get().asItem());
            ComposterBlock.add(0.3F, TABlocks.SILENT_TREE_LEAVES.get().asItem());
            ComposterBlock.add(0.3F, TABlocks.WEEPING_WILLOW_LEAVES.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.AURORIAN_FLOWER_1.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.AURORIAN_FLOWER_2.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.AURORIAN_FLOWER_3.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.EQUINOX_FLOWER.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.LAVENDER_PLANT.get().asItem());
            ComposterBlock.add(0.65F, TABlocks.PETUNIA_PLANT.get().asItem());
            ComposterBlock.add(0.3F, TAItems.WEEPING_WILLOW_SAP.get());
            ComposterBlock.add(0.3F, TAItems.LAVENDER_SEEDS.get());
            ComposterBlock.add(0.3F, TAItems.SILK_BERRY.get());
            ComposterBlock.add(0.3F, TAItems.BLUE_BERRY.get());
            ComposterBlock.add(0.85F, TAItems.LAVENDER_BREAD.get());
        }

        @SubscribeEvent
        public static void registerDispenser(FMLCommonSetupEvent event) {
            DispenserBlock.registerBehavior(TAItems.CERULEAN_ARROW.get(), new CeruleanArrow.Dispense());
            DispenserBlock.registerBehavior(TAItems.CRYSTAL_ARROW.get(), new CrystalArrow.Dispense());
            DispenserBlock.registerBehavior(TAItems.MOON_FISH_BUCKET.get(), new MoonFishBucket.Dispense());
        }

        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void registerItemProperties(FMLClientSetupEvent event) {
            ItemProperties.register(TAItems.SILENT_WOOD_BOW.get(), AurorianMod.prefix("pull"), ((stack, level, entity, seed) ->
                    entity == null || entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F));
            ItemProperties.register(TAItems.SILENT_WOOD_BOW.get(), AurorianMod.prefix("pulling"), ((stack, level, entity, seed) ->
                    entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F));
            ItemProperties.register(TAItems.KEEPERS_BOW.get(), AurorianMod.prefix("pull"), ((stack, level, entity, seed) ->
                    entity == null || entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F));
            ItemProperties.register(TAItems.KEEPERS_BOW.get(), AurorianMod.prefix("pulling"), ((stack, level, entity, seed) ->
                    entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F));
            for (Item item : TACommonUtils.getKnownItems()) {
                if (item instanceof ShieldItem) {
                    ItemProperties.register(item, AurorianMod.prefix("blocking"), ((stack, level, entity, seed) ->
                            entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F));
                }
            }
        }

    }

}