package dev.chocoboy.create_circuits.content.blocks.logic.not;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NotGateBlock extends AbstractSignalBlock implements IBE<NotGateBE> {

    public NotGateBlock(Properties properties) { super(properties); }

    @Override
    protected boolean isTwoInput() {
        return false;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NotGateBE(CircuitsBETypes.NOT_GATE.get(), pos, state);
    }

    @Override public Class<NotGateBE> getBlockEntityClass() { return NotGateBE.class; }
    @Override public BlockEntityType<? extends NotGateBE> getBlockEntityType() { return CircuitsBETypes.NOT_GATE.get(); }
}
