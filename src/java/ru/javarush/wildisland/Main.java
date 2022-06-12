package ru.javarush.wildisland;

import ru.javarush.wildisland.time.IslandDay;

import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        IslandArea islandArea = IslandArea.getInstance();
        islandArea.islandArray = CellsGenerator.generate(20, 100);
        System.out.println("----------------");

        WorldGenerator.generate();
        System.out.println(WorldGenerator.totalItems + " сущностей создано");
        System.out.println("Из них " + WorldGenerator.animalItems + " животных.");

        IslandDay islandDay = new IslandDay();
        Thread dayThread = new Thread(new FutureTask<>(islandDay));
        dayThread.start();


    }
}
