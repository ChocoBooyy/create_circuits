package dev.chocoboy.create_circuits.infrastructure.datagen;

import dev.chocoboy.create_circuits.CreateCircuits;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CircuitsBlockStateProvider extends BlockStateProvider {

    public CircuitsBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, CreateCircuits.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
}
