package dev.chocoboy.create_circuits.content.blocks.logic.xor;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class XorGateBlock extends AbstractSignalBlock implements IBE<XorGateBE> {

    public XorGateBlock(Properties properties) { super(properties); }

    @Override
    public int compute(int a, int b) {
        return ((a > 0) != (b > 0)) ? 15 : 0;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new XorGateBE(CircuitsBETypes.XOR_GATE.get(), pos, state);
    }

    @Override public Class<XorGateBE> getBlockEntityClass() { return XorGateBE.class; }
    @Override public BlockEntityType<? extends XorGateBE> getBlockEntityType() { return CircuitsBETypes.XOR_GATE.get(); }
}
