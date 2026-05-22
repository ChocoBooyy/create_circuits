package dev.chocoboy.create_circuits.content.blocks.arithmetic.adder;

import dev.chocoboy.create_circuits.content.blocks.arithmetic.AbstractArithmeticBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AdderBE extends AbstractArithmeticBE {

    public AdderBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
