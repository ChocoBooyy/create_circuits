package dev.chocoboy.create_circuits.infrastructure.datagen;

import dev.chocoboy.create_circuits.CreateCircuits;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CircuitsItemModelProvider extends ItemModelProvider {

    public CircuitsItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, CreateCircuits.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
    }
}
