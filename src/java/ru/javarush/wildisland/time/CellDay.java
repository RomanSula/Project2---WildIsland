package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.StatisticAfterDay;

import java.util.concurrent.Callable;

public class CellDay implements Callable<StatisticAfterDay> {
    public IslandAreaCell areaCell;

    public CellDay(IslandAreaCell areaCell) {
        this.areaCell = areaCell;
    }

    @Override
    public StatisticAfterDay call() throws Exception {
        System.out.println("+ " + this.areaCell.cellId + " Thread " + Thread.currentThread().getName() + " is starting");
        System.out.println("- " + this.areaCell.cellId + " Thread " + Thread.currentThread().getName() + " is finishing");
        return null;
    }
}
