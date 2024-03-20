package cn.teampancake.theaurorian.common.event.subscriber;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.data.datagen.tags.TABlockTags;
import cn.teampancake.theaurorian.common.effect.CorruptionEffect;
import cn.teampancake.theaurorian.common.effect.ForbiddenCurseEffect;
import cn.teampancake.theaurorian.common.effect.TAMobEffect;
import cn.teampancake.theaurorian.common.entities.boss.MoonQueen;
import cn.teampancake.theaurorian.common.entities.boss.SpiderMother;
import cn.teampancake.theaurorian.common.entities.monster.SnowTundraGiantCrab;
import cn.teampancake.theaurorian.common.entities.projectile.WebbingEntity;
import cn.teampancake.theaurorian.common.entities.technical.SitEntity;
import cn.teampancake.theaurorian.common.items.TAArmorMaterials;
import cn.teampancake.theaurorian.common.items.armor.MysteriumWoolArmor;
import cn.teampancake.theaurorian.common.network.TAMessages;
import cn.teampancake.theaurorian.common.network.message.FrostbiteSyncMessage;
import cn.teampancake.theaurorian.common.registry.*;
import cn.teampancake.theaurorian.common.utils.AurorianSteelHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = AurorianMod.MOD_ID)
public class EntityEventSubscriber {

