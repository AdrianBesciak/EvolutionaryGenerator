package map.animal;

import map.*;
import map.animal.Genome;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Animal implements IMapElement {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    public Genome genome;

    public Animal()
    {
        direction = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map)        //constructor of first animals
    {
        this();
        this.map = map;
        genome = new Genome();
    }

    public Animal(IWorldMap map, Animal father, Animal mother)  //constructor of other animals
    {
        this();
        this.map = map;
        this.genome = new Genome(father, mother);
        this.position = map.findPlaceForBirth(father.getPosition());
    }

    public Vector2d getPosition()
    {
        return this.position;
    }

    public String toString(){
        switch (this.direction)
        {
            case NORTH:
                return "N";
            case NORTHEAST:
                return "NE";
            case EAST:
                return "E";
            case SOUTHEAST:
                return "SE";
            case SOUTH:
                return "S";
            case SOUTHWEST:
                return "SW";
            case WEST:
                return "W";
            case NORTHWEST:
                return "NW";
            default:
                return null;
        }
    }




}
