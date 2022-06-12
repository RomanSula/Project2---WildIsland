package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Goat extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }
    public Goat() {
        super();
        neededSatiety = 10;

        this.weight = 60;
        this.speed = 3;
        this.Satiety = neededSatiety * 0.9;
    }
}
