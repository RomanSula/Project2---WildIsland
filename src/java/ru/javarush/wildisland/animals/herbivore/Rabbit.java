package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Rabbit extends HerbivoreAnimal {
    public Rabbit() {
        super();
        neededSatiety = 0.45;

        this.weight = 2;
        this.speed = 2;
        this.Satiety = neededSatiety * 0.9;
    }
}
