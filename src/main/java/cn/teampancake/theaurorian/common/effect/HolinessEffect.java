package cn.teampancake.theaurorian.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class HolinessEffect extends MobEffect {

    public HolinessEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffffeb);
    }

    @Override
    public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
        livingEntity.getActiveEffectsMap().values().stream()
                .map(MobEffectInstance::getEffect)
                .filter(holder -> !holder.value().isBeneficial())
                .forEach(livingEntity::removeEffect);
    }

}