package cn.teampancake.theaurorian.common.mixin;

import cn.teampancake.theaurorian.common.registry.TAEnchantments;
import cn.teampancake.theaurorian.common.utils.EnchantmentUtils;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow @Nullable public LocalPlayer player;
    @Shadow @Nullable public ClientLevel level;

    @Inject(method = "shouldEntityAppearGlowing", at = @At(value = "HEAD"), cancellable = true)
    public void shouldEntityAppearGlowing(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (this.player != null && Minecraft.getInstance().getCameraEntity() == this.player) {
            Holder<Enchantment> holder = TAEnchantments.get(this.player.level(), TAEnchantments.MOONLIGHT);
            double distance = this.player.distanceToSqr(entity);
            int i = EnchantmentUtils.getEnchantmentLevel(holder, this.player);
            if (i > 0 && distance <= Math.pow(i * 20.0D, 2.0D)) {
                cir.setReturnValue(true);
            }
        }
    }

}