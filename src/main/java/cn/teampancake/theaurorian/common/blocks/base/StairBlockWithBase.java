package cn.teampancake.theaurorian.common.blocks.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class StairBlockWithBase extends StairBlock {

    public StairBlockWithBase(BlockState base, Properties properties) {
        super(base, properties);
    }

    public Block getBase() {
        return this.base;
    }

}