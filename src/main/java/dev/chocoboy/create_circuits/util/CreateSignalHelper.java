package dev.chocoboy.create_circuits.util;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import dev.chocoboy.create_circuits.mixin.KineticBlockEntityAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class CreateSignalHelper {

    private CreateSignalHelper() {}

    public static int getSpeedSignalFrom(Level level, BlockPos pos, int maxRpm) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof KineticBlockEntity kinetic) {
            float rpm = Math.abs(kinetic.getSpeed());
            if (maxRpm <= 0) return 0;
            return Mth.clamp(Math.round(rpm / maxRpm * 15f), 0, 15);
        }
        return 0;
    }

    public static int getStressSignalFrom(Level level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof KineticBlockEntity kinetic && be instanceof KineticBlockEntityAccessor acc) {
            float capacity = acc.getCapacity();
            float stress = acc.getStress();
            if (capacity <= 0) return 0;
            float ratio = Mth.clamp(stress / capacity, 0f, 1f);
            return Math.round(ratio * 15f);
        }
        return 0;
    }

    public static int getSpeedSignal(Level level, BlockPos pos, int maxRpm) {
        for (net.minecraft.core.Direction dir : net.minecraft.core.Direction.values()) {
            int speed = getSpeedSignalFrom(level, pos.relative(dir), maxRpm);
            if (speed > 0) return speed;
        }
        return 0;
    }

    public static int getStressSignal(Level level, BlockPos pos) {
        for (net.minecraft.core.Direction dir : net.minecraft.core.Direction.values()) {
            int stress = getStressSignalFrom(level, pos.relative(dir));
            if (stress > 0) return stress;
        }
        return 0;
    }
}
