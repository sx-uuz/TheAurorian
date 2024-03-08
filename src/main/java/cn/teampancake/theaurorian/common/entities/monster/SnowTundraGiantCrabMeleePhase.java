package cn.teampancake.theaurorian.common.entities.monster;

public class SnowTundraGiantCrabMeleePhase extends AttackPhase<SnowTundraGiantCrab> {
    public static final int ID = 1;

    public SnowTundraGiantCrabMeleePhase() {
        super(ID, 1, 30, 10);
    }

    @Override
    public boolean canStart(SnowTundraGiantCrab entity, boolean coolDownOver) {
        return coolDownOver && entity.canReachTarget(3);
    }

    @Override
    public void onStart(SnowTundraGiantCrab entity) {
        entity.triggerMeleeAttackAnim();
    }

    @Override
    public void tick(SnowTundraGiantCrab entity) {
        if (entity.getAttackTicks() == 20f * 0.75f) {
            entity.performMeleeAttack(3);
        }
    }

    @Override
    public boolean canContinue(SnowTundraGiantCrab entity) {
        return true;
    }

    @Override
    public void onStop(SnowTundraGiantCrab entity) {

    }
}
