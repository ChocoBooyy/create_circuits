package dev.chocoboy.create_circuits.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import dev.chocoboy.create_circuits.CreateCircuits;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.adder.AdderBlock;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.max.MaxBlock;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.min.MinBlock;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.multiplier.MultiplierBlock;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.subtractor.SubtractorBlock;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.and.AndGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.nand.NandGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.nor.NorGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.not.NotGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.or.OrGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.xnor.XnorGateBlock;
import dev.chocoboy.create_circuits.content.blocks.logic.xor.XorGateBlock;
import dev.chocoboy.create_circuits.content.blocks.memory.latch.SRLatchBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

import java.util.ArrayList;
import java.util.List;

public final class CircuitsBlocks {

    static final CreateRegistrate REGISTRATE = CreateCircuits.REGISTRATE;
    static final List<BlockEntry<?>> ALL_BLOCKS = new ArrayList<>();

    static {
        // Registrate defaults to adding all items to CreativeModeTabs.SEARCH via BuildCreativeModeTabContentsEvent.
        // The SEARCH tab also auto-collects from all other tabs, so items end up added twice → crash.
        // Setting null prevents Registrate from auto-assigning any default tab.
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    public static final BlockEntry<AndGateBlock>  AND_GATE  = gate("and_gate",  AndGateBlock::new);
    public static final BlockEntry<OrGateBlock>   OR_GATE   = gate("or_gate",   OrGateBlock::new);
    public static final BlockEntry<NotGateBlock>  NOT_GATE  = gateOneInput("not_gate", NotGateBlock::new);
    public static final BlockEntry<NandGateBlock> NAND_GATE = gate("nand_gate", NandGateBlock::new);
    public static final BlockEntry<NorGateBlock>  NOR_GATE  = gate("nor_gate",  NorGateBlock::new);
    public static final BlockEntry<XorGateBlock>  XOR_GATE  = gate("xor_gate",  XorGateBlock::new);
    public static final BlockEntry<XnorGateBlock> XNOR_GATE = gate("xnor_gate", XnorGateBlock::new);

    public static final BlockEntry<AdderBlock>      ADDER      = gate("adder",      AdderBlock::new);
    public static final BlockEntry<SubtractorBlock> SUBTRACTOR = gate("subtractor", SubtractorBlock::new);
    public static final BlockEntry<MultiplierBlock> MULTIPLIER = gate("multiplier", MultiplierBlock::new);
    public static final BlockEntry<MaxBlock>        MAX        = gate("max",        MaxBlock::new);
    public static final BlockEntry<MinBlock>        MIN        = gate("min",        MinBlock::new);
    public static final BlockEntry<SRLatchBlock>    SR_LATCH   = latch("sr_latch",  SRLatchBlock::new);

    private static int yRot(Direction facing) {
        return switch (facing) {
            case WEST  -> 90;
            case NORTH -> 180;
            case EAST  -> 270;
            default    -> 0;
        };
    }

    static <T extends AbstractSignalBlock> BlockEntry<T> gate(
            String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        BlockEntry<T> entry = REGISTRATE.block(name, factory)
            .properties(p -> p.mapColor(MapColor.METAL)
                .strength(1.5f, 6.0f)
                .sound(SoundType.METAL)
                .noOcclusion()
                .requiresCorrectToolForDrops())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.getVariantBuilder(c.get()).forAllStates(state -> {
                boolean a = state.getValue(AbstractSignalBlock.INPUT_A);
                boolean b = state.getValue(AbstractSignalBlock.INPUT_B);
                String suffix = (a ? "1" : "0") + (b ? "1" : "0");
                String parent = c.get().isOutputHigh(a, b) ? "block/circuit_on" : "block/circuit_off";
                String texPath = "create_circuits:block/" + c.getName() + "/" + c.getName() + "_" + suffix;
                return ConfiguredModel.builder()
                    .modelFile(p.models()
                        .withExistingParent(c.getName() + "_" + suffix, p.modLoc(parent))
                        .texture("indicator", texPath)
                        .texture("particle", texPath))
                    .rotationY(yRot(state.getValue(AbstractSignalBlock.FACING)))
                    .build();
            }))
            .item()
            .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName() + "_00")))
            .build()
            .register();
        ALL_BLOCKS.add(entry);
        return entry;
    }

    static <T extends AbstractSignalBlock> BlockEntry<T> gateOneInput(
            String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        BlockEntry<T> entry = REGISTRATE.block(name, factory)
            .properties(p -> p.mapColor(MapColor.METAL)
                .strength(1.5f, 6.0f)
                .sound(SoundType.METAL)
                .noOcclusion()
                .requiresCorrectToolForDrops())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.getVariantBuilder(c.get()).forAllStates(state -> {
                boolean a = state.getValue(AbstractSignalBlock.INPUT_A);
                String suffix = a ? "1" : "0";
                String parent = c.get().isOutputHigh(a, false) ? "block/circuit_on" : "block/circuit_off";
                String texPath = "create_circuits:block/" + c.getName() + "/" + c.getName() + "_" + suffix;
                return ConfiguredModel.builder()
                    .modelFile(p.models()
                        .withExistingParent(c.getName() + "_" + suffix, p.modLoc(parent))
                        .texture("indicator", texPath)
                        .texture("particle", texPath))
                    .rotationY(yRot(state.getValue(AbstractSignalBlock.FACING)))
                    .build();
            }))
            .item()
            .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName() + "_0")))
            .build()
            .register();
        ALL_BLOCKS.add(entry);
        return entry;
    }

    static <T extends SRLatchBlock> BlockEntry<T> latch(
            String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        BlockEntry<T> entry = REGISTRATE.block(name, factory)
            .properties(p -> p.mapColor(MapColor.METAL)
                .strength(1.5f, 6.0f)
                .sound(SoundType.METAL)
                .noOcclusion()
                .requiresCorrectToolForDrops())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.getVariantBuilder(c.get()).forAllStates(state -> {
                boolean a = state.getValue(SRLatchBlock.INPUT_A);
                boolean b = state.getValue(SRLatchBlock.INPUT_B);
                boolean active = state.getValue(SRLatchBlock.ACTIVE);
                String suffix = (a && b) ? "11" : a ? "10" : b ? "01" : active ? "active" : "00";
                String parent = active ? "block/circuit_on" : "block/circuit_off";
                String texPath = "create_circuits:block/" + c.getName() + "/" + c.getName() + "_" + suffix;
                return ConfiguredModel.builder()
                    .modelFile(p.models()
                        .withExistingParent(c.getName() + "_" + suffix, p.modLoc(parent))
                        .texture("indicator", texPath)
                        .texture("particle", texPath))
                    .rotationY(yRot(state.getValue(SRLatchBlock.FACING)))
                    .build();
            }))
            .item()
            .model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName() + "_00")))
            .build()
            .register();
        ALL_BLOCKS.add(entry);
        return entry;
    }

    public static List<BlockEntry<?>> getAllBlocks() {
        return ALL_BLOCKS;
    }

    public static void register() {}
}
