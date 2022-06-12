package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.Caterpillar;
import ru.javarush.wildisland.animals.herbivore.Duck;
import ru.javarush.wildisland.animals.herbivore.Mouse;
import ru.javarush.wildisland.animals.herbivore.Rabbit;

import java.util.HashMap;

public class Fox extends PredatorAnimal {
    public static HashMap<String, Integer> eatingProbability = new HashMap<>();

    static {
        eatingProbability.put(Rabbit.class.getSimpleName(), 70);
        eatingProbability.put(Mouse.class.getSimpleName(), 90);
        eatingProbability.put(Duck.class.getSimpleName(), 60);
        eatingProbability.put(Caterpillar.class.getSimpleName(), 40);
    }
    public Fox() {
        super();
        neededSatiety = 2;

        this.weight = 8;
        this.speed = 2;
        this.Satiety = neededSatiety / 2;
    }
}
