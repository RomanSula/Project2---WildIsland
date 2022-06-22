package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Duck extends Animal {

    public Duck() {
        super();
        eatingProbability.put(Caterpillar.class.getSimpleName(), 90);
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 0.15;

        this.weight = 1;
        this.speed = 4;
        this.satiety = neededSatiety * 0.9;
    }
}
