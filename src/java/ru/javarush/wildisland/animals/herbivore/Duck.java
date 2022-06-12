package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Duck extends HerbivoreAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Caterpillar.class.getSimpleName(), 90);
        eatingProbability.put(Herb.class.getSimpleName(), 100);
    }
    public Duck() {
        super();
        neededSatiety = 0.15;

        this.weight = 1;
        this.speed = 4;
        this.Satiety = neededSatiety * 0.9;
    }
}
