package dev.chocoboy.create_circuits.content.blocks.logic.nor;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NorGateBlock extends AbstractSignalBlock implements IBE<NorGateBE> {

    public NorGateBlock(Properties properties) { super(properties); }

    @Override
    public int compute(int a, int b) {
        return (a > 0 || b > 0) ? 0 : 15;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NorGateBE(CircuitsBETypes.NOR_GATE.get(), pos, state);
    }

    @Override public Class<NorGateBE> getBlockEntityClass() { return NorGateBE.class; }
    @Override public BlockEntityType<? extends NorGateBE> getBlockEntityType() { return CircuitsBETypes.NOR_GATE.get(); }
}
