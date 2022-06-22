package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Caterpillar extends Animal {

    public Caterpillar() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 0;

        this.weight = 0.01;
        this.speed = 0;
        this.satiety = neededSatiety;
    }
}
