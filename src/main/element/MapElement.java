package element;

import Maps.IWorldMap;
import Maps.Vector2d;

import java.util.Random;

public abstract class MapElement implements IMapElement {
    protected Vector2d position;
    protected IWorldMap map;
    private static final Random random = new Random();
    protected int energyLevel;



    public MapElement(IWorldMap map, Vector2d position)
    {
        this.position = position;
        this.map = map;
    }

    public Vector2d getPosition()
    {
        return position;
    }

    public int getEnergyLevel()
    {
        return energyLevel;
    }


}
