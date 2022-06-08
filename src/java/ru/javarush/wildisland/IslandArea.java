package ru.javarush.wildisland;

import java.util.HashMap;
import java.util.Set;

public class IslandArea {
    private static IslandArea islandArea;
    public IslandAreaCell[][] islandArray;

    private IslandArea() {
    }
    public static IslandArea getInstance(){
        if (islandArea == null){
            islandArea = new IslandArea();
        }
        return islandArea;
    }
}
