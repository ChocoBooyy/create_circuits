package dev.chocoboy.create_circuits.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import dev.chocoboy.create_circuits.CreateCircuits;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.adder.AdderBE;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.max.MaxBE;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.min.MinBE;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.multiplier.MultiplierBE;
import dev.chocoboy.create_circuits.content.blocks.arithmetic.subtractor.SubtractorBE;
import dev.chocoboy.create_circuits.content.blocks.logic.and.AndGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.nand.NandGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.nor.NorGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.not.NotGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.or.OrGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.xnor.XnorGateBE;
import dev.chocoboy.create_circuits.content.blocks.logic.xor.XorGateBE;
import dev.chocoboy.create_circuits.content.blocks.memory.latch.SRLatchBE;

public final class CircuitsBETypes {

    static final CreateRegistrate REGISTRATE = CreateCircuits.REGISTRATE;

    public static final BlockEntityEntry<AndGateBE> AND_GATE = REGISTRATE
            .blockEntity("and_gate", AndGateBE::new)
            .validBlocks(CircuitsBlocks.AND_GATE)
            .register();

    public static final BlockEntityEntry<OrGateBE> OR_GATE = REGISTRATE
            .blockEntity("or_gate", OrGateBE::new)
            .validBlocks(CircuitsBlocks.OR_GATE)
            .register();

    public static final BlockEntityEntry<NotGateBE> NOT_GATE = REGISTRATE
            .blockEntity("not_gate", NotGateBE::new)
            .validBlocks(CircuitsBlocks.NOT_GATE)
            .register();

    public static final BlockEntityEntry<NandGateBE> NAND_GATE = REGISTRATE
            .blockEntity("nand_gate", NandGateBE::new)
            .validBlocks(CircuitsBlocks.NAND_GATE)
            .register();

    public static final BlockEntityEntry<NorGateBE> NOR_GATE = REGISTRATE
            .blockEntity("nor_gate", NorGateBE::new)
            .validBlocks(CircuitsBlocks.NOR_GATE)
            .register();

    public static final BlockEntityEntry<XorGateBE> XOR_GATE = REGISTRATE
            .blockEntity("xor_gate", XorGateBE::new)
            .validBlocks(CircuitsBlocks.XOR_GATE)
            .register();

    public static final BlockEntityEntry<XnorGateBE> XNOR_GATE = REGISTRATE
            .blockEntity("xnor_gate", XnorGateBE::new)
            .validBlocks(CircuitsBlocks.XNOR_GATE)
            .register();

    public static final BlockEntityEntry<AdderBE> ADDER = REGISTRATE
            .blockEntity("adder", AdderBE::new)
            .validBlocks(CircuitsBlocks.ADDER)
            .register();

    public static final BlockEntityEntry<SubtractorBE> SUBTRACTOR = REGISTRATE
            .blockEntity("subtractor", SubtractorBE::new)
            .validBlocks(CircuitsBlocks.SUBTRACTOR)
            .register();

    public static final BlockEntityEntry<MultiplierBE> MULTIPLIER = REGISTRATE
            .blockEntity("multiplier", MultiplierBE::new)
            .validBlocks(CircuitsBlocks.MULTIPLIER)
            .register();

    public static final BlockEntityEntry<MaxBE> MAX = REGISTRATE
            .blockEntity("max", MaxBE::new)
            .validBlocks(CircuitsBlocks.MAX)
            .register();

    public static final BlockEntityEntry<MinBE> MIN = REGISTRATE
            .blockEntity("min", MinBE::new)
            .validBlocks(CircuitsBlocks.MIN)
            .register();

    public static final BlockEntityEntry<SRLatchBE> SR_LATCH = REGISTRATE
            .blockEntity("sr_latch", SRLatchBE::new)
            .validBlocks(CircuitsBlocks.SR_LATCH)
            .register();

    public static void register() {}
}
