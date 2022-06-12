package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;

public class Fox extends PredatorAnimal {
    public Fox() {
        super();
        neededSatiety = 2;

        this.weight = 8;
        this.speed = 2;
        this.Satiety = neededSatiety / 2;
    }
}
