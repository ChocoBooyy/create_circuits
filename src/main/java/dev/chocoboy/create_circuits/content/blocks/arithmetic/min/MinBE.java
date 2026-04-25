package dev.chocoboy.create_circuits.content.blocks.arithmetic.min;

import dev.chocoboy.create_circuits.content.blocks.arithmetic.AbstractArithmeticBE;
import dev.chocoboy.create_circuits.signal.operations.MinOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MinBE extends AbstractArithmeticBE {

    public MinBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, new MinOperation());
    }
}
