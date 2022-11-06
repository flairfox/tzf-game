package ru.blodge.tzfgame.engine.map.impl;

import ru.blodge.tzfgame.engine.map.MapGenerator;
import ru.blodge.tzfgame.engine.model.Room;
import ru.blodge.tzfgame.engine.model.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldMapDefaultGenerator implements MapGenerator {

    Random random = new Random();

    @Override
    public WorldMap generate(int width, int height, int roomsCount) {
        int[][] intMap = initIntMap(width, height);

        Room firstRoom = new Room(width / 2, height / 2);
        List<Room> roomsQueue = new ArrayList<>();
        roomsQueue.add(firstRoom);

        int idx = 0;
        while (roomsQueue.size() <= roomsCount) {
            Room currentRoom = roomsQueue.get(idx);

            int southX = currentRoom.getX();
            int southY = currentRoom.getY() + 1;
            if (intMap[southX][southY] == 0) {
                if (random.nextBoolean()) {
                    Room southRoom = new Room(southX, southY);
                    intMap[southX][southY] = 1;
                    roomsQueue.add(southRoom);
                }
            }

            int northX = currentRoom.getX();
            int northY = currentRoom.getY() - 1;
            if (intMap[northX][northY] == 0) {
                if (random.nextBoolean()) {
                    Room northRoom = new Room(northX, northY);
                    intMap[northX][northY] = 1;
                    roomsQueue.add(northRoom);
                }
            }

            int westX = currentRoom.getX() - 1;
            int westY = currentRoom.getY();
            if (intMap[westX][westY] == 0) {
                if (random.nextBoolean()) {
                    Room westRoom = new Room(westX, westY);
                    intMap[westX][westY] = 1;
                    roomsQueue.add(westRoom);
                }
            }

            int eastX = currentRoom.getX() + 1;
            int eastY = currentRoom.getY();
            if (intMap[eastX][eastY] == 0) {
                if (random.nextBoolean()) {
                    Room eastRoom = new Room(eastX, eastY);
                    intMap[eastX][eastY] = 1;
                    roomsQueue.add(eastRoom);
                }
            }

            idx++;
        }

        WorldMap newMap = new WorldMap(width, height);
        roomsQueue.forEach(newMap::addRoom);

        return newMap;
    }

    private int[][] initIntMap(int width, int height) {
        int[][] intMap = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                intMap[i][j] = 0;
            }
        }

        return intMap;
    }

}
