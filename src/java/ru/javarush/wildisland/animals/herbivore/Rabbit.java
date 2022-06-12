package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Rabbit extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }
    public Rabbit() {
        super();
        neededSatiety = 0.45;

        this.weight = 2;
        this.speed = 2;
        this.Satiety = neededSatiety * 0.9;
    }
}
