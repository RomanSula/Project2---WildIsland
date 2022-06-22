package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Deer extends Animal {

    public Deer() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 50;

        this.weight = 300;
        this.speed = 4;
        this.satiety = neededSatiety * 0.9;
    }
}
