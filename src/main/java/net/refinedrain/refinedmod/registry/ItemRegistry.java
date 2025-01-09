package net.refinedrain.refinedmod.registry;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import net.refinedrain.refinedmod.RefinedMod;
import net.refinedrain.refinedmod.items.FlameTongueSword;
import net.refinedrain.refinedmod.items.SummerRainSword;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RefinedMod.MOD_ID);

    public static final RegistryObject<Item> SUMMER_RAIN_SWORD = ITEMS.register("summer_rain_sword", () -> new SummerRainSword(SpellDataRegistryHolder.of(new SpellDataRegistryHolder(ExampleSpellRegistry.MOON_SLASH_SPELL, 3))));
    public static final RegistryObject<Item> FLAME_TONGUE_SWORD = ITEMS.register("flame_tongue_sword", () -> new FlameTongueSword(SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 3))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}