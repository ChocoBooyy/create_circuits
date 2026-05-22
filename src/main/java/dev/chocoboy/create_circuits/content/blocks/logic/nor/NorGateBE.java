package dev.chocoboy.create_circuits.content.blocks.logic.nor;

import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NorGateBE extends AbstractSignalBE {

    public NorGateBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
