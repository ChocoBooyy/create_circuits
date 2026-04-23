package dev.chocoboy.create_circuits.util;

import net.minecraft.core.Direction;

public final class DirectionHelper {

    private DirectionHelper() {}

    public static Direction getLeft(Direction facing) {
        return facing.getCounterClockWise();
    }

    public static Direction getRight(Direction facing) {
        return facing.getClockWise();
    }

    public static Direction getBack(Direction facing) {
        return facing.getOpposite();
    }
}
