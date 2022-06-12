package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Deer extends HerbivoreAnimal {
    public Deer() {
        super();
        neededSatiety = 50;

        this.weight = 300;
        this.speed = 4;
        this.Satiety = neededSatiety * 0.9;
    }
}
