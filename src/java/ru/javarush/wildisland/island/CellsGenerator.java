package ru.javarush.wildisland.island;

import ru.javarush.wildisland.island.IslandAreaCell;

public class CellsGenerator {
    public static IslandAreaCell[][] generate(int height, int width) {
        IslandAreaCell[][] areaCells = new IslandAreaCell[height][width];
        for (int i = 0; i < areaCells.length; i++) {
            for (int j = 0; j < areaCells[i].length; j++) {
                areaCells[i][j] = new IslandAreaCell(i + ":" + j);
            }
        }
        return areaCells;
    }
}
