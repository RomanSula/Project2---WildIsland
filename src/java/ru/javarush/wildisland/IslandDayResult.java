package ru.javarush.wildisland;

import ru.javarush.wildisland.animals.abstracts.IslandItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IslandDayResult {
    public Map<IslandItem, Integer> islandItemAmount = new HashMap<>();
    public Set<IslandItem> afterActionsSet = new HashSet<>();
    public StatisticAfterDay statisticAfterDay;

    public IslandDayResult(Map<IslandItem, Integer> islandItemAmount, Set<IslandItem> afterActionsSet, StatisticAfterDay statisticAfterDay) {
        this.islandItemAmount = islandItemAmount;
        this.afterActionsSet = afterActionsSet;
        this.statisticAfterDay = statisticAfterDay;
    }
}
