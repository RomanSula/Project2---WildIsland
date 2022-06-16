package ru.javarush.wildisland.time;

import ru.javarush.wildisland.*;
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

public class CellDay implements Callable<IslandDayResult> {
    public IslandAreaCell areaCell;
    public Set<IslandItem> afterActionsSet = new HashSet<>();

    public CellDay(IslandAreaCell areaCell) {
        this.areaCell = areaCell;
    }

    @Override
    public IslandDayResult call() throws Exception {

        Map<IslandItem, Integer> islandItemAmount = new HashMap<>();
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

        //moveAnimals();
        // TODO: 16.06.2022 заполнить мапу сущностей для вывода в конце дня количества по видам
        return new IslandDayResult(islandItemAmount, afterActionsSet, statisticAfterDay);
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
        IslandAreaCell[][] newIslandAreaCell = CellsGenerator.generate(Constants.ISLAND_HEIGHT, Constants.ISLAND_WIDTH);
        //подумать о переносе этого метода в IslandDay и уже там формировать ячейки с сетами сущностей
        //для нового дня. !!! Как запустить новый день с новыми параметрами?
        for (IslandItem islandItem : afterActionsSet) {
            int[] newCoordinate = new  int[2];
            newCoordinate = ((Animal)islandItem).moveToNewArea(areaCell.cellId);
            newIslandAreaCell[newCoordinate[0]][newCoordinate[1]].cellIslandItems.add(islandItem);
            //System.out.println(islandItem.getClass().getSimpleName() + " moved from " + areaCell.cellId + " to " + newCellId);
        }
        System.out.println("new Cells array ready" + newIslandAreaCell.length);

    }
}
