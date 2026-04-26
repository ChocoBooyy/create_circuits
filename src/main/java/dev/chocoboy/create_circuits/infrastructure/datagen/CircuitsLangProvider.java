package dev.chocoboy.create_circuits.infrastructure.datagen;

import dev.chocoboy.create_circuits.CreateCircuits;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class CircuitsLangProvider extends LanguageProvider {

    public CircuitsLangProvider(PackOutput output) {
        super(output, CreateCircuits.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.create_circuits", "Create: Circuits");
        add("block.create_circuits.and_gate",  "AND Gate");
        add("block.create_circuits.or_gate",   "OR Gate");
        add("block.create_circuits.not_gate",  "NOT Gate");
        add("block.create_circuits.nand_gate", "NAND Gate");
        add("block.create_circuits.nor_gate",  "NOR Gate");
        add("block.create_circuits.xor_gate",  "XOR Gate");
        add("block.create_circuits.xnor_gate", "XNOR Gate");
        add("block.create_circuits.adder", "Adder");
        add("block.create_circuits.subtractor", "Subtractor");
        add("block.create_circuits.multiplier", "Multiplier");
        add("block.create_circuits.max", "Max");
        add("block.create_circuits.min", "Min");
        add("block.create_circuits.rs_latch", "RS Latch");
    }
}
