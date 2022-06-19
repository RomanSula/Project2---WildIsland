package ru.javarush.wildisland.island;

public class IslandArea {
    private static IslandArea islandArea;
    public IslandAreaCell[][] islandArray;

    private IslandArea() {
    }

    public static IslandArea getInstance() {
        if (islandArea == null) {
            islandArea = new IslandArea();
        }
        return islandArea;
    }
}
