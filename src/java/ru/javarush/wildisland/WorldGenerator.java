package ru.javarush.wildisland;

import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.plants.Herb;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class WorldGenerator {
    public static long totalItems = 0;
    public static long animalItems = 0;


    public static void generate() {
        IslandArea islandArea = IslandArea.getInstance();
        for (int i = 0; i < islandArea.islandArray.length; i++) {
            for (int j = 0; j < islandArea.islandArray[i].length; j++) {
                islandArea.islandArray[i][j].cellIslandItems = generateAnimalsAndPlants();
                totalItems += islandArea.islandArray[i][j].cellIslandItems.size();
            }
        }
    }

    public static Set<IslandItem> generateAnimalsAndPlants() {
        Set<IslandItem> generatedItems = new HashSet<>();
        Random random = new Random();

        for (Map.Entry<IslandItem, Integer> islandItem : Constants.islandItems.entrySet()) {
            Class<IslandItem> animalClass = (Class<IslandItem>) islandItem.getKey().getClass();
            int itemCountFromRandom;

            if (islandItem.getKey() instanceof Herb) {
                itemCountFromRandom = islandItem.getValue();
            } else {
                itemCountFromRandom = random.nextInt(islandItem.getValue());
                animalItems += itemCountFromRandom;
            }

            for (int i = 0; i < itemCountFromRandom; i++) {
                generatedItems.add(createIslandItemFromClass(animalClass));
            }
        }
        return generatedItems;
    }

    public static IslandItem createIslandItemFromClass(Class<IslandItem> itemClass) {
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
