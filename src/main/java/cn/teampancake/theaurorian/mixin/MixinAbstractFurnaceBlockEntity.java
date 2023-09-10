package cn.teampancake.theaurorian.mixin;

import cn.teampancake.theaurorian.registry.ModBlocks;
import cn.teampancake.theaurorian.registry.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class MixinAbstractFurnaceBlockEntity {

    @Inject(method = "getFuel", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void getFuel(CallbackInfoReturnable<Map<Item, Integer>> cir, Map<Item, Integer> map) {
        map.put(ModBlocks.SILENT_WOOD_CRAFTING_TABLE.get().asItem(), 300);
        map.put(ModBlocks.SILENT_WOOD_LADDER.get().asItem(), 300);
        map.put(ModItems.SILENT_WOOD_STICK.get(), 100);
        map.put(ModItems.SILENT_WOOD_BOW.get(), 300);
        map.put(ModItems.AURORIAN_COAL.get(), 1500);
    }

}