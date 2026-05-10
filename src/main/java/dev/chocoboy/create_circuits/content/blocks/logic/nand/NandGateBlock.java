package dev.chocoboy.create_circuits.content.blocks.logic.nand;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NandGateBlock extends AbstractSignalBlock implements IBE<NandGateBE> {

    public NandGateBlock(Properties properties) { super(properties); }

    @Override
    public int compute(int a, int b) {
        return (a > 0 && b > 0) ? 0 : 15;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NandGateBE(CircuitsBETypes.NAND_GATE.get(), pos, state);
    }

    @Override public Class<NandGateBE> getBlockEntityClass() { return NandGateBE.class; }
    @Override public BlockEntityType<? extends NandGateBE> getBlockEntityType() { return CircuitsBETypes.NAND_GATE.get(); }
}
