package dev.chocoboy.create_circuits.content.blocks.arithmetic.multiplier;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MultiplierBlock extends AbstractSignalBlock implements IBE<MultiplierBE> {

    public MultiplierBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int compute(int a, int b) {
        return Math.min(15, a * b);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MultiplierBE(CircuitsBETypes.MULTIPLIER.get(), pos, state);
    }

    @Override
    public Class<MultiplierBE> getBlockEntityClass() {
        return MultiplierBE.class;
    }

    @Override
    public BlockEntityType<? extends MultiplierBE> getBlockEntityType() {
        return CircuitsBETypes.MULTIPLIER.get();
    }
}
