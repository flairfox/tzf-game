package ru.blodge.tzfgame.constants;

import java.util.Set;

public class Direction {

    public final static Set<Direction> directions = Set.of(
            new Direction(0, -1),
            new Direction(1, 0),
            new Direction(0, 1),
            new Direction(-1, 0)
    );

    private final int xShift;
    private final int yShift;

    private Direction(int xShift, int yShift) {
        this.xShift = xShift;
        this.yShift = yShift;
    }

    public int xShift() {
        return xShift;
    }

    public int yShift() {
        return yShift;
    }
}
