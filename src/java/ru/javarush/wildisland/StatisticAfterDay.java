package ru.javarush.wildisland;

public class StatisticAfterDay {
    public IslandAreaCell areaCell;
    public long eatenAnimals = 0;
    public long deadOfHungerAnimals = 0;
    public long reproducedAnimals = 0;

    public StatisticAfterDay(IslandAreaCell islandAreaCell) {
        this.areaCell = islandAreaCell;
    }
}
