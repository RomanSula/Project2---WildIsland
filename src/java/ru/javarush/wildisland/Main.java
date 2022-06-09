package ru.javarush.wildisland;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IslandArea islandArea = IslandArea.getInstance();
        islandArea.islandArray = CellsGenerator.generate(5, 5);
        System.out.println("----------------");

        WorldGenerator.generate();
        System.out.println("-------");



    }
}
