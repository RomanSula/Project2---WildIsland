package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Boar extends Animal {

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
