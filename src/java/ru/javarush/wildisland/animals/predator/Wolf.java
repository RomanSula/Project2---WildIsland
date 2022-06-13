package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.*;

import java.util.HashMap;

public class Wolf extends PredatorAnimal {

    public Wolf() {
        super();
        eatingProbability.put(Horse.class.getSimpleName(), 10);
        eatingProbability.put(Deer.class.getSimpleName(), 15);
        eatingProbability.put(Rabbit.class.getSimpleName(), 60);
        eatingProbability.put(Mouse.class.getSimpleName(), 80);
        eatingProbability.put(Goat.class.getSimpleName(), 60);
        eatingProbability.put(Sheep.class.getSimpleName(), 70);
        eatingProbability.put(Boar.class.getSimpleName(), 15);
        eatingProbability.put(Buffalo.class.getSimpleName(), 10);
        eatingProbability.put(Duck.class.getSimpleName(), 40);
        neededSatiety = 8;

        this.weight = 50;
        this.speed = 3;
        this.satiety = neededSatiety / 2;
    }
}
