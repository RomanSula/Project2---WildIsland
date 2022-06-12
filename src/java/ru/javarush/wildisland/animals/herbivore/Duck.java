package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Duck extends HerbivoreAnimal {
    public Duck() {
        super();
        neededSatiety = 0.15;

        this.weight = 1;
        this.speed = 4;
        this.Satiety = neededSatiety * 0.9;
    }
}
