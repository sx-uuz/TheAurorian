package cn.teampancake.theaurorian.common.data.datagen.provider;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.registry.TASoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class TASoundProvider extends SoundDefinitionsProvider {

    public TASoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, TheAurorian.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(TASoundEvents.CRYSTALLINE_SWORD_USE, definition().with(sound(TASoundEvents.CRYSTALLINE_SWORD_USE.getId())));
        this.add(TASoundEvents.CRYSTALLINE_SWORD_CHARGING, definition().with(sound(TASoundEvents.CRYSTALLINE_SWORD_CHARGING.getId())));
        this.add(TASoundEvents.CRYSTALLINE_SWORD_SHOOT, definition().with(sound(TASoundEvents.CRYSTALLINE_SWORD_SHOOT.getId())));
        this.add(TASoundEvents.WEEPING_WILLOW_BELL, definition().with(sound(TASoundEvents.WEEPING_WILLOW_BELL.getId())));
        this.add(TASoundEvents.BACKGROUND_MUSIC, definition().with(
                sound(TheAurorian.prefix("music/aurorian_1"), SoundDefinition.SoundType.SOUND).stream(),
                sound(TheAurorian.prefix("music/aurorian_2"), SoundDefinition.SoundType.SOUND).stream(),
                sound(TheAurorian.prefix("music/aurorian_3"), SoundDefinition.SoundType.SOUND).stream(),
                sound(TheAurorian.prefix("music/aurorian_4"), SoundDefinition.SoundType.SOUND).stream(),
                sound(TheAurorian.prefix("music/aurorian_5"), SoundDefinition.SoundType.SOUND).stream()));
    }

}