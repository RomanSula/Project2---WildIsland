package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;

public class Eagle extends PredatorAnimal {
    public Eagle() {
        super();
        neededSatiety = 1;

        this.weight = 6;
        this.speed = 3;
        this.Satiety = neededSatiety / 2;
    }
}
