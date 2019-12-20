package simulation;

import Maps.WorldMap;
import element.Animal;
import element.IMapElement;
import element.Tree;
import json.StartValues;

public class Day {
    WorldMap map;

    public Day()
    {
        map = new WorldMap();
        for (int i = 0; i < StartValues.getAnimalsOnStart(); i++)
            map.place(new Animal(map));
        addTrees();
    }

    public void nextDay()
    {
        map.makeFuneral();
        map.moveAnimals();
        //eat
        //reproduce
        addTrees();

    }


    private void addTrees()
    {
        map.place(new Tree(map, map.getRandomJunglePosition()));
        map.place(new Tree(map, map.getRandomNonJunglePosition()));
    }


}
