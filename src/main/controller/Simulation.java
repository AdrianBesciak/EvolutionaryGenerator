package simulation;

import Maps.Vector2d;
import Maps.WorldMap;
import element.Animal;
import element.Tree;
import json.StartValues;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    public WorldMap map;
    public StartValues val;

    public Simulation()
    {
        val = new StartValues();
        map = new WorldMap();
        for (int i = 0; i < StartValues.getAnimalsOnStart(); i++)
            map.place(new Animal(map));
        addTrees();


    }

    public void nextDay()
    {
        map.makeFuneral();
        map.moveAnimals();
        map.feedAnimals();
        map.reproduction();
        addTrees();

    }


    private void addTrees()
    {
        Vector2d candidate = map.getRandomJunglePosition();
        if (candidate != null)
            map.place(new Tree(map, candidate));
        candidate = map.getRandomNonJunglePosition();
        if (candidate != null)
            map.place(new Tree(map, candidate));
    }


}
