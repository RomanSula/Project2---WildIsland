package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Horse extends Animal {

    public Horse() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 60;

        this.weight = 400;
        this.speed = 4;
        this.satiety = neededSatiety * 0.9;
    }
}
