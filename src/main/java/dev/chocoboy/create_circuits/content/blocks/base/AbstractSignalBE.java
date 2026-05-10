package dev.chocoboy.create_circuits.content.blocks.base;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import dev.chocoboy.create_circuits.signal.SignalInputs;
import dev.chocoboy.create_circuits.signal.SignalReaders;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public abstract class AbstractSignalBE extends SmartBlockEntity {

    private int output;

    protected AbstractSignalBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {}

    public int compute(int a, int b) {
        return ((AbstractSignalBlock) getBlockState().getBlock()).compute(a, b);
    }

    protected boolean isTwoInput() {
        return true;
    }

    public void updateOutput() {
        if (level == null || level.isClientSide) return;
        Direction facing = getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        BlockPos pos = worldPosition;

        SignalInputs inputs = SignalReaders.readInputs(level, pos, facing, isTwoInput());
        int next = Math.min(15, Math.max(0, compute(inputs.a(), inputs.b())));
        if (next != output) {
            output = next;
            setChanged();
            BlockState state = getBlockState();
            // Notify neighbors and comparators, and ensure clients are updated
            level.updateNeighborsAt(pos, state.getBlock());
            level.updateNeighbourForOutputSignal(pos, state.getBlock());
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    public int getOutput() {
        return output;
    }

    @Override
    protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        compound.putInt("Output", output);
        super.write(compound, registries, clientPacket);
    }

    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        output = compound.getInt("Output");
        super.read(compound, registries, clientPacket);
    }
}
