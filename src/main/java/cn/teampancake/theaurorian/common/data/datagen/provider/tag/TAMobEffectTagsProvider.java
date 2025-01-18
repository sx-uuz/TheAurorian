package cn.teampancake.theaurorian.common.data.datagen.provider.tag;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.data.datagen.tags.TAMobEffectTags;
import cn.teampancake.theaurorian.common.registry.TAMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TAMobEffectTagsProvider extends TagsProvider<MobEffect> {

    public TAMobEffectTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.MOB_EFFECT, lookupProvider, TheAurorian.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TAMobEffectTags.MOON_QUEEN_ONLY).add(
                this.getKey(TAMobEffects.CRESCENT),
                this.getKey(TAMobEffects.MOON_BEFALL),
                this.getKey(TAMobEffects.BLESS_OF_MOON),
                this.getKey(TAMobEffects.MOON_OF_VENGEANCE));
    }

    private ResourceKey<MobEffect> getKey(Holder<MobEffect> mobEffect) {
        ResourceKey<MobEffect> key = mobEffect.getKey();
        if (key == null) {
            ResourceLocation location = ResourceLocation.parse(mobEffect.getRegisteredName());
            return ResourceKey.create(Registries.MOB_EFFECT, location);
        } else {
            return key;
        }
    }

}