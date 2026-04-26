package dev.chocoboy.create_circuits.infrastructure.datagen;

import com.simibubi.create.AllItems;
import dev.chocoboy.create_circuits.registry.CircuitsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class CircuitsRecipeProvider extends RecipeProvider {

    public CircuitsRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // AND Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.AND_GATE.get())
            .pattern("RIR")
            .pattern("IEI")
            .define('R', Items.REDSTONE)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_electron_tube", has(AllItems.ELECTRON_TUBE.get()))
            .save(output);

        // OR Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.OR_GATE.get())
            .pattern("RER")
            .pattern("III")
            .define('R', Items.REDSTONE)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_electron_tube", has(AllItems.ELECTRON_TUBE.get()))
            .save(output);

        // NOT Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.NOT_GATE.get())
            .pattern("TIT")
            .define('T', Items.REDSTONE_TORCH)
            .define('I', Items.IRON_INGOT)
            .unlockedBy("has_redstone_torch", has(Items.REDSTONE_TORCH))
            .save(output);

        // NAND Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.NAND_GATE.get())
            .pattern(" T ")
            .pattern("AIA")
            .define('T', Items.REDSTONE_TORCH)
            .define('A', CircuitsBlocks.AND_GATE.get())
            .define('I', Items.IRON_INGOT)
            .unlockedBy("has_and_gate", has(CircuitsBlocks.AND_GATE.get()))
            .save(output);

        // NOR Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.NOR_GATE.get())
            .pattern(" T ")
            .pattern("OIO")
            .define('T', Items.REDSTONE_TORCH)
            .define('O', CircuitsBlocks.OR_GATE.get())
            .define('I', Items.IRON_INGOT)
            .unlockedBy("has_or_gate", has(CircuitsBlocks.OR_GATE.get()))
            .save(output);

        // XOR Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.XOR_GATE.get())
            .pattern("CEC")
            .pattern("I I")
            .define('C', Items.COMPARATOR)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .define('I', Items.IRON_INGOT)
            .unlockedBy("has_comparator", has(Items.COMPARATOR))
            .save(output);

        // XNOR Gate
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.XNOR_GATE.get())
            .pattern(" T ")
            .pattern("XIX")
            .define('T', Items.REDSTONE_TORCH)
            .define('X', CircuitsBlocks.XOR_GATE.get())
            .define('I', Items.IRON_INGOT)
            .unlockedBy("has_xor_gate", has(CircuitsBlocks.XOR_GATE.get()))
            .save(output);

        // Adder
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.ADDER.get())
            .pattern("RCR")
            .pattern("IEI")
            .define('R', Items.REDSTONE)
            .define('C', Items.COMPARATOR)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_comparator", has(Items.COMPARATOR))
            .save(output);

        // Subtractor
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.SUBTRACTOR.get())
            .pattern("R R")
            .pattern("IEI")
            .pattern(" C ")
            .define('R', Items.REDSTONE)
            .define('C', Items.COMPARATOR)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_comparator", has(Items.COMPARATOR))
            .save(output);

        // Multiplier
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.MULTIPLIER.get())
            .pattern("RGR")
            .pattern("IEI")
            .define('R', Items.REDSTONE)
            .define('G', Items.GOLD_INGOT)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_gold", has(Items.GOLD_INGOT))
            .save(output);

        // Max
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.MAX.get())
            .pattern("R R")
            .pattern("IEI")
            .pattern(" R ")
            .define('R', Items.REDSTONE)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_electron_tube", has(AllItems.ELECTRON_TUBE.get()))
            .save(output);

        // Min
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.MIN.get())
            .pattern(" R ")
            .pattern("IEI")
            .pattern("R R")
            .define('R', Items.REDSTONE)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_electron_tube", has(AllItems.ELECTRON_TUBE.get()))
            .save(output);

        // RS Latch
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CircuitsBlocks.RS_LATCH.get())
            .pattern("RTR")
            .pattern("IEI")
            .define('R', Items.REDSTONE)
            .define('T', Items.REDSTONE_TORCH)
            .define('I', Items.IRON_INGOT)
            .define('E', AllItems.ELECTRON_TUBE.get())
            .unlockedBy("has_redstone_torch", has(Items.REDSTONE_TORCH))
            .save(output);
    }
}
