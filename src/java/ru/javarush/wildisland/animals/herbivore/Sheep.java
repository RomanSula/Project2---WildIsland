package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Sheep extends HerbivoreAnimal {
    public Sheep() {
        super();
        neededSatiety = 15;

        this.weight = 70;
        this.speed = 3;
        this.Satiety = neededSatiety * 0.9;
    }
}
