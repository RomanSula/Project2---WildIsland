package ru.javarush.wildisland;

import ru.javarush.wildisland.consoleUI.Dialogue;
import ru.javarush.wildisland.constants.Constants;
import ru.javarush.wildisland.time.IslandDay;

import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        new Dialogue().start();
    }
}
