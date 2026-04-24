package dev.chocoboy.create_circuits.content.blocks.base;

import dev.chocoboy.create_circuits.signal.SignalReaders;
import dev.chocoboy.create_circuits.util.DirectionHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public abstract class AbstractEdgeDetectorBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected AbstractEdgeDetectorBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        if (direction.getOpposite() == state.getValue(FACING)) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof AbstractEdgeDetectorBE ed) return ed.getOutput();
        }
        return 0;
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state, level, pos, direction);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block,
                                BlockPos fromPos, boolean moving) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof AbstractEdgeDetectorBE ed) {
                Direction back = DirectionHelper.getBack(state.getValue(FACING));
                int current = SignalReaders.readEffectiveSignal(level, pos.relative(back), back);
                boolean pulsed = ed.checkEdge(current);
                if (pulsed) {
                    level.updateNeighborsAt(pos, this);
                    level.updateNeighbourForOutputSignal(pos, this);
                    level.scheduleTick(pos, this, 2);
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AbstractEdgeDetectorBE ed) {
            ed.resetOutput();
            level.updateNeighborsAt(pos, this);
            level.updateNeighbourForOutputSignal(pos, this);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return false;
    }
}
