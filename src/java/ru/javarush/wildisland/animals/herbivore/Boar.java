package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;
import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Boar extends HerbivoreAnimal {

    public Boar() {
        super();
        eatingProbability.put(Mouse.class.getSimpleName(), 50);
        eatingProbability.put(Caterpillar.class.getSimpleName(), 90);
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 50;

        this.weight = 400;
        this.speed = 2;
        this.satiety = neededSatiety * 0.9;
    }
}
