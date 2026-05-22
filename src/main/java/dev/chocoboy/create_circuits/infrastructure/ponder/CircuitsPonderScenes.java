package dev.chocoboy.create_circuits.infrastructure.ponder;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.chocoboy.create_circuits.infrastructure.ponder.scenes.ArithmeticScenes;
import dev.chocoboy.create_circuits.infrastructure.ponder.scenes.LogicScenes;
import dev.chocoboy.create_circuits.infrastructure.ponder.scenes.MemoryScenes;
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

        HELPER.forComponents(CircuitsBlocks.XNOR_GATE)
                .addStoryBoard("xnor", LogicScenes::xnorGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.NOT_GATE)
                .addStoryBoard("not", LogicScenes::notGate, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.SUBTRACTOR)
                .addStoryBoard("subtractor", ArithmeticScenes::subtractor, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.ADDER)
                .addStoryBoard("adder", ArithmeticScenes::adder, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.MULTIPLIER)
                .addStoryBoard("multiplier", ArithmeticScenes::multiplier, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.MAX)
                .addStoryBoard("max", ArithmeticScenes::max, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.MIN)
                .addStoryBoard("min", ArithmeticScenes::min, CircuitsPonderTags.CIRCUITS);

        HELPER.forComponents(CircuitsBlocks.SR_LATCH)
                .addStoryBoard("sr_latch", MemoryScenes::srLatch, CircuitsPonderTags.CIRCUITS);
    }
}
