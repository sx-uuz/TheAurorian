package cn.teampancake.theaurorian.common.event.subscriber;

import cn.teampancake.theaurorian.TheAurorian;
import cn.teampancake.theaurorian.common.components.SourceOfTerra;
import cn.teampancake.theaurorian.common.registry.TADataComponents;
import cn.teampancake.theaurorian.common.registry.TAEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

import java.util.List;

@EventBusSubscriber(modid = TheAurorian.MOD_ID)
public class BlockEventSubscriber {

    @SubscribeEvent
    public static void onBlockDrops(BlockDropsEvent event) {
        List<ItemEntity> drops = event.getDrops();
        if (!drops.isEmpty() && event.getBreaker() instanceof Player player) {
            ItemStack itemInHand = player.getItemInHand(player.getUsedItemHand());
            DataComponentType<SourceOfTerra> componentType = TADataComponents.SOURCE_OF_TERRA.get();
            if (itemInHand.getEnchantmentLevel(TAEnchantments.get(player.level(), TAEnchantments.SOURCE_OF_TERRA)) > 0) {
                SourceOfTerra sourceOfTerra = itemInHand.get(componentType);
                if (sourceOfTerra != null) {
                    ResourceLocation levelResource = ResourceLocation.parse(sourceOfTerra.dimension());
                    ResourceKey<Level> levelKey = ResourceKey.create(Registries.DIMENSION, levelResource);
                    MinecraftServer server = player.level().getServer();
                    if (server != null) {
                        ServerLevel targetLevel = server.getLevel(levelKey);
                        if (targetLevel != null) {
                            int selectedX = sourceOfTerra.selectedX();
                            int selectedY = sourceOfTerra.selectedY();
                            int selectedZ = sourceOfTerra.selectedZ();
                            BlockPos targetPos = new BlockPos(selectedX, selectedY, selectedZ);
                            BlockState state = targetLevel.getBlockState(targetPos);
                            BlockEntity blockEntity = targetLevel.getBlockEntity(targetPos);
                            if (state.hasBlockEntity() && blockEntity instanceof Container container) {
                                drops.forEach(itemEntity -> HopperBlockEntity.addItem(container, itemEntity));
                            } else if (player instanceof ServerPlayer serverPlayer) {
                                serverPlayer.sendSystemMessage(Component.translatable("message.source_of_terra.invalid"));
                                itemInHand.remove(componentType);
                            }
                        }
                    }
                }
            }
        }
    }

}