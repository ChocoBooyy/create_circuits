package dev.chocoboy.create_circuits.content.blocks.arithmetic.subtractor;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SubtractorBlock extends AbstractSignalBlock implements IBE<SubtractorBE> {

    public SubtractorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SubtractorBE(CircuitsBETypes.SUBTRACTOR.get(), pos, state);
    }

    @Override
    public Class<SubtractorBE> getBlockEntityClass() {
        return SubtractorBE.class;
    }

    @Override
    public BlockEntityType<? extends SubtractorBE> getBlockEntityType() {
        return CircuitsBETypes.SUBTRACTOR.get();
    }
}
