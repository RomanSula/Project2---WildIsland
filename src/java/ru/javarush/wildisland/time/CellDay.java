package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.StatisticAfterDay;
import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.animals.abstracts.Plant;
import ru.javarush.wildisland.animals.herbivore.Caterpillar;
import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class CellDay implements Callable<StatisticAfterDay> {
    public IslandAreaCell areaCell;
    public Set<IslandItem> afterActionsSet = new HashSet<>();

    public CellDay(IslandAreaCell areaCell) {
        this.areaCell = areaCell;
    }

    @Override
    public StatisticAfterDay call() throws Exception {
        System.out.println("+ " + this.areaCell.cellId + " Thread " + Thread.currentThread().getName() + " is starting");

        StatisticAfterDay statisticAfterDay = new StatisticAfterDay(areaCell);

        HashMap<IslandItem, IslandItem> interActionPairs = createPairs(areaCell.cellIslandItems);
        for (Map.Entry<IslandItem, IslandItem> entry : interActionPairs.entrySet()) {
            if (entry.getKey() instanceof Animal){
                afterActionsSet.add(entry.getKey());

                String action = chooseAnActionForPair((Animal) entry.getKey(), entry.getValue());
                if (action.equals(Constants.EAT_COMMAND)){
                    if (!((Animal) entry.getKey()).eat(entry.getValue())) afterActionsSet.add(entry.getValue());
                }
                //тест для размножения
                if (action.equals(Constants.REPRODUCE_COMMAND)) ((Animal) entry.getKey()).reproduce(entry.getValue());
            }
        }
        System.out.println(areaCell.cellId + "-cell- " +areaCell.cellIslandItems.size() + " items started the day, but only "
                + afterActionsSet.size() + " survived");
        return null;
    }

    public static String chooseAnActionForPair(Animal master, IslandItem slave){
        String actionName = Constants.NONE_COMMAND;
        if (master.getClass().getSimpleName().equals(slave.getClass().getSimpleName())){
            actionName = Constants.REPRODUCE_COMMAND;
        }
        else if (master.eatingProbability.containsKey(slave.getClass().getSimpleName())){
            actionName = Constants.EAT_COMMAND;
        }
        return actionName;
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
