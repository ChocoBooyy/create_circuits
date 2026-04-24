package dev.chocoboy.create_circuits.content.blocks.logic.and;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AndGateBlock extends AbstractSignalBlock implements IBE<AndGateBE> {

    public AndGateBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AndGateBE(CircuitsBETypes.AND_GATE.get(), pos, state);
    }

    @Override
    public Class<AndGateBE> getBlockEntityClass() {
        return AndGateBE.class;
    }

    @Override
    public BlockEntityType<? extends AndGateBE> getBlockEntityType() {
        return CircuitsBETypes.AND_GATE.get();
    }
}
