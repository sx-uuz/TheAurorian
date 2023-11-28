package cn.teampancake.theaurorian.event.subscriber;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.registry.TAMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AurorianMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class StunEventSubscriber {

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        event.setCanceled(event.getEntity().hasEffect(TAMobEffects.STUN.get()));
    }

    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(TAMobEffects.STUN.get())) {
            entity.setDeltaMovement(0.0, 0.0, 0.0);
        }
    }

    @SubscribeEvent
    public static void onUseItem(LivingEntityUseItemEvent event) {
        event.setCanceled(event.isCancelable() && event.getEntity().hasEffect(TAMobEffects.STUN.get()));
    }

    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity living) {
            if (living.hasEffect(TAMobEffects.STUN.get())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onFillBucket(FillBucketEvent event) {
        LivingEntity living = event.getEntity();
        event.setCanceled(living != null && living.hasEffect(TAMobEffects.STUN.get()));
    }

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        event.setCanceled(event.isCancelable() && event.getPlayer().hasEffect(TAMobEffects.STUN.get()));
    }

//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
//        if (event.isCancelable() && event.getEntity().hasEffect((MobEffect)ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
//        if (event.isCancelable() && event.getEntity().hasEffect((MobEffect)ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
//        if (event.isCancelable() && event.getEntity().hasEffect((MobEffect)ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
//        if (event.isCancelable() && event.getEntity().hasEffect((MobEffect)ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//    @SubscribeEvent
//    public void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
//        Player player = event.getEntity();
//        if (player.hasEffect((MobEffect)ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        event.setCanceled(event.isCancelable() && event.getEntity().hasEffect(TAMobEffects.STUN.get()));
    }

}