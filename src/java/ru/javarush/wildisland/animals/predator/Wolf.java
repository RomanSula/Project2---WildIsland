package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;

public class Wolf extends PredatorAnimal {
    public Wolf() {
        super();
        neededSatiety = 8;

        this.weight = 50;
        this.speed = 3;
        this.Satiety = neededSatiety / 2;
    }
}
