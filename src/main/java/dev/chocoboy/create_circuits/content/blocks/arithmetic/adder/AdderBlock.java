package dev.chocoboy.create_circuits.content.blocks.arithmetic.adder;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AdderBlock extends AbstractSignalBlock implements IBE<AdderBE> {

    public AdderBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AdderBE(CircuitsBETypes.ADDER.get(), pos, state);
    }

    @Override
    public Class<AdderBE> getBlockEntityClass() {
        return AdderBE.class;
    }

    @Override
    public BlockEntityType<? extends AdderBE> getBlockEntityType() {
        return CircuitsBETypes.ADDER.get();
    }
}
