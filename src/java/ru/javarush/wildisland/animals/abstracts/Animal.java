package ru.javarush.wildisland.animals.abstracts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends IslandItem {
    public static double neededSatiety;
    public int speed;
    public double satiety;
    public HashMap<String, Integer> eatingProbability = new HashMap<>();

    public Animal() {
        super();
    }

    public boolean eat(IslandItem targetItem) {
        int probability = 0;
        for (Map.Entry<String, Integer> entry : eatingProbability.entrySet()) {
            if (Objects.equals(entry.getKey(), targetItem.getClass().getSimpleName())) probability = entry.getValue();
        }
        int tmp = ThreadLocalRandom.current().nextInt(100);
        boolean isEatIt = tmp <= probability;
        System.out.println(this.getClass().getSimpleName() + "->" + targetItem.getClass().getSimpleName() + "(" + tmp + ":" + probability + ")");
        if (isEatIt) {
            this.satiety += targetItem.weight;
            this.satiety = Math.min(this.satiety, neededSatiety);
        }
        else {
            System.out.println("*" + targetItem.getClass().getSimpleName() + " survived");
            satiety *= 0.9;
            if (targetItem instanceof Animal) ((Animal) targetItem).satiety *= 0.9;
        }
        return isEatIt;
    }

    public void reproduce(IslandItem islandItem) {
        System.out.println(this.getClass().getSimpleName() + " скрестился с " + islandItem.getClass().getSimpleName());
    }

    ;

    public void moveToNewArea() {
    }

    ;
}
