package map.element;

import map.IMapElement;
import map.IWorldMap;
import map.MapDirection;
import map.Vector2d;

public abstract class MapElement implements IMapElement {
    protected Vector2d position;
    protected IWorldMap map;
    protected MapDirection direction;


    public MapElement(IWorldMap map, Vector2d position)
    {
        this.position = position;
        this.map = map;
        this.direction = this.direction.getFirstOrientation();
    }

    public Vector2d getPosition()
    {
        return position;
    }
}
