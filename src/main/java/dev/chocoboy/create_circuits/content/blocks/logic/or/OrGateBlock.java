package dev.chocoboy.create_circuits.content.blocks.logic.or;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OrGateBlock extends AbstractSignalBlock implements IBE<OrGateBE> {

    public OrGateBlock(Properties properties) { super(properties); }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OrGateBE(CircuitsBETypes.OR_GATE.get(), pos, state);
    }

    @Override public Class<OrGateBE> getBlockEntityClass() { return OrGateBE.class; }
    @Override public BlockEntityType<? extends OrGateBE> getBlockEntityType() { return CircuitsBETypes.OR_GATE.get(); }
}
