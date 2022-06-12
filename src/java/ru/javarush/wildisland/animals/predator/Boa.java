package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.PredatorAnimal;

public class Boa extends PredatorAnimal {
    public Boa() {
        super();
        neededSatiety = 3;

        this.weight = 15;
        this.speed = 1;
        this.Satiety = neededSatiety / 2;
    }
}
