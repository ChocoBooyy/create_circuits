package dev.chocoboy.create_circuits.content.blocks.memory.latch;

import com.simibubi.create.foundation.block.IBE;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractFlipFlopBlock;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import dev.chocoboy.create_circuits.signal.SignalInputs;
import dev.chocoboy.create_circuits.signal.SignalReaders;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class SRLatchBlock extends AbstractFlipFlopBlock implements IBE<SRLatchBE> {

    public static final BooleanProperty INPUT_A = BooleanProperty.create("input_a");
    public static final BooleanProperty INPUT_B = BooleanProperty.create("input_b");
    public static final BooleanProperty ACTIVE  = BooleanProperty.create("active");

    public SRLatchBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(INPUT_A, false)
                .setValue(INPUT_B, false)
                .setValue(ACTIVE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, INPUT_A, INPUT_B, ACTIVE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(INPUT_A, false)
                .setValue(INPUT_B, false)
                .setValue(ACTIVE, false);
    }

    private BlockState computeState(BlockState state, Level level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        SignalInputs inputs = SignalReaders.readInputs(level, pos, facing, true);
        int set = inputs.a();
        int reset = inputs.b();
        int currentQ = level.getBlockEntity(pos) instanceof SRLatchBE latch ? latch.getOutput() : 0;
        int newQ;
        if (set > 0 && reset > 0) newQ = 0;
        else if (set > 0)         newQ = 15;
        else if (reset > 0)       newQ = 0;
        else                      newQ = currentQ;
        return state
                .setValue(INPUT_A, set > 0)
                .setValue(INPUT_B, reset > 0)
                .setValue(ACTIVE, newQ > 0);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean moving) {
        if (!level.isClientSide) {
            BlockState newState = computeState(state, level, pos);
            if (!newState.equals(state)) level.setBlock(pos, newState, 2);
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof SRLatchBE latch) latch.onNeighborChanged();
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !state.equals(oldState)) {
            BlockState newState = computeState(state, level, pos);
            if (!newState.equals(state)) level.setBlock(pos, newState, 2);
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof SRLatchBE latch) latch.onNeighborChanged();
        }
        super.onPlace(state, level, pos, oldState, isMoving);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SRLatchBE(CircuitsBETypes.SR_LATCH.get(), pos, state);
    }

    @Override
    public Class<SRLatchBE> getBlockEntityClass() { return SRLatchBE.class; }

    @Override
    public BlockEntityType<? extends SRLatchBE> getBlockEntityType() {
        return CircuitsBETypes.SR_LATCH.get();
    }
}
