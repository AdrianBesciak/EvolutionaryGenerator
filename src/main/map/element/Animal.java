package map.element;

import json.StartValues;
import map.*;

public class Animal extends MapElement {
    public Genome genome;
    private static StartValues startValues = new StartValues();
    private int energy;

    public Animal(IWorldMap map)        //constructor of first animals
    {
        super(map, map.getRandomEmptyPosition());
        genome = new Genome();
        this.energy = startValues.getEnergyOnStart();
    }

    public Animal(IWorldMap map, Animal father, Animal mother)  //constructor of other animals
    {
        super(map, map.calculateCorrectPositionOfElement(map.findPlaceForBirth(father.getPosition())));
        this.genome = new Genome(father, mother);
        this.energy = father.energy / 4 + mother.energy / 4;
        father.energy -= father.energy / 4;
        mother.energy -= mother.energy / 4;

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


}
