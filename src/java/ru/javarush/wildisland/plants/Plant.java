package ru.javarush.wildisland.plants;

import ru.javarush.wildisland.IslandItem;

public abstract class Plant extends IslandItem {
    public int weight;

    public Plant(int positionX, int getPositionY) {
        super(positionX, getPositionY);
    }
}
