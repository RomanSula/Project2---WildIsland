package ru.javarush.wildisland.statistics;

import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.statistics.StatisticAfterDay;

import java.util.HashSet;
import java.util.Set;

public class IslandDayResult {
    public Set<IslandItem> afterActionsSet = new HashSet<>();
    public StatisticAfterDay statisticAfterDay;

    public IslandDayResult(Set<IslandItem> afterActionsSet, StatisticAfterDay statisticAfterDay) {
        this.afterActionsSet = afterActionsSet;
        this.statisticAfterDay = statisticAfterDay;
    }
}
