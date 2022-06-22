package ru.javarush.wildisland.animals.predator;

import ru.javarush.wildisland.animals.abstracts.Animal;
import ru.javarush.wildisland.animals.herbivore.Caterpillar;
import ru.javarush.wildisland.animals.herbivore.Duck;
import ru.javarush.wildisland.animals.herbivore.Mouse;
import ru.javarush.wildisland.animals.herbivore.Rabbit;

public class Fox extends Animal {

    public Fox() {
        super();
        eatingProbability.put(Rabbit.class.getSimpleName(), 70);
        eatingProbability.put(Mouse.class.getSimpleName(), 90);
        eatingProbability.put(Duck.class.getSimpleName(), 60);
        eatingProbability.put(Caterpillar.class.getSimpleName(), 40);

        neededSatiety = 2;

        this.weight = 8;
        this.speed = 2;
        this.satiety = neededSatiety / 2;
    }
}
