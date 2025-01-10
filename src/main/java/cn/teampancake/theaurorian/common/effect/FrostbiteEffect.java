package cn.teampancake.theaurorian.common.effect;

import cn.teampancake.theaurorian.common.registry.TAAttachmentTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class FrostbiteEffect extends IncurableEffect {

    public FrostbiteEffect() {
        super(MobEffectCategory.HARMFUL, 0xa7c6ff);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Level level = livingEntity.level();
        if (level.isClientSide) {
            RandomSource random = level.getRandom();
            if ((livingEntity.xOld != livingEntity.getX() || livingEntity.zOld != livingEntity.getZ())) {
                double y = livingEntity.getY() + 1.0D;
                double xSpeed = Mth.randomBetween(random, (-1.0F), (1.0F)) * 0.083333336F;
                double zSpeed = Mth.randomBetween(random, (-1.0F), (1.0F)) * 0.083333336F;
                level.addParticle(ParticleTypes.SNOWFLAKE, livingEntity.getX(), y, livingEntity.getZ(), xSpeed, 0.05F, zSpeed);
            }
        } else {
            livingEntity.hurt(livingEntity.damageSources().source(DamageTypes.FREEZE), 6 << amplifier);
            livingEntity.setData(TAAttachmentTypes.TICKS_FROSTBITE.get(), 140);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

}