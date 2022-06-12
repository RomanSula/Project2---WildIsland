package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Mouse extends HerbivoreAnimal {
    public Mouse() {
        super();
        neededSatiety = 0.01;

        this.weight = 0.05;
        this.speed = 1;
        this.Satiety = neededSatiety * 0.9;
    }
}
