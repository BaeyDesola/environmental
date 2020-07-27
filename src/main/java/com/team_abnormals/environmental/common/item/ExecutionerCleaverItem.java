package com.team_abnormals.environmental.common.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class ExecutionerCleaverItem extends SwordItem {
    private final float attackDamage;
    private final float attackSpeed;

    public ExecutionerCleaverItem(IItemTier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, 6, attackSpeed, properties);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlotType.MAINHAND)
        {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
        }

        return multimap;
    }
}
