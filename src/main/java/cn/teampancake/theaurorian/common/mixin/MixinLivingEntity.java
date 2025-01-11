package cn.teampancake.theaurorian.common.mixin;

import cn.teampancake.theaurorian.common.registry.TAEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(method = "getDamageAfterArmorAbsorb", at = @At(value = "HEAD"), cancellable = true)
    protected void getDamageAfterArmorAbsorb(DamageSource damageSource, float damageAmount, CallbackInfoReturnable<Float> cir) {
        if (damageSource.getEntity() instanceof Player player) {
            Holder<Enchantment> holder = TAEnchantments.get(player.level(), TAEnchantments.SOUL_SLASH);
            ItemStack itemInHand = player.getItemInHand(player.getUsedItemHand());
            RandomSource random = RandomSource.create();
            int level = itemInHand.getEnchantmentLevel(holder);
            if (level > 0 && random.nextFloat() <= level * 0.05F) {
                cir.setReturnValue(damageAmount);
            }
        }
    }

}