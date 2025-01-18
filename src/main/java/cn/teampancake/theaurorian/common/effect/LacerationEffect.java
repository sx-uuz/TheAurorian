package cn.teampancake.theaurorian.common.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class LacerationEffect extends MobEffect {

    public LacerationEffect() {
        super(MobEffectCategory.HARMFUL, 0x710817);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Vec3 vec3 = livingEntity.getDeltaMovement();
        DamageSource source = livingEntity.damageSources().magic();
        if (vec3.x > 0.0D || vec3.y > 0.0D || vec3.z > 0.0D) {
            livingEntity.hurt(source, amplifier + 1);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

}