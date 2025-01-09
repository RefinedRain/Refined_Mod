package net.refinedrain.refinedmod.items;

import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

import java.util.Map;
import java.util.UUID;

public class FlameTongueSword extends MagicSwordItem {
    public FlameTongueSword(SpellDataRegistryHolder[] imbuedSpells) {
        super(Tiers.NETHERITE, 7, -2.4f, imbuedSpells,
                Map.of(

                        AttributeRegistry.FIRE_SPELL_POWER.get(),
                        new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", .10, AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.FIRE_MAGIC_RESIST.get(),
                        new AttributeModifier(UUID.fromString("212b5a66-2b43-4c18-ab05-6de0cc4d64d3"), "Weapon Modifier", .10, AttributeModifier.Operation.MULTIPLY_BASE)
                ),
                ItemPropertiesHelper.equipment(1).rarity(Rarity.EPIC));
    }
}
