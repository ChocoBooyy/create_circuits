package dev.chocoboy.create_circuits.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.chocoboy.create_circuits.CreateCircuits;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public final class CircuitsBlocks {

    private static final CreateRegistrate REGISTRATE = CreateCircuits.REGISTRATE;
    private static final List<BlockEntry<?>> ALL_BLOCKS = new ArrayList<>();

    public static BlockEntry<Block> AND_GATE = null;

    public static List<BlockEntry<?>> getAllBlocks() {
        return ALL_BLOCKS;
    }

    public static void register() {}
}
