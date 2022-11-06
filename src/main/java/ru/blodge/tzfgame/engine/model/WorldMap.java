package ru.blodge.tzfgame.engine.model;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    private final Map<Integer, Map<Integer, Room>> worldMap;
    private final int width;
    private final int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;

        worldMap = new HashMap<>();
        for (int i = 0; i < width; i++) {
            worldMap.put(i, new HashMap<>());
        }
    }

    public void addRoom(Room newRoom) {
        worldMap.get(newRoom.getX()).put(newRoom.getY(), newRoom);
    }

    public Room getRoom(int x, int y) {
        return worldMap
                .get(x)
                .get(y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
