package map;

import map.element.Animal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class WorldMap extends MapSpace {
    Map<Vector2d, IMapElement> elements = new LinkedHashMap<>();
    private static final Random random = new Random();

    public WorldMap()
    {
        super();
    }

    public boolean place(IMapElement elem)
    {
       // if (this.isOccupied(elem.getPosition()))
        //    throw new IllegalArgumentException("Position " + animal.getPosition().toString() + "is occupied by another object");
        elements.put(elem.getPosition(), elem);
        return true;
    }

    public boolean isOccupied(Vector2d position)
    {
        if (objectAt(position) == null)
            return false;
        return true;
    }

    public Object objectAt(Vector2d position)
    {
        return elements.get(position);       //object at specified position or null if there is nothing
    }

    public Vector2d calculateCorrectPositionOfElement(Vector2d position)
    {
        int xPosition = position.x;
        int yPosition = position.y;

        if (xPosition < this.lowerCorner.x)
            xPosition = this.higherCorner.x + xPosition + 1;

        if (xPosition > this.higherCorner.x)
            xPosition = xPosition - this.higherCorner.x - 1;

        if (yPosition < this.lowerCorner.y)
            yPosition = this.higherCorner.x + yPosition + 1;

        if (yPosition > this.higherCorner.y)
            yPosition = yPosition - this.higherCorner.y - 1;

        return new Vector2d(xPosition, yPosition);
    }

    private ArrayList<Vector2d> fieldsAroundTarget(Vector2d target)
    {
        ArrayList<Vector2d> fields = new ArrayList<>();
        for (int x = target.x - 1; x <= target.x + 1; x++)
            for (int y = target.y - 1; y <= target.y + 1; y++)
            {
                Vector2d candidate = new Vector2d(x, y);
                if (candidate.precedes(higherCorner) && candidate.follows(lowerCorner) && x != y)
                    fields.add(candidate);
            }
        return fields;
    }

    public Vector2d findPlaceForBirth(Vector2d parentsPosition)
    {
        ArrayList<Vector2d> potentialPlaces = fieldsAroundTarget(parentsPosition);
        for (Vector2d it : potentialPlaces ) {
            if (this.isOccupied(it) && this.objectAt(it) instanceof Animal)
                potentialPlaces.remove(it);
        }
        if (potentialPlaces.size() == 0)
            potentialPlaces = fieldsAroundTarget(parentsPosition);
        return potentialPlaces.get(random.nextInt(potentialPlaces.size()));
    }

    public Vector2d getRandomEmptyPosition()
    {
        Vector2d candidate;
        do
        {
            candidate = new Vector2d(random.nextInt(this.width), random.nextInt(this.height));
        }while( !this.isOccupied(candidate) );
        return candidate;
    }

}

