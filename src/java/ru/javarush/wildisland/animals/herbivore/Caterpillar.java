package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Caterpillar extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }

    public Caterpillar() {
        super();
        neededSatiety = 0;

        this.weight = 0.01;
        this.speed = 0;
        this.Satiety = neededSatiety;
    }
}
