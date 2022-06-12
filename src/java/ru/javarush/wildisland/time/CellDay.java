package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.StatisticAfterDay;
import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.animals.abstracts.Plant;
import ru.javarush.wildisland.animals.herbivore.Caterpillar;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class CellDay implements Callable<StatisticAfterDay> {
    public IslandAreaCell areaCell;

    public CellDay(IslandAreaCell areaCell) {
        this.areaCell = areaCell;
    }

    @Override
    public StatisticAfterDay call() throws Exception {
        System.out.println("+ " + this.areaCell.cellId + " Thread " + Thread.currentThread().getName() + " is starting");

        StatisticAfterDay statisticAfterDay = new StatisticAfterDay(areaCell);
        HashMap<IslandItem, IslandItem> interActionPairs = createPairs(areaCell.cellIslandItems);

        System.out.println(areaCell.cellIslandItems.size() + " items provided " + interActionPairs.size() + " pairs");
        System.out.println("- " + this.areaCell.cellId + " Thread " + Thread.currentThread().getName() + " is finishing");
        return null;
    }

    public HashMap<IslandItem, IslandItem> createPairs(Set<IslandItem> islandItems) {
        HashMap<IslandItem, IslandItem> pairs = new HashMap<>();
        if (islandItems.size() % 2 != 0) {
            islandItems.add(new Caterpillar());
        }

        int flag = 0;
        IslandItem key = null;
        IslandItem value;
        for (IslandItem item : islandItems) {
            if (flag == 0) {
                key = item;
                flag++;
            } else if (flag == 1 && key != null) {
                value = item;
                pairs.put(key, value);
                flag = 0;
                key = null;
                value = null;
            }
        }

        return pairs;
    }
}
