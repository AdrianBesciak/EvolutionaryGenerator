package map.element;

import json.StartValues;
import map.IWorldMap;
import map.Vector2d;

public class Tree extends MapElement {
    private int energy;

    public Tree(IWorldMap map, Vector2d position)
    {
        super( map, position);
        this.energy = StartValues.getEnergyOfTree();
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
