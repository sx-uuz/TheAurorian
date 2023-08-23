package cn.teampancake.theaurorian.common.items;

import cn.teampancake.theaurorian.config.AurorianConfig;
import cn.teampancake.theaurorian.utils.EntityHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class UmbraShield extends ShieldItem implements ITooltipsItem{

    private static final int PARTICLE_DELAY = 6;
    private static final int PARTICLE_DENSITY = 50;
    private static final double PARTICLE_SPREAD = 50;
    private static final double PARTICLE_DISTANCE = 0.1f;
    private static final double REACH = 1.5;

    public UmbraShield() {
        super(new Properties().durability(512));
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return AurorianConfig.Config_UmbraShieldTimeUntilOverheat.get();
    }

    @Override
    @NotNull
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (!player.isShiftKeyDown()) {
                player.getCooldowns().addCooldown(stack.getItem(), AurorianConfig.Config_UmbraShieldOverheatCooldown.get());
                if (level.isClientSide) {
                    level.playLocalSound(player.getX() + 0.5D, player.getY(), player.getZ() + 0.5D, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F,false);
                }
            }
        }
        return stack;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (pStack == player.getUseItem() && !player.isShiftKeyDown()) {
                double yaw = Math.toRadians(player.yHeadRot);
                double pitch = Math.toRadians(player.getXRot());
                double sinYaw = -Mth.sin((float) yaw);
                double cosYaw = Mth.cos((float) yaw);
                double sinPitch = -Mth.sin((float) pitch);
                double cosPitch = Mth.cos((float) pitch);

                if (pLevel.isClientSide && player.tickCount % PARTICLE_DELAY == 0) {
                    pLevel.playLocalSound(player.getX() + 0.5D, player.getY(), player.getZ() + 0.5D, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 0.75F, false);
                }

                RandomSource random = player.getRandom();

                for (int i = -1; i < random.nextInt(PARTICLE_DENSITY); i++) {
                    double spreadX = random.nextGaussian() * PARTICLE_SPREAD;
                    double spreadY = random.nextGaussian() * PARTICLE_SPREAD;
                    double spreadZ = random.nextGaussian() * PARTICLE_SPREAD;

                    double offsetX = (sinYaw * cosPitch) + (spreadX * cosYaw * cosPitch);
                    double offsetY = sinPitch + spreadY * cosPitch;
                    double offsetZ = (cosYaw * cosPitch) - (spreadX * sinYaw * cosPitch);

                    offsetX *= PARTICLE_DISTANCE;
                    offsetY *= PARTICLE_DISTANCE;
                    offsetZ *= PARTICLE_DISTANCE;

                    double targetX = offsetX * REACH + player.getX();
                    double targetY = offsetY * REACH + player.getY();
                    double targetZ = offsetZ * REACH + player.getZ();

                    pLevel.addParticle(ParticleTypes.FLAME, player.getX() + offsetX, player.getY() + offsetY + player.getEyeHeight() / 2, player.getZ() + offsetZ, targetX, targetY, targetZ);
                }
            }
        }
    }
}