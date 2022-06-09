package ru.javarush.wildisland;

import ru.javarush.wildisland.animals.abstracts.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorldGenerator {

    public static void generate() {
        IslandArea islandArea = IslandArea.getInstance();
        for (int i = 0; i < islandArea.islandArray.length; i++) {
            for (int j = 0; j < islandArea.islandArray[i].length; j++) {
                islandArea.islandArray[i][j].cellIslandItems = generateAnimals();
            }
        }
    }
    public static Set<IslandItem> generateAnimals() {
        Set<IslandItem> generatedAnimals = new HashSet<>();

        for (Map.Entry<IslandItem, Integer> islandItem : Constants.islandItems.entrySet()) {
            Class<IslandItem> animalClass = (Class<IslandItem>) islandItem.getKey().getClass();
            for (int i = 0; i < islandItem.getValue(); i++) {
                generatedAnimals.add(createAnimalFromClass(animalClass));
            }
        }
        return generatedAnimals;
    }

    public static IslandItem createAnimalFromClass(Class<IslandItem> itemClass){
        IslandItem islandItem = null;
        try {
            Constructor<IslandItem> constructor = (Constructor<IslandItem>) itemClass.getConstructors()[0];
            islandItem = constructor.newInstance(new Object[constructor.getParameterCount()]);
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Some problems with creating Island Item " + itemClass.getSimpleName());
        } catch (InvocationTargetException e) {
            System.err.println("Some problems with creating Island Item " + itemClass.getSimpleName());
        }
        return islandItem;
    }
}
