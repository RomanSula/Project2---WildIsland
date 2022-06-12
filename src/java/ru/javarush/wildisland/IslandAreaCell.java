package ru.javarush.wildisland;

import ru.javarush.wildisland.animals.abstracts.IslandItem;

import java.util.Set;

public class IslandAreaCell {
    public String cellId;
    public Set<IslandItem> cellIslandItems;

    public IslandAreaCell(String cellId) {
        this.cellId = cellId;
    }
}
