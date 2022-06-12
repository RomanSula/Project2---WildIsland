package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.*;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Boa extends PredatorAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Fox.class.getSimpleName(), 15);
        eatingProbability.put(Rabbit.class.getSimpleName(), 20);
        eatingProbability.put(Mouse.class.getSimpleName(), 40);
        eatingProbability.put(Duck.class.getSimpleName(), 10);
    }
    public Boa() {
        super();
        neededSatiety = 3;

        this.weight = 15;
        this.speed = 1;
        this.Satiety = neededSatiety / 2;
    }
}
