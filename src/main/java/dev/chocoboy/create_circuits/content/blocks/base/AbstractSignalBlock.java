package dev.chocoboy.create_circuits.content.blocks.base;

import dev.chocoboy.create_circuits.signal.SignalInputs;
import dev.chocoboy.create_circuits.signal.SignalReaders;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public abstract class AbstractSignalBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty INPUT_A = BooleanProperty.create("input_a");
    public static final BooleanProperty INPUT_B = BooleanProperty.create("input_b");

    protected AbstractSignalBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(INPUT_A, false)
            .setValue(INPUT_B, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, INPUT_A, INPUT_B);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
            .setValue(FACING, context.getHorizontalDirection().getOpposite())
            .setValue(INPUT_A, false)
            .setValue(INPUT_B, false);
    }

    protected boolean isTwoInput() {
        return true;
    }

    public abstract int compute(int a, int b);

    public boolean isOutputHigh(boolean a, boolean b) {
        return compute(a ? 15 : 0, b ? 15 : 0) > 0;
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        if (direction == state.getValue(FACING)) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof AbstractSignalBE gate) return gate.getOutput();
        }
        return 0;
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state, level, pos, direction);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AbstractSignalBE gate) return gate.getOutput();
        return 0;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block,
                                BlockPos fromPos, boolean moving) {
        if (!level.isClientSide) {
            Direction facing = state.getValue(FACING);
            SignalInputs inputs = SignalReaders.readInputs(level, pos, facing, isTwoInput());
            BlockState newState = state
                .setValue(INPUT_A, inputs.a() > 0)
                .setValue(INPUT_B, inputs.b() > 0);
            if (!newState.equals(state)) {
                level.setBlock(pos, newState, 2);
            }
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof AbstractSignalBE gate) gate.updateOutput();
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !state.equals(oldState)) {
            Direction facing = state.getValue(FACING);
            SignalInputs inputs = SignalReaders.readInputs(level, pos, facing, isTwoInput());
            BlockState newState = state
                .setValue(INPUT_A, inputs.a() > 0)
                .setValue(INPUT_B, inputs.b() > 0);
            if (!newState.equals(state)) {
                level.setBlock(pos, newState, 2);
            }
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof AbstractSignalBE gate) gate.updateOutput();
            level.updateNeighborsAt(pos, state.getBlock());
            level.updateNeighbourForOutputSignal(pos, state.getBlock());
        }
        super.onPlace(state, level, pos, oldState, isMoving);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && state.getBlock() != newState.getBlock()) {
            level.updateNeighborsAt(pos, state.getBlock());
            level.updateNeighbourForOutputSignal(pos, state.getBlock());
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}
