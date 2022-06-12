package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.Duck;
import ru.javarush.wildisland.animals.herbivore.Mouse;
import ru.javarush.wildisland.animals.herbivore.Rabbit;

import java.util.HashMap;

public class Eagle extends PredatorAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Fox.class.getSimpleName(), 10);
        eatingProbability.put(Rabbit.class.getSimpleName(), 90);
        eatingProbability.put(Mouse.class.getSimpleName(), 90);
        eatingProbability.put(Duck.class.getSimpleName(), 80);
    }
    public Eagle() {
        super();
        neededSatiety = 1;

        this.weight = 6;
        this.speed = 3;
        this.Satiety = neededSatiety / 2;
    }
}
