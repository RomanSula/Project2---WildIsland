package ru.javarush.wildisland.animals.abstracts;

import ru.javarush.wildisland.IslandItem;

public abstract class Animal extends IslandItem {
    int weigh;
    int movingSpeed;
    int kilogramsForSatiety;


    public Animal(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void eat() {
    }

    public void reproduce() {
    }

    ;

    public void moveToNewArea() {
    }

    ;
}
