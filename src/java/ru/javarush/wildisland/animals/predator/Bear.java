package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;
import ru.javarush.wildisland.animals.herbivore.*;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Bear extends PredatorAnimal {

    public Bear() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        eatingProbability.put(Boa.class.getSimpleName(), 80);
        eatingProbability.put(Horse.class.getSimpleName(), 40);
        eatingProbability.put(Deer.class.getSimpleName(), 80);
        eatingProbability.put(Rabbit.class.getSimpleName(), 80);
        eatingProbability.put(Mouse.class.getSimpleName(), 90);
        eatingProbability.put(Goat.class.getSimpleName(), 70);
        eatingProbability.put(Sheep.class.getSimpleName(), 70);
        eatingProbability.put(Boar.class.getSimpleName(), 50);
        eatingProbability.put(Buffalo.class.getSimpleName(), 20);
        eatingProbability.put(Duck.class.getSimpleName(), 10);

        neededSatiety = 80;

        this.weight = 500;
        this.speed = 2;
        this.satiety = neededSatiety / 2;
    }
}
