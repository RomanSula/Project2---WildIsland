package ru.javarush.wildisland;

import java.util.Set;

public class IslandAreaCell {
    public String cellId;
    public Set<Object> cellIslandItems;

    public IslandAreaCell(String cellId) {
        this.cellId = cellId;
    }
}
