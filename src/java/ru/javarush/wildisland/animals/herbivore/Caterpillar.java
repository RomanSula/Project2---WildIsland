package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Caterpillar extends HerbivoreAnimal {
    public Caterpillar() {
        super();
        neededSatiety = 0;

        this.weight = 0.01;
        this.speed = 0;
        this.Satiety = neededSatiety;
    }
}
