package dev.chocoboy.create_circuits.content.blocks.arithmetic;

import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBE;
import dev.chocoboy.create_circuits.signal.SignalOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractArithmeticBE extends AbstractSignalBE {

    private final SignalOperation operation;

    protected AbstractArithmeticBE(BlockEntityType<?> type, BlockPos pos, BlockState state, SignalOperation operation) {
        super(type, pos, state);
        this.operation = operation;
    }

    @Override
    public int compute(int a, int b) {
        return operation.apply(a, b);
    }
}

