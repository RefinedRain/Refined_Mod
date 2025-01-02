package net.refinedrain.refinedmod.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.RegistryObject;
import net.refinedrain.refinedmod.RefinedMod;
import net.refinedrain.refinedmod.entity.spells.frost_strike.FrostStrikeEntity;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RefinedMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final RegistryObject<EntityType<FrostStrikeEntity>> FROST_STRIKE_ENTITY =
            ENTITIES.register("frost_strike", () -> EntityType.Builder.<FrostStrikeEntity>of(FrostStrikeEntity::new, MobCategory.MISC)
                    .sized(5f, 1f)
                    .clientTrackingRange(64)
                    .build(new ResourceLocation(RefinedMod.MOD_ID, "frost_strike").toString()));

}
