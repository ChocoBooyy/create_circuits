package dev.chocoboy.create_circuits.infrastructure.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public final class CircuitsDatagen {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new CircuitsRecipeProvider(output, lookupProvider));
        gen.addProvider(event.includeClient(), new CircuitsBlockStateProvider(output, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new CircuitsItemModelProvider(output, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new CircuitsLangProvider(output));
    }
}
