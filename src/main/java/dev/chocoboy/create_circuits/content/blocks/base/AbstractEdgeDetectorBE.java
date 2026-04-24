package dev.chocoboy.create_circuits.content.blocks.base;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public abstract class AbstractEdgeDetectorBE extends SmartBlockEntity {

    protected boolean prevInput;
    protected int output;

    protected AbstractEdgeDetectorBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {}

    public int getOutput() {
        return output;
    }

    public void resetOutput() {
        if (output != 0) {
            output = 0;
            setChanged();
        }
    }

    public abstract boolean checkEdge(int currentInput);

    protected void triggerPulse() {
        output = 15;
        setChanged();
    }

    @Override
    protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        compound.putBoolean("PrevInput", prevInput);
        compound.putInt("Output", output);
        super.write(compound, registries, clientPacket);
    }

    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        prevInput = compound.getBoolean("PrevInput");
        output = compound.getInt("Output");
        super.read(compound, registries, clientPacket);
    }
}
