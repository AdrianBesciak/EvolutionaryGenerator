package simulation;

import Maps.Vector2d;
import Maps.WorldMap;
import element.Animal;
import element.Tree;
import json.StartValues;

public class Simulation {
    WorldMap map;
    StartValues val;

    public Simulation()
    {
        val = new StartValues();
        //StartValues.loadStartValues();
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
