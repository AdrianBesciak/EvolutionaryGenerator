package element;

import json.StartValues;
import Maps.IWorldMap;
import Maps.Vector2d;

import java.util.ArrayList;

public class Tree extends MapElement {

    public Tree(IWorldMap map, Vector2d position)
    {
        super( map, position);
        this.energyLevel = StartValues.getEnergyOfTree();
    }

    public String toString()
    {
        return "T";
    }

    public void move()
    {
        ;
    }

    public void eatTree(ArrayList<IMapElement> animals)
    {
        this.energyLevel = -1;
        animals.remove(0);      //remove tree from this list

        int maxEnergyLevel = 0;
        for (IMapElement it : animals ) {
            maxEnergyLevel = Math.max(maxEnergyLevel, it.getEnergyLevel());
        }

        ArrayList<Animal> toFeed = new ArrayList<>();

        for (IMapElement it : animals ) {
            if (it.getEnergyLevel() == maxEnergyLevel)
                toFeed.add((Animal)it);
        }

        for (Animal it : toFeed ) {
            it.feed(this.energyLevel / toFeed.size());
        }
    }
}
