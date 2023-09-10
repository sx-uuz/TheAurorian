package cn.teampancake.theaurorian.common.items;

import cn.teampancake.theaurorian.data.tags.ModBlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockState;

public class QueensChipper extends PickaxeItem {

    public QueensChipper() {
        super(ModToolTiers.AURORIAN_STEEL, (5), (-1.2f), new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return super.isCorrectToolForDrops(stack, state) || state.is(ModBlockTags.DUNGEON_BRICKS);
    }

}