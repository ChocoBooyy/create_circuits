package dev.chocoboy.create_circuits.content.blocks.arithmetic.max;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MaxBlock extends AbstractSignalBlock implements IBE<MaxBE> {

    public MaxBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MaxBE(CircuitsBETypes.MAX.get(), pos, state);
    }

    @Override
    public Class<MaxBE> getBlockEntityClass() {
        return MaxBE.class;
    }

    @Override
    public BlockEntityType<? extends MaxBE> getBlockEntityType() {
        return CircuitsBETypes.MAX.get();
    }
}
