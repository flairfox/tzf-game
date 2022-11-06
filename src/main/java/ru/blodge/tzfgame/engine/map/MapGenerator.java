package ru.blodge.tzfgame.engine.map;

import ru.blodge.tzfgame.engine.model.WorldMap;

public interface MapGenerator {

    WorldMap generate(int roomsCount);

}
