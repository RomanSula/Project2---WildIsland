package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Rabbit extends Animal {

    public Rabbit() {
        super();
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 0.45;

        this.weight = 2;
        this.speed = 2;
        this.satiety = neededSatiety * 0.9;
    }
}
