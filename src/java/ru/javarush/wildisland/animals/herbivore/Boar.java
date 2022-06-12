package ru.javarush.wildisland.animals.herbivore;

import ru.javarush.wildisland.animals.abstracts.HerbivoreAnimal;

public class Boar extends HerbivoreAnimal {
    public Boar() {
        super();
        neededSatiety = 50;

        this.weight = 400;
        this.speed = 2;
        this.Satiety = neededSatiety * 0.9;
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }

    @Override
    public void moveToNewArea() {
        super.moveToNewArea();
    }
}
