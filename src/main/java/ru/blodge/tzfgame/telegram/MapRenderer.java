package ru.blodge.tzfgame.telegram;

import ru.blodge.tzfgame.engine.model.WorldMap;

public class MapRenderer {

    public String render(WorldMap map) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (map.getRoom(i, j) == null)
                    builder.append("▒");
                else
                    builder.append("█");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}