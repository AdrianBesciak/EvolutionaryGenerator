package element;

import Maps.IWorldMap;
import Maps.MapDirection;
import Maps.Vector2d;
import json.StartValues;

import java.util.Random;

public class Animal extends MapElement {
    public Genome genome;
    protected MapDirection direction;
    private static StartValues startValues = new StartValues();
    private static final Random random = new Random();


    public Animal(IWorldMap map)        //constructor of first animals
    {
        super(map, map.getRandomEmptyPosition());
        this.direction = getFirstOrientation();
        genome = new Genome();
        this.energyLevel = startValues.getEnergyOnStart();
    }

    public Animal(IWorldMap map, Animal father, Animal mother)  //constructor of other animals
    {
        super(map, map.calculateCorrectPositionOfElement(map.findPlaceForBirth(father.getPosition())));
        this.genome = new Genome(father, mother);
        this.energyLevel = father.energyLevel / 4 + mother.energyLevel / 4;
        father.energyLevel -= father.energyLevel / 4;
        mother.energyLevel -= mother.energyLevel / 4;

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

    public void move()
    {
        Vector2d positionCandidate = this.position.add(this.genome.getMove().toUnitVector());
        this.position = map.calculateCorrectPositionOfElement(positionCandidate);
    }

    private MapDirection getFirstOrientation()
    {
        MapDirection[] dir = MapDirection.values();
        return dir[random.nextInt(MapDirection.getCountOfDirections())];
    }


}
