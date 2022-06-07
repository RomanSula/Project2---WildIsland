package ru.javarush.wildisland;

public abstract class IslandItem {
    public int positionX, getPositionY;
    public int weight;
    public int maxItemCount;

    public IslandItem(int positionX, int getPositionY) {
        this.positionX = positionX;
        this.getPositionY = getPositionY;

    }
}
