package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandArea;
import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.StatisticAfterDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class IslandDay implements Callable<StatisticAfterDay> {

    @Override
    public StatisticAfterDay call() throws Exception {
        System.out.println("Day thread is starting->");
        ExecutorService dayExecutor = Executors.newFixedThreadPool(coresCalculate());

        List<Callable<StatisticAfterDay>> dayTasks = createDayTasks();

        System.out.println(dayTasks.size() + " tasks are ready");
        System.out.println();

        List<Future<StatisticAfterDay>> cellsDailyStaticList = dayExecutor.invokeAll(dayTasks);
        System.out.println("*Day was ended*");
        return null;
    }

    public List<Callable<StatisticAfterDay>> createDayTasks() {
        List<Callable<StatisticAfterDay>> dayTasks = new ArrayList<>();
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
