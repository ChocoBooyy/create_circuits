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
    }
}
