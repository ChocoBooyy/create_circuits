package dev.chocoboy.create_circuits.content.blocks.arithmetic.min;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MinBlock extends AbstractSignalBlock implements IBE<MinBE> {

    public MinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MinBE(CircuitsBETypes.MIN.get(), pos, state);
    }

    @Override
    public Class<MinBE> getBlockEntityClass() {
        return MinBE.class;
    }

    @Override
    public BlockEntityType<? extends MinBE> getBlockEntityType() {
        return CircuitsBETypes.MIN.get();
    }
}
