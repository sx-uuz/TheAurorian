package cn.teampancake.theaurorian.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class CrystallinePickaxe extends PickaxeItem implements ITooltipsItem{
    public CrystallinePickaxe() {
        super(ModToolTiers.CRYSTALLINE, 1, -2.8F, new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !(EnchantmentHelper.getEnchantments(stack).containsKey(Enchantments.BLOCK_FORTUNE));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0D) {
            if (state.is(Tags.Blocks.ORES)) {
                ItemStack ingot = getCraftingRemainingItem(state.getBlock().asItem().getDefaultInstance());
                ItemStack nugget = getCraftingRemainingItem(ingot);
                if (ingot != null) {
                    level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), ingot));
                    if (nugget != null) {
                        nugget.setCount(level.random.nextIntBetweenInclusive(1,3)+1);
                        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), nugget));
                    }
                    stack.hurtAndBreak(2,entityLiving,(player) -> player.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    return true;
                }
            }
            stack.hurtAndBreak(1,entityLiving,(player) -> player.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return true;
    }
}
