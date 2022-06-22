package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Buffalo extends Animal {

    public Buffalo() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 100;

        this.weight = 700;
        this.speed = 3;
        this.satiety = neededSatiety * 0.9;
    }
}
