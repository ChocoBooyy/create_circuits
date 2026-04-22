package dev.chocoboy.create_circuits.registry;

import dev.chocoboy.create_circuits.CreateCircuits;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CircuitsCreativeTabs {

    private static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCircuits.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CIRCUITS_TAB =
        TABS.register("circuits_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.create_circuits"))
            .icon(() -> CircuitsBlocks.AND_GATE.asStack())
            .displayItems((params, output) -> {
                CircuitsBlocks.getAllBlocks().forEach(b -> output.accept(b.asStack()));
            })
            .build());

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}
