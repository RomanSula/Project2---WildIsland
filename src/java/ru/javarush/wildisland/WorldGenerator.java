package ru.javarush.wildisland;

import ru.javarush.wildisland.animals.abstracts.Animal;

import java.util.HashSet;
import java.util.Set;

public class WorldGenerator {

    public static void generate() {
        IslandArea islandArea = IslandArea.getInstance();
        for (IslandAreaCell[] cells : islandArea.islandArray) {

        }
    }
    public static Set<Animal> generateAnimals(){
        Set<Animal> generatedAnimals = new HashSet<>();

        return generatedAnimals;
    }

}
