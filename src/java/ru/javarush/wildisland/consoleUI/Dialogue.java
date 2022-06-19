package ru.javarush.wildisland.consoleUI;

import ru.javarush.wildisland.island.CellsGenerator;
import ru.javarush.wildisland.island.IslandArea;
import ru.javarush.wildisland.island.WorldGenerator;
import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.time.IslandDay;

import java.util.Scanner;

public class Dialogue {
    public void start() {
        Scanner console = new Scanner(System.in);
        System.out.println(Constants.ANSI_GREEN + Constants.START_CONSOLE_MESSAGE + Constants.ANSI_RESET);
        long islandDaysCount = console.nextLong();

        IslandArea islandArea = IslandArea.getInstance();
        islandArea.islandArray = CellsGenerator.generate(Constants.ISLAND_HEIGHT, Constants.ISLAND_WIDTH);

        WorldGenerator.generate();
        System.out.println(Constants.ANSI_GREEN + WorldGenerator.totalItems + " items created.");
        System.out.println(Constants.ANSI_YELLOW + WorldGenerator.animalItems + " of them are animals." + Constants.ANSI_RESET);

        for (int i = 0; i < islandDaysCount; i++) {
            System.out.println(Constants.ANSI_BLUE + "-День " + (i + 1) + " стартовал-" + Constants.ANSI_RESET);
            IslandDay islandDay = new IslandDay();
            Thread dayThread = new Thread(islandDay);
            dayThread.start();
            try {
                dayThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Constants.ANSI_PURPLE + "-День " + (i + 1) + " окончен-" + Constants.ANSI_RESET);
        }
        System.out.println(Constants.ANSI_GREEN + "***Simulation is finished***" + Constants.ANSI_RESET);
        System.exit(0);
    }
}
