package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Deer extends HerbivoreAnimal {

    public Deer() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 50;

        this.weight = 300;
        this.speed = 4;
        this.satiety = neededSatiety * 0.9;
    }
}
