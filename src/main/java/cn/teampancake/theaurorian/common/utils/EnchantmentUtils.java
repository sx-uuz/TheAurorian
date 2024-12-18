package cn.teampancake.theaurorian.common.utils;

import com.google.common.collect.Maps;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.List;
import java.util.Map;

public class EnchantmentUtils {

    public static int getEnchantmentLevel(Holder<Enchantment> enchantment, LivingEntity entity) {
        int i = 0;
        for (ItemStack itemStack : getSlotItems(enchantment.value(), entity).values()) {
            int j = EnchantmentHelper.getTagEnchantmentLevel(enchantment, itemStack);
            if (j > i) {
                i = j;
            }
        }

        return i;
    }

    public static Map<EquipmentSlot, ItemStack> getSlotItems(Enchantment enchantment, LivingEntity entity) {
        Map<EquipmentSlot, ItemStack> map = Maps.newEnumMap(EquipmentSlot.class);
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (matchingSlot(enchantment, equipmentSlot)) {
                ItemStack itemStack = entity.getItemBySlot(equipmentSlot);
                if (!itemStack.isEmpty()) {
                    map.put(equipmentSlot, itemStack);
                }
            }
        }

        return map;
    }

    private static boolean matchingSlot(Enchantment enchantment, EquipmentSlot slot) {
        List<EquipmentSlotGroup> slotGroups = enchantment.definition().slots();
        for (EquipmentSlotGroup slotGroup : slotGroups) {
            if (slotGroup.test(slot)) {
                return true;
            }
        }

        return false;
    }

}