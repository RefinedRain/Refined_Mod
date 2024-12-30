package net.refinedrain.refinedmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.refinedrain.refinedmod.RefinedMod;
import net.refinedrain.refinedmod.entity.spells.frost_strike.FrostStrikeEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RefinedMod.MOD_ID);

    public static final RegistryObject<EntityType<FrostStrikeEntity>> FROST_STRIKE_ENTITY =
            ENTITY_TYPES.register("frost_strike", () -> EntityType.Builder.<FrostStrikeEntity>of(FrostStrikeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("water_slash"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
