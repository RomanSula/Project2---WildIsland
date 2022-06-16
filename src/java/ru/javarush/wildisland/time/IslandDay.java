package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandArea;
import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.IslandDayResult;
import ru.javarush.wildisland.StatisticAfterDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class IslandDay implements Runnable {

    @Override
    public void run() {
        System.out.println("Day thread is starting->");
        ExecutorService dayExecutor = Executors.newFixedThreadPool(coresCalculate());

        List<Callable<IslandDayResult>> dayTasks = createDayTasks();

        System.out.println(dayTasks.size() + " tasks are ready");
        System.out.println();

        try {
            List<Future<IslandDayResult>> cellsDailyStaticList = dayExecutor.invokeAll(dayTasks);
            printDayResul(cellsDailyStaticList);

        } catch (InterruptedException e) {
            System.err.println("Some problem with simulation: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Some problem with simulation: " + e.getMessage());
        }
        System.out.println("*Day was ended*");
    }

    // TODO: 16.06.2022 сделать moveAnimals здесь. Получить новые координаты для каждого Animal и исходя из результата заполнить массив острова ячейками с множествамию

    public static void printDayResul(List<Future<IslandDayResult>> cellsDailyStaticList) throws ExecutionException, InterruptedException {
        long eatenAnimals = 0;
        long deadByHungerAnimals = 0;
        long reproducedAnimals = 0;

        for (Future<IslandDayResult> future : cellsDailyStaticList) {
            if (future.isDone()) {
                IslandDayResult result = future.get();
                eatenAnimals += result.statisticAfterDay.eatenAnimals;
                deadByHungerAnimals += result.statisticAfterDay.deadByHungerAnimals;
                reproducedAnimals += result.statisticAfterDay.reproducedAnimals;
            }
        }
        System.out.println("After day statistic: " + deadByHungerAnimals + " animals have died; "
                + eatenAnimals + " animals have been eaten;"
                + reproducedAnimals + " animals were born;");
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

    public static int coresCalculate() {
        return Runtime.getRuntime().availableProcessors();
    }
}
