package ru.javarush.wildisland.constants;

import ru.javarush.wildisland.animals.abstracts.IslandItem;
import ru.javarush.wildisland.animals.herbivore.*;
import ru.javarush.wildisland.animals.predator.*;
import ru.javarush.wildisland.plants.Herb;

import java.util.HashMap;

public class Constants {
    public static final int BOAR_AMOUNT = 50;
    public static final int BUFFALO_AMOUNT = 10;
    public static final int CATERPILLAR_AMOUNT = 1000;
    public static final int DEER_AMOUNT = 20;
    public static final int DUCK_AMOUNT = 200;
    public static final int GOAT_AMOUNT = 140;
    public static final int HORSE_AMOUNT = 20;
    public static final int MOUSE_AMOUNT = 500;
    public static final int RABBIT_AMOUNT = 150;
    public static final int SHEEP_AMOUNT = 140;

    public static final int BEAR_AMOUNT = 5;
    public static final int BOA_AMOUNT = 30;
    public static final int EAGLE_AMOUNT = 20;
    public static final int FOX_AMOUNT = 30;
    public static final int WOLF_AMOUNT = 30;

    public static final int PLANT_AMOUNT = 200;

    public static HashMap<IslandItem, Integer> islandItems = new HashMap<>();

    static {
        islandItems.put(new Boar(), BOAR_AMOUNT);
        islandItems.put(new Buffalo(), BUFFALO_AMOUNT);
        islandItems.put(new Caterpillar(), CATERPILLAR_AMOUNT);
        islandItems.put(new Deer(), DEER_AMOUNT);
        islandItems.put(new Duck(), DUCK_AMOUNT);
        islandItems.put(new Goat(), GOAT_AMOUNT);
        islandItems.put(new Horse(), HORSE_AMOUNT);
        islandItems.put(new Mouse(), MOUSE_AMOUNT);
        islandItems.put(new Rabbit(), RABBIT_AMOUNT);
        islandItems.put(new Sheep(), SHEEP_AMOUNT);

        islandItems.put(new Bear(), BEAR_AMOUNT);
        islandItems.put(new Boa(), BOA_AMOUNT);
        islandItems.put(new Eagle(), EAGLE_AMOUNT);
        islandItems.put(new Fox(), FOX_AMOUNT);
        islandItems.put(new Wolf(), WOLF_AMOUNT);

        islandItems.put(new Herb(), PLANT_AMOUNT);
    }
}
