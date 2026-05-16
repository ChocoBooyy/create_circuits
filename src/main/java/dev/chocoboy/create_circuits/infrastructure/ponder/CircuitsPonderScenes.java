package dev.chocoboy.create_circuits.infrastructure.ponder;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.chocoboy.create_circuits.infrastructure.ponder.scenes.LogicScenes;
import dev.chocoboy.create_circuits.registry.CircuitsBlocks;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public final class CircuitsPonderScenes {

    private CircuitsPonderScenes() {}

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(CircuitsBlocks.AND_GATE)
                .addStoryBoard("and", LogicScenes::andGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.NAND_GATE)
                .addStoryBoard("nand", LogicScenes::nandGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.NOR_GATE)
                .addStoryBoard("nor", LogicScenes::norGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.OR_GATE)
                .addStoryBoard("or", LogicScenes::orGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.XOR_GATE)
                .addStoryBoard("xor", LogicScenes::xorGate, CircuitsPonderTags.CIRCUITS);
    }
}
