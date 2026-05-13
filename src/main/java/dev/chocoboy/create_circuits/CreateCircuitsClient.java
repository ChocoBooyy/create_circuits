package dev.chocoboy.create_circuits;

import dev.chocoboy.create_circuits.infrastructure.ponder.CircuitsPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = CreateCircuits.MOD_ID, dist = Dist.CLIENT)
public class CreateCircuitsClient {

    public CreateCircuitsClient(IEventBus modEventBus) {
        modEventBus.addListener(CreateCircuitsClient::onClientSetup);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new CircuitsPonderPlugin());
    }
}
