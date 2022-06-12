package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Goat extends HerbivoreAnimal {
    public Goat() {
        super();
        neededSatiety = 10;

        this.weight = 60;
        this.speed = 3;
        this.Satiety = neededSatiety * 0.9;
    }
}
