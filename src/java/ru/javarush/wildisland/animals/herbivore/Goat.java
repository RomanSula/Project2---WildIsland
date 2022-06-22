package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Goat extends Animal {

    public Goat() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 10;

        this.weight = 60;
        this.speed = 3;
        this.satiety = neededSatiety * 0.9;
    }
}
