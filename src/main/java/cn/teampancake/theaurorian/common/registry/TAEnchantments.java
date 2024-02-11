package cn.teampancake.theaurorian.common.registry;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.enchantments.FreezeAspect;
import cn.teampancake.theaurorian.common.enchantments.LightningDamage;
import cn.teampancake.theaurorian.common.enchantments.LightningResistance;
import cn.teampancake.theaurorian.common.enchantments.Overload;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class TAEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, AurorianMod.MOD_ID);
    public static final RegistryObject<Enchantment> OVERLOAD = ENCHANTMENTS.register("overload", Overload::new);
    public static final RegistryObject<Enchantment> FREEZE_ASPECT = ENCHANTMENTS.register("freeze_aspect", FreezeAspect::new);
    public static final RegistryObject<Enchantment> LIGHTNING_DAMAGE = ENCHANTMENTS.register("lightning", LightningDamage::new);
    public static final RegistryObject<Enchantment> LIGHTNING_RESISTANCE = ENCHANTMENTS.register("lightning_resistance", LightningResistance::new);

}