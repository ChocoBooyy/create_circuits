package dev.chocoboy.create_circuits.content.blocks.memory.latch;

import dev.chocoboy.create_circuits.content.blocks.base.AbstractFlipFlopBE;
import dev.chocoboy.create_circuits.signal.SignalInputs;
import dev.chocoboy.create_circuits.signal.SignalReaders;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SRLatchBE extends AbstractFlipFlopBE {

    public SRLatchBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void onNeighborChanged() {
        if (level == null || level.isClientSide) return;
        Direction facing = getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        SignalInputs inputs = SignalReaders.readInputs(level, worldPosition, facing, true);

        int set = inputs.a();
        int reset = inputs.b();

        if (reset > 0 && set > 0) {
            // Deterministic tie-breaker: reset wins when both are high
            setOutput(0);
        } else if (set > 0) {
            setOutput(15);
        } else if (reset > 0) {
            setOutput(0);
        }
    }
}
