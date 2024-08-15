package cn.teampancake.theaurorian.common.entities.ai.goal;

import cn.teampancake.theaurorian.common.registry.TAAttachmentTypes;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;

public class AurorianAnimalPanicGoal extends PanicGoal {

    public AurorianAnimalPanicGoal(PathfinderMob mob, double speedModifier) {
        super(mob, speedModifier);
    }

    @Override
    protected boolean shouldPanic() {
        return super.shouldPanic() && !this.isSpawnInOverworld();
    }

    private boolean isSpawnInOverworld() {
        return this.mob.getData(TAAttachmentTypes.SPAWN_IN_OVERWORLD);
    }

}