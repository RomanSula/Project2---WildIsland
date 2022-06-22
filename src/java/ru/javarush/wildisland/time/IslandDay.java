package ru.javarush.wildisland.time;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.island.CellsGenerator;
import ru.javarush.wildisland.island.IslandArea;
import ru.javarush.wildisland.island.IslandAreaCell;
import ru.javarush.wildisland.plants.Herb;
import ru.javarush.wildisland.statistics.IslandDayResult;

import java.util.*;
import java.util.concurrent.*;

public class IslandDay implements Runnable {
    public IslandAreaCell[][] newIslandArray = CellsGenerator.generate(Constants.ISLAND_HEIGHT, Constants.ISLAND_WIDTH);


    @Override
    public void run() {
        Map<String, Integer> itemsAmountMap = calculateItemBeforeActions();
        printIslandItemsAmountBeforeActions(itemsAmountMap);

        ExecutorService dayExecutor = Executors.newFixedThreadPool(coresCalculate());
        List<Callable<IslandDayResult>> dayTasks = createDayTasks();

        try {
            List<Future<IslandDayResult>> futures = dayExecutor.invokeAll(dayTasks);
            printDayResult(futures);
            moveAnimals(futures);
            CreateNewIslandArea();

        } catch (InterruptedException | ExecutionException e) {
            System.err.println(Constants.ANSI_RED + "Some problem with simulation: " + e.getMessage() + Constants.ANSI_RESET);
        }
    }

    public void CreateNewIslandArea() {
        for (int i = 0; i < newIslandArray.length; i++) {
            for (int j = 0; j < newIslandArray[i].length; j++) {
                createNewPlants(newIslandArray[i][j].cellIslandItems);
            }
        }
        IslandArea islandArea = IslandArea.getInstance();
        islandArea.islandArray = newIslandArray;
    }

    public void createNewPlants(Set<IslandItem> islandItems) {
        for (int i = 0; i < Constants.PLANT_AMOUNT; i++) {
            islandItems.add(new Herb());
        }
    }

    public void printIslandItemsAmountBeforeActions(Map<String, Integer> itemsMap) {
        boolean isMaxIslandItemValueReached = false;
        String outOfBoundName = "Animal";
        System.out.println("Day is starting for: ");
        for (Map.Entry<String, Integer> entry : itemsMap.entrySet()) {
            if (entry.getValue() >= Constants.MAX_ISLAND_ITEM_VALUE) {
                isMaxIslandItemValueReached = true;
                outOfBoundName = entry.getKey();
            }
            System.out.print(Constants.ANSI_CYAN
                    + entry.getValue() + " " + entry.getKey() + "|"
                    + Constants.ANSI_RESET);
        }
        System.out.println("");
        if (isMaxIslandItemValueReached) {
            System.out.println(Constants.ANSI_RED + "Animal " + outOfBoundName + " reached limit value " + Constants.MAX_ISLAND_ITEM_VALUE);
            System.out.println("***Simulation is finished***" + Constants.ANSI_RESET);
            System.exit(0);
        }
    }

    public void printDayResult(List<Future<IslandDayResult>> futures) throws ExecutionException, InterruptedException {
        long eatenAnimals = 0;
        long deadByHungerAnimals = 0;
        long reproducedAnimals = 0;

        for (Future<IslandDayResult> future : futures) {
            if (future.isDone()) {
                IslandDayResult result = future.get();
                eatenAnimals += result.statisticAfterDay.eatenAnimals;
                deadByHungerAnimals += result.statisticAfterDay.deadByHungerAnimals;
                reproducedAnimals += result.statisticAfterDay.reproducedAnimals;
            }
        }
        System.out.println(Constants.ANSI_CYAN
                + "After day statistic: " + deadByHungerAnimals + " animals have died by hunger; "
                + eatenAnimals + " animals have been eaten; "
                + reproducedAnimals + " animals were born;"
                + Constants.ANSI_RESET);
    }

    public void moveAnimals(List<Future<IslandDayResult>> futures) throws ExecutionException, InterruptedException {
        for (Future<IslandDayResult> future : futures) {
            if (future.isDone()) {
                IslandDayResult result = future.get();
                IslandAreaCell areaCell = result.statisticAfterDay.areaCell;
                for (IslandItem islandItem : result.afterActionsSet) {
                    if (islandItem instanceof Animal) {
                        int[] newCoordinate = new int[2];
                        newCoordinate = ((Animal) islandItem).moveToNewArea(areaCell.cellId);
                        newIslandArray[newCoordinate[0]][newCoordinate[1]].cellIslandItems.add(islandItem);
                    }
                }
            }
        }

    }

    public List<Callable<IslandDayResult>> createDayTasks() {
        List<Callable<IslandDayResult>> dayTasks = new ArrayList<>();
        IslandArea islandArea = IslandArea.getInstance();
        for (int i = 0; i < islandArea.islandArray.length; i++) {
            for (int j = 0; j < islandArea.islandArray[i].length; j++) {
                dayTasks.add(new CellDay(islandArea.islandArray[i][j]));
            }
        }
        return dayTasks;
    }

    public int coresCalculate() {
        return Runtime.getRuntime().availableProcessors();
    }

    public Map<String, Integer> calculateItemBeforeActions() {
        Map<String, Integer> itemsAmountMap = new HashMap<>();
        IslandArea islandArea = IslandArea.getInstance();

        for (int i = 0; i < islandArea.islandArray.length; i++) {
            for (int j = 0; j < islandArea.islandArray[i].length; j++) {
                for (IslandItem islandItem : islandArea.islandArray[i][j].cellIslandItems) {
                    if (!itemsAmountMap.containsKey(islandItem.getClass().getSimpleName())) {
                        itemsAmountMap.put(islandItem.getClass().getSimpleName(), 1);
                    } else {
                        itemsAmountMap.put(islandItem.getClass().getSimpleName(), itemsAmountMap.get(islandItem.getClass().getSimpleName()) + 1);
                    }
                }
            }
        }
        return itemsAmountMap;
    }
}
