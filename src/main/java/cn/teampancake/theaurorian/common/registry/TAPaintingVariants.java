package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.TheAurorian;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class TAPaintingVariants {

    public static final ResourceKey<PaintingVariant> AURORIAN_STEEL = createKey("aurorian_steel");
    public static final ResourceKey<PaintingVariant> PROGRESSION = createKey("progression");
    public static final ResourceKey<PaintingVariant> DUNGEON = createKey("dungeon");
    public static final ResourceKey<PaintingVariant> KEEPER = createKey("keeper");
    public static final ResourceKey<PaintingVariant> KNIGHT = createKey("knight");
    public static final ResourceKey<PaintingVariant> MOON = createKey("moon");
    public static final ResourceKey<PaintingVariant> PORTAL = createKey("portal");
    public static final ResourceKey<PaintingVariant> SLIME = createKey("slime");

    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_2_X_41 = createKey("display_pic_2x41");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_2_X_42 = createKey("display_pic_2x42");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_9_X_41 = createKey("display_pic_9x41");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_9_X_42 = createKey("display_pic_9x42");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_9_X_43 = createKey("display_pic_9x43");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_9_X_44 = createKey("display_pic_9x44");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_41 = createKey("display_pic_8x41");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_42 = createKey("display_pic_8x42");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_43 = createKey("display_pic_8x43");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_44 = createKey("display_pic_8x44");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_45 = createKey("display_pic_8x45");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_46 = createKey("display_pic_8x46");
    public static final ResourceKey<PaintingVariant> DISPLAY_PIC_8_X_47 = createKey("display_pic_8x47");

    private static ResourceKey<PaintingVariant> createKey(String key) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, TheAurorian.prefix(key));
    }

    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        register(context, AURORIAN_STEEL, 1, 1);
        register(context, PROGRESSION, 1, 1);
        register(context, DUNGEON, 1, 1);
        register(context, KEEPER, 2, 2);
        register(context, KNIGHT, 1, 2);
        register(context, MOON, 1, 2);
        register(context, PORTAL, 1, 1);
        register(context, SLIME, 1, 1);
        register(context, DISPLAY_PIC_2_X_41, 2, 4);
        register(context, DISPLAY_PIC_2_X_42, 2, 4);
        register(context, DISPLAY_PIC_9_X_41, 9, 4);
        register(context, DISPLAY_PIC_9_X_42, 9, 4);
        register(context, DISPLAY_PIC_9_X_43, 9, 4);
        register(context, DISPLAY_PIC_9_X_44, 9, 4);
        register(context, DISPLAY_PIC_8_X_41, 8, 4);
        register(context, DISPLAY_PIC_8_X_42, 8, 4);
        register(context, DISPLAY_PIC_8_X_43, 8, 4);
        register(context, DISPLAY_PIC_8_X_44, 8, 4);
        register(context, DISPLAY_PIC_8_X_45, 8, 4);
        register(context, DISPLAY_PIC_8_X_46, 8, 4);
        register(context, DISPLAY_PIC_8_X_47, 8, 4);
    }

    private static void register(BootstrapContext<PaintingVariant> context, ResourceKey<PaintingVariant> key, int width, int height) {
        context.register(key, new PaintingVariant(width, height, key.location()));
    }

}