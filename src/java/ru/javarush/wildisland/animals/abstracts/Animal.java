package ru.javarush.wildisland.animals.abstracts;

import ru.javarush.wildisland.Direction;
import ru.javarush.wildisland.WorldGenerator;
import ru.javarush.wildisland.constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends IslandItem {
    public double neededSatiety;
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
        //System.out.println(this.getClass().getSimpleName() + "->" + targetItem.getClass().getSimpleName() + "(" + tmp + ":" + probability + ")");
        if (isEatIt) {
            this.satiety += targetItem.weight;
            this.satiety = Math.min(this.satiety, neededSatiety);
        } else {
            //System.out.println("*" + targetItem.getClass().getSimpleName() + " survived");
            satiety *= 0.9;
            if (targetItem instanceof Animal) ((Animal) targetItem).satiety *= 0.9;
        }
        return isEatIt;
    }

    public IslandItem reproduce(Animal targetItem) {
        this.satiety *= 0.8;
        targetItem.satiety *= 0.8;

        if (ThreadLocalRandom.current().nextInt(100) <= Constants.REPRODUCE_PROBABILITY) {
            return WorldGenerator.createIslandItemFromClass((Class<IslandItem>) ((IslandItem) targetItem).getClass());
        } else return null;
    }

    public int[] moveToNewArea(String cellId) {
        //String newCellId;
        int[] newCoordinate = new int[2];
        String[] coordinates = cellId.split(":");
        int horizontalCoordinate = Integer.parseInt(coordinates[1]);
        int verticalCoordinate = Integer.parseInt(coordinates[0]);

        for (int i = 0; i < this.speed; i++) {
            int directionNumber = ThreadLocalRandom.current().nextInt(0, 4);
            Direction direction = Direction.values()[directionNumber];
            switch (direction){
                case LEFT -> {
                    if (horizontalCoordinate - 1 >= 0){
                        horizontalCoordinate--;
                    }
                    else i--;
                }
                case UP -> {
                    if (verticalCoordinate - 1 >= 0){
                        verticalCoordinate--;
                    }
                    else i--;
                }
                case RIGHT ->{
                    if (horizontalCoordinate + 1 < Constants.ISLAND_WIDTH){
                        horizontalCoordinate++;
                    }
                    else i--;
                }
                case DOWN ->{
                    if (verticalCoordinate + 1 < Constants.ISLAND_HEIGHT){
                        verticalCoordinate++;
                    }
                    else i--;
                }
            }
        }
        newCoordinate[0] = verticalCoordinate;
        newCoordinate[1] = horizontalCoordinate;
        return newCoordinate;
    }
}
