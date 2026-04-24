package dev.chocoboy.create_circuits.content.blocks.base;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public abstract class AbstractFlipFlopBE extends SmartBlockEntity {

    protected int output;

    protected AbstractFlipFlopBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {}

    public int getOutput() {
        return output;
    }

    protected void setOutput(int value) {
        int next = Math.min(15, Math.max(0, value));
        if (next != output) {
            output = next;
            setChanged();
            if (level != null && !level.isClientSide) {
                BlockState state = getBlockState();
                level.updateNeighborsAt(worldPosition, state.getBlock());
                level.updateNeighbourForOutputSignal(worldPosition, state.getBlock());
                level.sendBlockUpdated(worldPosition, state, state, 3);
            }
        }
    }

    public abstract void onNeighborChanged();

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
