package map.animal;

import map.IWorldMap;
import map.IMapElement;
//import agh.cs.lab7.IPositionChangeObserver;
//import project.Genome;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Animal/* implements IMapElement*/ {
   /* private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList();

    public Animal()
    {
        direction = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map)
    {
        this();
        this.map = map;
        this.addObserver((IPositionChangeObserver)(map));
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this();
        this.map = map;
        this.position = initialPosition;
        this.addObserver((IPositionChangeObserver)(map));
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

    private void moveForward()
    {
        Vector2d temp = map.calculateCorrectPositionOfElement(this.position.add(this.direction.toUnitVector()));
        if (temp != null)
        {
            positionChanged(this.position, temp);
            this.position = temp;
        }
    }

    private void moveBackward()
    {
        Vector2d temp = map.calculateCorrectPositionOfElement(this.position.subtract(this.direction.toUnitVector()));
        if (temp != null)
        {
            positionChanged(this.position, temp);
            this.position = temp;
        }
    }

    public void move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT:
                this.direction = this.direction.next();
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                this.direction = this.direction.previous();
                break;
            case FORWARDLEFT:
                this.direction = this.direction.previous();
                this.moveForward();
                break;
            case FORWARD:
                this.moveForward();
                break;
            case FORWARDRIGHT:
                this.direction = this.direction.next();
                this.moveForward();
                break;
            case BACKWARDLEFT:
                this.direction = this.direction.previous();
                this.moveBackward();
                break;
            case BACKWARDRIGHT:
                this.direction = this.direction.next();
                this.moveBackward();
                break;
            case BACKWARD:
                this.moveBackward();
                break;
            default:
                break;
        }
    }

    public boolean equals(Object other)
    {
        if (this == other)
            return true;
        if (!(other instanceof Animal))
            return false;
        Animal temp = (Animal) other;
        return this.position.equals(temp.position) && this.direction == temp.direction;
    }


    public void addObserver(IPositionChangeObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer)
    {
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        for (IPositionChangeObserver observer : observers)
            observer.positionChanged(oldPosition, newPosition);
    }
*/
}
