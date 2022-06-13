package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.Duck;
import ru.javarush.wildisland.animals.herbivore.Mouse;
import ru.javarush.wildisland.animals.herbivore.Rabbit;

import java.util.HashMap;

public class Eagle extends PredatorAnimal {

    public Eagle() {
        super();
        eatingProbability.put(Fox.class.getSimpleName(), 10);
        eatingProbability.put(Rabbit.class.getSimpleName(), 90);
        eatingProbability.put(Mouse.class.getSimpleName(), 90);
        eatingProbability.put(Duck.class.getSimpleName(), 80);
        neededSatiety = 1;

        this.weight = 6;
        this.speed = 3;
        this.satiety = neededSatiety / 2;
    }
}
