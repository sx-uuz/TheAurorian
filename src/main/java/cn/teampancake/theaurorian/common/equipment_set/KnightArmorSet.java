package cn.teampancake.theaurorian.common.equipment_set;

import cn.teampancake.theaurorian.common.registry.TAItems;
import com.pancake.pancake_lib.api.IEquipmentSet;
import com.pancake.pancake_lib.common.bonus.BonusHandler;
import com.pancake.pancake_lib.common.equipment_set.EquipmentSet;
import com.pancake.pancake_lib.common.equippable.EquippableGroup;
import com.pancake.pancake_lib.common.equippable.VanillaIEquippable;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;


public class KnightArmorSet extends EquipmentSet {
    @Override
    public void init(BonusHandler<IEquipmentSet> bonusHandler, EquippableGroup equippableGroup) {
        equippableGroup
                .addGroup(VanillaIEquippable.of(EquipmentSlot.HEAD),TAItems.KNIGHT_HELMET.get())
                .addGroup(VanillaIEquippable.of(EquipmentSlot.CHEST),TAItems.KNIGHT_CHESTPLATE.get())
                .addGroup(VanillaIEquippable.of(EquipmentSlot.LEGS),TAItems.KNIGHT_LEGGINGS.get())
                .addGroup(VanillaIEquippable.of(EquipmentSlot.FEET),TAItems.KNIGHT_BOOTS.get());

        bonusHandler.addEffectModifier(MobEffects.DAMAGE_BOOST, -1, 0);
    }
}
