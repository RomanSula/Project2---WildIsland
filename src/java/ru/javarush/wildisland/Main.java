package ru.javarush.wildisland;

import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.time.IslandDay;

import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        IslandArea islandArea = IslandArea.getInstance();
        islandArea.islandArray = CellsGenerator.generate(Constants.ISLAND_HEIGHT, Constants.ISLAND_WIDTH);

        WorldGenerator.generate();
        System.out.println(WorldGenerator.totalItems + " сущностей создано");
        System.out.println("Из них " + WorldGenerator.animalItems + " животных.");

        IslandDay islandDay = new IslandDay();
        Thread dayThread = new Thread(islandDay);
        dayThread.start();
        try {
            dayThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Day just has ended");
    }
}
