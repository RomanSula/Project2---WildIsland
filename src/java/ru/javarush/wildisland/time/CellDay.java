package ru.javarush.wildisland.time;

import ru.javarush.wildisland.IslandAreaCell;
import ru.javarush.wildisland.StatisticAfterDay;
import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.animals.abstracts.Plant;
import ru.javarush.wildisland.animals.herbivore.Caterpillar;
import ru.javarush.wildisland.animals.predator.Wolf;
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

        StatisticAfterDay statisticAfterDay = new StatisticAfterDay(areaCell);
        long itemsBefore = areaCell.cellIslandItems.size();
        killWeakenedAnimals();
        long itemsAfter = areaCell.cellIslandItems.size();
        statisticAfterDay.deadByHungerAnimals = itemsBefore - itemsAfter;

        HashMap<IslandItem, IslandItem> interActionPairs = createPairs(areaCell.cellIslandItems);
        for (Map.Entry<IslandItem, IslandItem> entry : interActionPairs.entrySet()) {
            if (entry.getKey() instanceof Animal) {
                afterActionsSet.add(entry.getKey());

                String action = chooseAnActionForPair((Animal) entry.getKey(), entry.getValue());
                if (action.equals(Constants.EAT_COMMAND)) {
                    if (!((Animal) entry.getKey()).eat(entry.getValue())) afterActionsSet.add(entry.getValue());
                } else statisticAfterDay.eatenAnimals++;

                if (action.equals(Constants.REPRODUCE_COMMAND)) {
                    afterActionsSet.add(entry.getKey());
                    afterActionsSet.add(entry.getValue());

                    IslandItem reproducedItem = ((Animal) entry.getKey()).reproduce((Animal) entry.getValue());
                    if (reproducedItem != null) {
                        afterActionsSet.add(reproducedItem);
                        statisticAfterDay.reproducedAnimals++;
                    }
                }
                if (action.equals(Constants.NONE_COMMAND)){
                    afterActionsSet.add(entry.getKey());
                    afterActionsSet.add(entry.getValue());
                }
            }
        }

        System.out.println(itemsBefore + "|" + afterActionsSet.size() + " " + statisticAfterDay.deadByHungerAnimals + " Animals dead by hunger: "
                + statisticAfterDay.eatenAnimals + " Animals have been eaten: "
                + statisticAfterDay.reproducedAnimals + " Animals were born.");

        moveAnimals();
        return null;
    }

    public static String chooseAnActionForPair(Animal master, IslandItem slave) {
        String actionName = Constants.NONE_COMMAND;
        if (master.getClass().getSimpleName().equals(slave.getClass().getSimpleName())) {
            actionName = Constants.REPRODUCE_COMMAND;
        } else if (master.eatingProbability.containsKey(slave.getClass().getSimpleName())) {
            actionName = Constants.EAT_COMMAND;
        }
        return actionName;
    }

    public void killWeakenedAnimals() {
        areaCell.cellIslandItems.removeIf(islandItem -> islandItem instanceof Animal && ((Animal) islandItem).satiety <
                ((Animal) islandItem).neededSatiety * Constants.SATIETY_FOR_DEATH);
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
            }
        }

        return pairs;
    }

    public void moveAnimals(){
        for (IslandItem islandItem : afterActionsSet) {
            String newCellId = ((Animal)islandItem).moveToNewArea(areaCell.cellId);
            System.out.println(islandItem.getClass().getSimpleName() + " moved from " + areaCell.cellId + " to " + newCellId);
        }
    }
}
