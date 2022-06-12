package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Buffalo extends HerbivoreAnimal {
    public Buffalo() {
        super();
        neededSatiety = 100;

        this.weight = 700;
        this.speed = 3;
        this.Satiety = neededSatiety * 0.9;
    }
}
