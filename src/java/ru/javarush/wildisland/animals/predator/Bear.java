package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;

public class Bear extends PredatorAnimal {

    public Bear() {
        super();
        neededSatiety = 80;

        this.weight = 500;
        this.speed = 2;
        this.Satiety = neededSatiety / 2;
    }
}
