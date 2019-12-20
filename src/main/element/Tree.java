package element;

import json.StartValues;
import Maps.IWorldMap;
import Maps.Vector2d;

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
}
