package cn.teampancake.theaurorian.common.mixin;

import cn.teampancake.theaurorian.common.registry.TAMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    @Shadow public abstract boolean hasEffect(MobEffect effect);

    public MixinLivingEntity(EntityType<?> type, Level level) {
        super(type, level);
    }

    @ModifyArg(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/WalkAnimationState;setSpeed(F)V"))
    public float hurt(float speed) {
        return this.hasEffect(TAMobEffects.CORRUPTION.get()) ? 0.0F : speed;
    }

    @ModifyArg(method = "handleDamageEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/WalkAnimationState;setSpeed(F)V"))
    public float handleDamageEvent(float speed) {
        return this.hasEffect(TAMobEffects.CORRUPTION.get()) ? 0.0F : speed;
    }

}