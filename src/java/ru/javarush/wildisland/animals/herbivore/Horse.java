package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Horse extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }
    public Horse() {
        super();
        neededSatiety = 60;

        this.weight = 400;
        this.speed = 4;
        this.Satiety = neededSatiety * 0.9;
    }
}
