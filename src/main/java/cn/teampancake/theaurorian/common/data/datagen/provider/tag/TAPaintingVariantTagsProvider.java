package cn.teampancake.theaurorian.common.data.datagen.provider.tag;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.registry.TAPaintingVariants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TAPaintingVariantTagsProvider extends PaintingVariantTagsProvider {

    public TAPaintingVariantTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, TheAurorian.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(PaintingVariantTags.PLACEABLE).add(
                TAPaintingVariants.AURORIAN_STEEL,
                TAPaintingVariants.PROGRESSION,
                TAPaintingVariants.DUNGEON,
                TAPaintingVariants.KEEPER,
                TAPaintingVariants.KNIGHT,
                TAPaintingVariants.MOON,
                TAPaintingVariants.PORTAL,
                TAPaintingVariants.SLIME,
                TAPaintingVariants.DISPLAY_PIC_2_X_41,
                TAPaintingVariants.DISPLAY_PIC_2_X_42,
                TAPaintingVariants.DISPLAY_PIC_9_X_41,
                TAPaintingVariants.DISPLAY_PIC_9_X_42,
                TAPaintingVariants.DISPLAY_PIC_9_X_43,
                TAPaintingVariants.DISPLAY_PIC_9_X_44,
                TAPaintingVariants.DISPLAY_PIC_8_X_41,
                TAPaintingVariants.DISPLAY_PIC_8_X_42,
                TAPaintingVariants.DISPLAY_PIC_8_X_43,
                TAPaintingVariants.DISPLAY_PIC_8_X_44,
                TAPaintingVariants.DISPLAY_PIC_8_X_45,
                TAPaintingVariants.DISPLAY_PIC_8_X_46,
                TAPaintingVariants.DISPLAY_PIC_8_X_47);
    }

}