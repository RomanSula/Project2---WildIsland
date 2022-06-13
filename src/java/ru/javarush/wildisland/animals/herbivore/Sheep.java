package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Sheep extends HerbivoreAnimal {

    public Sheep() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 15;

        this.weight = 70;
        this.speed = 3;
        this.satiety = neededSatiety * 0.9;
    }
}
