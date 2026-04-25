package dev.chocoboy.create_circuits.content.blocks.arithmetic.multiplier;

import dev.chocoboy.create_circuits.content.blocks.arithmetic.AbstractArithmeticBE;
import dev.chocoboy.create_circuits.signal.operations.MultiplierOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MultiplierBE extends AbstractArithmeticBE {

    public MultiplierBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state, new MultiplierOperation());
    }
}
