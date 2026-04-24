package dev.chocoboy.create_circuits.content.blocks.logic.xor;

import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class XorGateBE extends AbstractSignalBE {

    public XorGateBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public int compute(int a, int b) {
        return ((a > 0) != (b > 0)) ? 15 : 0;
    }
}
