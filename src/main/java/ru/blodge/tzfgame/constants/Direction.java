package ru.blodge.tzfgame.constants;

public enum Direction {

    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int xShift;
    private final int yShift;

    Direction(int xShift, int yShift) {
        this.xShift = xShift;
        this.yShift = yShift;
    }

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }

    public int xShift() {
        return xShift;
    }

    public int yShift() {
        return yShift;
    }
}
