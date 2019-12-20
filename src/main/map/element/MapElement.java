package map.element;

import map.IMapElement;
import map.IWorldMap;
import map.MapDirection;
import map.Vector2d;

import java.util.Random;

public abstract class MapElement implements IMapElement {
    protected Vector2d position;
    protected IWorldMap map;
    protected MapDirection direction;
    private static final Random random = new Random();



    public MapElement(IWorldMap map, Vector2d position)
    {
        this.position = position;
        this.map = map;
        this.direction = getFirstOrientation();
    }

    public Vector2d getPosition()
    {
        return position;
    }

    private MapDirection getFirstOrientation()
    {
        MapDirection[] dir = MapDirection.values();
        return dir[random.nextInt(MapDirection.getCountOfDirections())];
    }
}
