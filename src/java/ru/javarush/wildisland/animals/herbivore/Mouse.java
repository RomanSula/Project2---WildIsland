package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.plants.Herb;

public class Mouse extends Animal {

    public Mouse() {
        super();
        eatingProbability.put(Caterpillar.class.getSimpleName(), 90);
        eatingProbability.put(Herb.class.getSimpleName(), 100);
        neededSatiety = 0.01;

        this.weight = 0.05;
        this.speed = 1;
        this.satiety = neededSatiety * 0.9;
    }
}
