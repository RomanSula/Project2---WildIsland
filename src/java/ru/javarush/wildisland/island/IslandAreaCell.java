package ru.javarush.wildisland.island;

import ru.javarush.wildisland.animals.abstracts.IslandItem;

import java.util.HashSet;
import java.util.Set;

public class IslandAreaCell {
    public String cellId;
    public Set<IslandItem> cellIslandItems = new HashSet<>();

    public IslandAreaCell(String cellId) {
        this.cellId = cellId;
    }
}
