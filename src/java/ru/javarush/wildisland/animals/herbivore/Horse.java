package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Horse extends HerbivoreAnimal {
    public Horse() {
        super();
        neededSatiety = 60;

        this.weight = 400;
        this.speed = 4;
        this.Satiety = neededSatiety * 0.9;
    }
}
