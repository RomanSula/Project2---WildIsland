package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Sheep extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }
    public Sheep() {
        super();
        neededSatiety = 15;

        this.weight = 70;
        this.speed = 3;
        this.Satiety = neededSatiety * 0.9;
    }
}
