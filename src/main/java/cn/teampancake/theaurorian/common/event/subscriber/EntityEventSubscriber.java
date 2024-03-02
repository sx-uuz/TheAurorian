package cn.teampancake.theaurorian.common.event.subscriber;

import cn.teampancake.theaurorian.AurorianMod;
import cn.teampancake.theaurorian.common.config.AurorianConfig;
import cn.teampancake.theaurorian.common.data.datagen.tags.TABlockTags;
import cn.teampancake.theaurorian.common.data.datagen.tags.TAEntityTags;
import cn.teampancake.theaurorian.common.effect.CorruptionEffect;
import cn.teampancake.theaurorian.common.effect.ForbiddenCurseEffect;
import cn.teampancake.theaurorian.common.effect.TAMobEffect;
import cn.teampancake.theaurorian.common.entities.boss.MoonQueen;
import cn.teampancake.theaurorian.common.entities.boss.RunestoneKeeper;
import cn.teampancake.theaurorian.common.entities.boss.SpiderMother;
import cn.teampancake.theaurorian.common.entities.monster.CrystallineSprite;
import cn.teampancake.theaurorian.common.entities.monster.SnowTundraGiantCrab;
import cn.teampancake.theaurorian.common.items.TAArmorMaterials;
import cn.teampancake.theaurorian.common.items.armor.MysteriumWoolArmor;
import cn.teampancake.theaurorian.common.network.TAMessages;
import cn.teampancake.theaurorian.common.network.message.FrostbiteSyncMessage;
import cn.teampancake.theaurorian.common.registry.*;
import cn.teampancake.theaurorian.common.utils.AurorianSteelHelper;
import cn.teampancake.theaurorian.common.utils.AurorianUtil;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

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
                    player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> miscNBT.setTicksFrostbite(140));
                    player.hurt(player.damageSources().freeze(), 1.0F);
                    player.setSharedFlagOnFire(false);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        entity.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
            int i = miscNBT.getTicksFrostbite();
            if (!entity.level().isClientSide && i > 0) {
                miscNBT.setTicksFrostbite(Math.max(0, i - 2));
                if (entity instanceof ServerPlayer serverPlayer) {
                    TAMessages.sendToPlayer(new FrostbiteSyncMessage(i), serverPlayer);
                }
            }
        });
    }

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        DamageSource source = event.getDamageSource();
        if (event.getEntity() instanceof Player player && source.getEntity() instanceof SnowTundraGiantCrab) {
            float damage = event.getBlockedDamage();
            ItemStack useItem =player.getUseItem();
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
    public static void onCalculatePotionColor(PotionColorCalculationEvent event) {
        Set<MobEffect> effects = TAMobEffect.getMoonQueenOnlyEffects();
        event.getEffects().forEach(instance -> {
            if (effects.contains(instance.getEffect())) {
                event.shouldHideParticles(true);
                event.setColor(0);
            }
        });
    }

    @SubscribeEvent
    public static void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = event.getEffectInstance().getEffect();
        final MobEffect holiness = TAMobEffects.HOLINESS.get();
        final MobEffect incantation = TAMobEffects.INCANTATION.get();
        boolean flag1 = effect == incantation && entity.hasEffect(holiness);
        boolean flag2 = effect == holiness && entity.hasEffect(incantation);
        if (flag1 || flag2) {
            event.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void onMobEffectExpired(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        MobEffectInstance instance = event.getEffectInstance();
        if (instance != null) {
            MobEffect effect = instance.getEffect();
            if (effect instanceof CorruptionEffect corruption) {
                corruption.doHurtTarget(entity);
            }

            if (effect instanceof ForbiddenCurseEffect forbiddenCurse && entity instanceof Player player) {
                forbiddenCurse.restorePlayerInventoryItemEnchantments(player);
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Monster monster) {
            GameRules gameRules = event.getLevel().getGameRules();
            double baseHealth = monster.getAttributeBaseValue(Attributes.MAX_HEALTH);
            double baseAttackDamage = monster.getAttributeBaseValue(Attributes.ATTACK_DAMAGE);
            double baseMovementSpeed = monster.getAttributeBaseValue(Attributes.MOVEMENT_SPEED);
            GameRules.BooleanValue rule1 = gameRules.getRule(TAGameRules.RULE_ENABLE_NIGHTMARE_MODE);
            GameRules.IntegerValue rule2 = gameRules.getRule(TAGameRules.RULE_NIGHTMARE_MODE_MULTIPLIER);
            if (monster.getType().is(TAEntityTags.AFFECTED_BY_NIGHTMARE_MODE)) {
                if (rule1 != null && rule2 != null) {
                    double multiplier = Math.max(1.0D, rule2.get());
                    double newHealth = rule1.get() ? baseHealth * multiplier * 2.0D : baseHealth;
                    double newAttackDamage = rule1.get() ? baseAttackDamage * multiplier * 2.0D : baseAttackDamage;
                    double newMovementSpeed = rule1.get() ? baseMovementSpeed * multiplier * 2.0D : baseMovementSpeed;
                    monster.getAttribute(Attributes.MAX_HEALTH).setBaseValue(newHealth);
                    monster.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(newAttackDamage);
                    if (!(monster instanceof CrystallineSprite)) {
                        monster.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(newMovementSpeed);
                    }
                }
            } else if (monster instanceof RunestoneKeeper runestoneKeeper) {
                double healthMultiplier = AurorianConfig.CONFIG_RUNESTONE_KEEPER_HEALTH_MULIPLIER.get();
                double damageMultiplier = AurorianConfig.CONFIG_RUNESTONE_KEEPER_DAMAGE_MULIPLIER.get();
                runestoneKeeper.getAttribute(Attributes.MAX_HEALTH).setBaseValue(baseHealth * healthMultiplier);
                runestoneKeeper.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseAttackDamage * damageMultiplier);
            } else if (monster instanceof SpiderMother spiderMother) {
                double healthMultiplier = AurorianConfig.CONFIG_SPIDER_MOTHER_HEALTH_MULIPLIER.get();
                double damageMultiplier = AurorianConfig.CONFIG_SPIDER_MOTHER_DAMAGE_MULIPLIER.get();
                spiderMother.getAttribute(Attributes.MAX_HEALTH).setBaseValue(baseHealth * healthMultiplier);
                spiderMother.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseAttackDamage * damageMultiplier);
            } else if (monster instanceof MoonQueen moonQueen) {
                double healthMultiplier = AurorianConfig.CONFIG_MOON_QUEEN_HEALTH_MULIPLIER.get();
                double damageMultiplier = AurorianConfig.CONFIG_MOON_QUEEN_DAMAGE_MULIPLIER.get();
                moonQueen.getAttribute(Attributes.MAX_HEALTH).setBaseValue(baseHealth * healthMultiplier);
                moonQueen.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseAttackDamage * damageMultiplier);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        event.setCanceled(event.getEntity() instanceof Player player &&
                (player.hasEffect(TAMobEffects.INCANTATION.get()) ||
                        player.hasEffect(TAMobEffects.PRESSURE.get())));
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
        if (entity instanceof Player player) {
            player.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                float i = miscNBT.getExhaustionAccumulation();
                float j = source.getFoodExhaustion();
                miscNBT.setExhaustionAccumulation(i + j);
            });
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
        if (target != null) {
            for (ItemStack piece : target.getArmorSlots()) {
                if (piece.getItem() instanceof ArmorItem armorItem) {
                    if (armorItem.getMaterial() == TAArmorMaterials.AURORIAN_STEEL) {
                        AurorianSteelHelper.handleAurorianSteelDurability(piece);
                    }
                }
            }

            if (target.hasEffect(TAMobEffects.CORRUPTION.get())) {
                target.getCapability(TACapability.MISC_CAP).ifPresent(miscNBT -> {
                    float i = miscNBT.getDamageAccumulation();
                    miscNBT.setDamageAccumulation(i + event.getAmount());
                });

                event.setCanceled(true);
            }
        }

        DamageSource source = event.getSource();
        if (source.getEntity() instanceof LivingEntity livingEntity) {
            float chance = 0.00F;
            for (ItemStack piece : livingEntity.getArmorSlots()) {
                if (piece.getItem() instanceof ArmorItem armorItem) {
                    if (armorItem.getMaterial() == TAArmorMaterials.SPECTRAL) {
                        chance += AurorianConfig.CONFIG_SPECTRAL_ARMOR_CLEANSE_CHANCE.get();
                    }
                }
            }

            if (chance != 0.00F && AurorianUtil.randomChanceOf(chance)) {
                for (MobEffectInstance effectInstance : livingEntity.getActiveEffects()) {
                    if (effectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                        livingEntity.removeEffect(effectInstance.getEffect());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onKilledMob(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer) {
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
        if (source.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity instanceof ServerPlayer serverPlayer) {
                ItemStack stack = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
                if (stack.is(TAItems.TSLAT_SWORD.get()) && !target.isDamageSourceBlocked(source)) {
                    int count = stack.getOrCreateTag().getInt("KillCount");
                    if (count > 20) {
                        count = 20;
                    }

                    if (target.isAlive()) {
                        target.setHealth(event.getEntity().getHealth() - count * 0.05F);
                    }
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
        }
    }

}