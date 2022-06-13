package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Goat extends HerbivoreAnimal {

    public Goat() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 10;

        this.weight = 60;
        this.speed = 3;
        this.satiety = neededSatiety * 0.9;
    }
}
