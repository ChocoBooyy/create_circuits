package dev.chocoboy.create_circuits.content.blocks.logic.nand;

import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NandGateBE extends AbstractSignalBE {

    public NandGateBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
