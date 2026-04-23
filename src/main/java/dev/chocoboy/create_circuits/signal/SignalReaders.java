package dev.chocoboy.create_circuits.signal;

import dev.chocoboy.create_circuits.util.CreateSignalHelper;
import dev.chocoboy.create_circuits.util.DirectionHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public final class SignalReaders {

    private static final int DEFAULT_MAX_RPM = 256;

    private SignalReaders() {}

    public static SignalInputs readInputs(Level level, BlockPos pos, Direction facing, boolean twoInput) {
        if (twoInput) {
            Direction left = DirectionHelper.getLeft(facing);
            Direction right = DirectionHelper.getRight(facing);
            // A is viewer-left (block at 'right' relative to facing), B is viewer-right (block at 'left').
            int a = readEffectiveSignal(level, pos.relative(right), right);
            int b = readEffectiveSignal(level, pos.relative(left), left);
            return new SignalInputs(a, b);
        }

        Direction back = DirectionHelper.getBack(facing);
        int a = readEffectiveSignal(level, pos.relative(back), back);
        return new SignalInputs(a, 0);
    }

    public static int readEffectiveSignal(Level level, BlockPos neighborPos, Direction side) {
        BlockState neighborState = level.getBlockState(neighborPos);
        int weak = level.getSignal(neighborPos, side);
        int direct = level.getDirectSignal(neighborPos, side);
        int analog = neighborState.hasAnalogOutputSignal()
            ? neighborState.getAnalogOutputSignal(level, neighborPos)
            : 0;
        int createSpeed = CreateSignalHelper.getSpeedSignalFrom(level, neighborPos, DEFAULT_MAX_RPM);
        int createStress = CreateSignalHelper.getStressSignalFrom(level, neighborPos);

        int max = Math.max(Math.max(weak, direct), Math.max(analog, Math.max(createSpeed, createStress)));
        return Mth.clamp(max, 0, 15);
    }
}