    @SubscribeEvent
    public static void onPlayerTicking(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = player.level();
        boolean hasKnightHelmet = player.getItemBySlot(EquipmentSlot.HEAD).is(TAItems.KNIGHT_HELMET.get());
        boolean hasKnightChestplate = player.getItemBySlot(EquipmentSlot.CHEST).is(TAItems.KNIGHT_CHESTPLATE.get());
        boolean hasKnightLeggings = player.getItemBySlot(EquipmentSlot.LEGS).is(TAItems.KNIGHT_LEGGINGS.get());
        boolean hasKnightBoots = player.getItemBySlot(EquipmentSlot.FEET).is(TAItems.KNIGHT_BOOTS.get());
        if (hasKnightHelmet && hasKnightChestplate && hasKnightLeggings && hasKnightBoots) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100));
        }

        if (event.phase == TickEvent.Phase.END && level instanceof ServerLevel serverLevel && !serverLevel.isClientSide) {
            Holder<Biome> biomeHolder = serverLevel.getBiome(player.blockPosition());
            boolean isSnowField = biomeHolder.is(TABiomes.FILTHY_ICE_CRYSTAL_SNOWFIELD);
            if (isSnowField && !player.hasEffect(TAMobEffects.WARM.get()) && player.tickCount % 60 == 0) {
                if (!MysteriumWoolArmor.isWearFullArmor(player) && !player.isCreative() && !player.isSpectator()) {
                    player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> miscNBT.ticksFrostbite = 140);
                    player.hurt(player.damageSources().freeze(), 1.0F);
                    player.setSharedFlagOnFire(false);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        Player originalPlayer = event.getOriginal();
        Player newPlayer = event.getEntity();
        Collection<MobEffectInstance> activeEffects = originalPlayer.getActiveEffects();
        boolean flag = originalPlayer.hasEffect(TAMobEffects.POTION_REMAIN.get());
        if (event.isWasDeath() && !activeEffects.isEmpty() && flag) {
            originalPlayer.getActiveEffects().forEach(newPlayer::addEffect);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        if (!level.isClientSide()) {
            MobEffect effect = TAMobEffects.PARALYSIS.get();
            if (entity.hasEffect(effect) && entity.getVehicle() == null) {
                SitEntity sitEntity = new SitEntity(level, entity.getOnPos(), 0.7D);
                level.addFreshEntity(sitEntity);
                entity.startRiding(sitEntity);
            }
        }

        entity.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
            MobEffect effect = TAMobEffects.CORRUPTION.get();
            int validTime = miscNBT.validCorruptionTime;
            int i = miscNBT.ticksFrostbite;
            int j = miscNBT.corruptionTime;
            if (!level.isClientSide) {
                if (entity.hasEffect(effect)) {
                    float chance = j / (validTime + 40.0F);
                    boolean shouldRemove = level.random.nextFloat() < chance;
                    if (entity.tickCount % 20 == 0) {
                        ++miscNBT.corruptionTime;
                    }
                    if (j >= validTime || shouldRemove) {
                        entity.getEffect(effect).duration = 0;
                        entity.removeEffect(effect);
                    }
                }
                if (i > 0) {
                    miscNBT.ticksFrostbite = Math.max(0, i - 2);
                    if (entity instanceof ServerPlayer serverPlayer) {
                        TAMessages.sendToPlayer(new FrostbiteSyncMessage(i), serverPlayer);
                    }
                }
            }
        });
    }

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        DamageSource source = event.getDamageSource();
        if (event.getEntity() instanceof Player player && source.getEntity() instanceof SnowTundraGiantCrab) {
            float damage = event.getBlockedDamage();
            ItemStack useItem = player.getUseItem();
            if (useItem.canPerformAction(ToolActions.SHIELD_BLOCK)) {
                if (!player.level().isClientSide) {
                    player.awardStat(Stats.ITEM_USED.get(useItem.getItem()));
                }

                if (damage > 3.0F) {
                    int i = (1 + Mth.floor(damage)) * 3;
                    InteractionHand usedItemHand = player.getUsedItemHand();
                    player.level().broadcastEntityEvent(player, (byte) 29);
                    useItem.hurtAndBreak(i, player, p -> {
                        p.broadcastBreakEvent(usedItemHand);
                        player.stopUsingItem();
                    });

                    if (useItem.isEmpty() || player.getRandom().nextInt(100) < 2) {
                        float pitch = 0.8F + player.level().random.nextFloat() * 0.4F;
                        EquipmentSlot slot = usedItemHand == InteractionHand.MAIN_HAND ?
                                EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        player.playSound(SoundEvents.SHIELD_BREAK, 0.8F, pitch);
                        player.setItemSlot(slot, ItemStack.EMPTY);
                        player.stopUsingItem();
                    }
                }
            }

            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = event.getEffectInstance().getEffect();
        List<MobEffect> effects = MoonQueen.getExclusiveEffects();
        final MobEffect holiness = TAMobEffects.HOLINESS.get();
        final MobEffect incantation = TAMobEffects.INCANTATION.get();
        boolean flag1 = effect == incantation && entity.hasEffect(holiness);
        boolean flag2 = effect == holiness && entity.hasEffect(incantation);
        boolean flag3 = effect == TAMobEffects.PARALYSIS.get() && !(entity instanceof Player);
        boolean flag4 = effects.contains(effect) && !(entity instanceof MoonQueen);
        if (flag1 || flag2 || flag3 || flag4) {
            event.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void onMobEffectAdded(MobEffectEvent.Added event) {
        MobEffect effect = TAMobEffects.CORRUPTION.get();
        MobEffectInstance instance = event.getEffectInstance();
        LivingEntity entity = event.getEntity();
        if (instance.getEffect() == effect) {
            int duration = instance.getDuration();
            entity.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                int oldValidTime = miscNBT.validCorruptionTime;
                if (!entity.hasEffect(effect) || duration > oldValidTime) {
                    miscNBT.validCorruptionTime = duration;
                }
            });
        }
    }

    @SubscribeEvent
    public static void onMobEffectExpired(MobEffectEvent.Expired event) {
        MobEffectInstance instance = event.getEffectInstance();
        LivingEntity entity = event.getEntity();
        if (instance != null) {
            MobEffect effect = instance.getEffect();
            if (effect == TAMobEffects.PARALYSIS.get()) {
                BlockPos pos = entity.getOnPos();
                if (entity.getVehicle() instanceof SitEntity sitEntity) {
                    entity.moveTo(pos.getX(), pos.above().getY(), pos.getZ());
                    sitEntity.ejectPassengers();
                    sitEntity.discard();
                }
            }

            if (effect == TAMobEffects.CRYSTALLIZATION.get() && entity instanceof ServerPlayer player) {
                player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                    AttributeInstance attribute = player.getAttribute(Attributes.MAX_HEALTH);
                    List<UUID> list = miscNBT.maxHealthSubtractUuids;
                    if (attribute != null && !list.isEmpty()) {
                        miscNBT.maxHealthSubtractUuids.clear();
                        list.forEach(uuid -> {
                            if (attribute.getModifier(uuid) != null) {
                                attribute.removeModifier(uuid);
                            }
                        });
                    }
                });
            }

            if (effect instanceof CorruptionEffect corruption) {
                corruption.doHurtTarget(entity);
            }

            if (effect instanceof ForbiddenCurseEffect forbiddenCurse && entity instanceof Player player) {
                forbiddenCurse.restorePlayerInventoryItemEnchantments(player);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        if (event.getEntity() instanceof Player player && player.level().getDifficulty() != Difficulty.PEACEFUL) {
            event.setCanceled(player.hasEffect(TAMobEffects.INCANTATION.get()) || player.hasEffect(TAMobEffects.PRESSURE.get()));
        }
    }

    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(TAMobEffects.PARALYSIS.get()) ||
                entity.hasEffect(TAMobEffects.STUN.get())) {
            entity.setDeltaMovement(Vec3.ZERO);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        LivingEntity entity = event.getEntity();
        boolean isHarmfulEffect = source.is(DamageTypes.INDIRECT_MAGIC) || source.is(DamageTypes.MAGIC);
        event.setAmount(TAMobEffect.getDamageAfterMagicAbsorb(entity, source, event.getAmount()));
        event.setCanceled(isHarmfulEffect && entity.hasEffect(TAMobEffects.HOLINESS.get()));
        if (entity instanceof ServerPlayer player) {
            player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> miscNBT.exhaustionAccumulation += source.getFoodExhaustion());
        }

        if (source.getEntity() instanceof LivingEntity livingEntity) {
            ItemStack itemInHand = livingEntity.getItemInHand(livingEntity.getUsedItemHand());
            int level = itemInHand.getEnchantmentLevel(TAEnchantments.OVERLOAD.get());
            float amount = event.getAmount();
            if (level > 0) {
                event.setAmount(amount + amount * level);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        Entity sourceEntity = source.getEntity();
        if (target instanceof Player player && sourceEntity instanceof MoonQueen) {
            event.setAmount(Math.max(1.0F, event.getAmount()));
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                    if (++miscNBT.uninterruptedHurtByMoonQueenCount >= 10) {
                        MobEffect effect = TAMobEffects.LACERATION.get();
                        serverPlayer.addEffect(new MobEffectInstance(effect, 100));
                    }
                });
            }
        }

        if (target != null) {
            MobEffect effect = TAMobEffects.CORRUPTION.get();
            for (ItemStack piece : target.getArmorSlots()) {
                if (piece.getItem() instanceof ArmorItem armorItem) {
                    if (armorItem.getMaterial() == TAArmorMaterials.AURORIAN_STEEL) {
                        AurorianSteelHelper.handleAurorianSteelDurability(piece);
                    }
                }
            }

            if (target.hasEffect(TAMobEffects.CRYSTALLIZATION.get()) && target instanceof ServerPlayer player) {
                event.setAmount(event.getAmount() * 1.5F);
                player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                    AttributeInstance attribute = player.getAttribute(Attributes.MAX_HEALTH);
                    AttributeModifier.Operation operation = AttributeModifier.Operation.MULTIPLY_TOTAL;
                    if (attribute != null && player.getRandom().nextFloat() <= 0.25F) {
                        AttributeModifier modifier = new AttributeModifier("Crystallization", -0.1D, operation);
                        miscNBT.maxHealthSubtractUuids.add(modifier.getId());
                        attribute.addTransientModifier(modifier);
                    }
                });
            }

            if (target.hasEffect(effect)) {
                target.getCapability(TACapability.MISC_CAP).ifPresent(
                        miscNBT -> miscNBT.damageAccumulation += event.getAmount());
                //Prevent the death message doesn't show.
                if (Objects.requireNonNull(target.getEffect(effect)).getDuration() > 10) {
                    event.setCanceled(true);
                }
            }
        }

        if (sourceEntity instanceof LivingEntity livingEntity) {
            float chance = 0.00F;
            for (ItemStack piece : livingEntity.getArmorSlots()) {
                if (piece.getItem() instanceof ArmorItem armorItem) {
                    if (armorItem.getMaterial() == TAArmorMaterials.SPECTRAL) {
                        chance += 0.06F;
                    }
                }
            }

            if (chance != 0.00F && livingEntity.getRandom().nextFloat() <= chance) {
                for (MobEffectInstance effectInstance : livingEntity.getActiveEffects()) {
                    if (effectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                        livingEntity.removeEffect(effectInstance.getEffect());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        Entity sourceEntity = event.getSource().getEntity();
        LivingEntity entity = event.getEntity();
        if (sourceEntity instanceof MoonQueen moonQueen) {
            moonQueen.safeTime = 0;
            MobEffect effect = TAMobEffects.MOON_BEFALL.get();
            if (entity instanceof ServerPlayer player) {
                if (moonQueen.hasEffect(effect)) {
                    moonQueen.removeEffect(effect);
                }

                if (moonQueen.duelingMoment) {
                    String uuid = player.getStringUUID();
                    moonQueen.killedDuelistUUID.add(uuid);
                    moonQueen.selectDuelistFromNearestTarget();
                    moonQueen.heal((moonQueen.getMaxHealth() * 0.1F));
                }
            }

            if (!(entity instanceof Player) && !entity.isRemoved()) {
                Level level = entity.level();
                if (entity.isSleeping()) {
                    entity.stopSleeping();
                }

                entity.getCombatTracker().recheckStatus();
                if (level instanceof ServerLevel) {
                    entity.gameEvent(GameEvent.ENTITY_DIE);
                    level.broadcastEntityEvent(entity, (byte)3);
                }

                entity.setPose(Pose.DYING);
                event.setCanceled(true);
            }
        }

        if (sourceEntity instanceof ServerPlayer serverPlayer) {
            AttributeInstance instance = serverPlayer.getAttribute(Attributes.MAX_HEALTH);
            if (entity instanceof SpiderMother && instance != null) {
                if (instance.getModifier(WebbingEntity.MAX_HEALTH_SUBTRACT_WEBBING) != null) {
                    instance.removeModifier(WebbingEntity.MAX_HEALTH_SUBTRACT_WEBBING);
                }
            }

            if (entity instanceof MoonQueen) {
                serverPlayer.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> miscNBT.immuneToPressure = true);
            }

            ItemStack stack = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
            if (stack.is(TAItems.TSLAT_SWORD.get())) {
                int count = stack.getOrCreateTag().getInt("KillCount");
                stack.getOrCreateTag().putInt("KillCount", count + 1);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingAttacked(LivingAttackEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        event.setCanceled(source.is(DamageTypes.FREEZE) && target.hasEffect(TAMobEffects.WARM.get()));
        if (source.getEntity() instanceof ServerPlayer serverPlayer) {
            ItemStack stack = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
            if (stack.is(TAItems.TSLAT_SWORD.get()) && !target.isDamageSourceBlocked(source)) {
                int count = stack.getOrCreateTag().getInt("KillCount");
                if (count > 20) {
                    count = 20;
                }

                if (target.isAlive()) {
                    target.setHealth(target.getHealth() - count * 0.05F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event.getRayTraceResult() instanceof EntityHitResult result) {
            Projectile projectile = event.getProjectile();
            if (result.getEntity() instanceof LivingEntity livingEntity) {
                boolean flag = projectile instanceof ThrownEgg || projectile instanceof Snowball;
                if (flag && projectile.getOwner() instanceof Player player && player.hasEffect(TAMobEffects.PARALYSIS.get())) {
                    livingEntity.hurt(livingEntity.damageSources().thrown(projectile, player), 1.0F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void playerBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        BlockState state = event.getState();
        ItemStack blockStack = new ItemStack(state.getBlock());
        ItemStack handStack = player.getItemInHand(player.getUsedItemHand());
        if (blockStack.is(Tags.Items.ORES) && handStack.is(TAItems.AURORIANITE_PICKAXE.get())) {
            event.setNewSpeed(event.getOriginalSpeed() * 1.4F);
        } else if (state.is(TABlockTags.DUNGEON_BRICKS)) {
            boolean flag = handStack.is(TAItems.QUEENS_CHIPPER.get());
            event.setNewSpeed(flag ? event.getOriginalSpeed() * 16.0F : 0.0F);
        } else if (handStack.is(TAItems.UMBRA_PICKAXE.get())) {
            CompoundTag compoundTag = handStack.getOrCreateTag().getCompound("SelectedBlock");
            HolderLookup<Block> blockGetter = player.level().holderLookup(Registries.BLOCK);
            BlockState selected = NbtUtils.readBlockState(blockGetter, compoundTag);
            if (state.is(selected.getBlock()) && !state.isAir()) {
                event.setNewSpeed(event.getOriginalSpeed() * 2.0F);
            }
        }
    }

}