package net.refinedrain.refinedmod.setup;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.refinedrain.refinedmod.RefinedMod;
import net.refinedrain.refinedmod.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.refinedrain.refinedmod.entity.spells.frost_strike.FrostStrikeRenderer;

@Mod.EventBusSubscriber(modid = RefinedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.FROST_STRIKE_ENTITY.get(), FrostStrikeRenderer::new);
    }
}