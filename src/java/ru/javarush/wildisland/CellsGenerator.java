package ru.javarush.wildisland;

public class CellsGenerator {
    public static IslandAreaCell[][] generate(int width, int height){
        IslandAreaCell[][] areaCells = new IslandAreaCell[width][height];
        for (int i = 0; i < areaCells.length; i++) {
            for (int j = 0; j < areaCells[i].length; j++) {
                areaCells[i][j] = new IslandAreaCell( i + ":" + j);
            }
        }
        return areaCells;
    }
}
