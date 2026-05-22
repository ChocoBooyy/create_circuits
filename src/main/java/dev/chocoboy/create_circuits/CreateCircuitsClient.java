package dev.chocoboy.create_circuits;

import dev.chocoboy.create_circuits.infrastructure.ponder.CircuitsPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public final class CreateCircuitsClient {

    private CreateCircuitsClient() {}

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(CreateCircuitsClient::onClientSetup);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new CircuitsPonderPlugin());
    }
}
