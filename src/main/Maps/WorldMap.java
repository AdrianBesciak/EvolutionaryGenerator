package Maps;

import element.Animal;
import element.IMapElement;
import element.Tree;

import java.util.*;

public class WorldMap extends MapSpace implements IWorldMap {
    private Map<Vector2d, ArrayList<IMapElement>> elements = new HashMap<>();
    private ArrayList<IMapElement> objectsOnTheMap = new ArrayList<>();
    private static final Random random = new Random();

    public WorldMap()
    {
        super();
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++)
                elements.put(new Vector2d(i, j), new ArrayList<IMapElement>());
    }

    public void place(IMapElement elem)
    {
        elements.get(elem.getPosition()).add(elem);
        objectsOnTheMap.add(elem);
    }

    public boolean isOccupied(Vector2d position)
    {
        if (listOfObjectsAt(position).size() == 0)
            return false;
        return true;
    }

    public ArrayList<IMapElement> listOfObjectsAt(Vector2d position)
    {
        return elements.get(position);
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

    public boolean onlyAnimalsAt (ArrayList<IMapElement> list)
    {
        for (IMapElement it: list ) {
            if ( !(it instanceof Animal))
                return false;
        }
        return true;
    }

    public Vector2d findPlaceForBirth(Vector2d parentsPosition)
    {
        ArrayList<Vector2d> potentialPlaces = fieldsAroundTarget(parentsPosition);
        for (int i = 0; i < potentialPlaces.size(); i++)
        {
            if (this.isOccupied(potentialPlaces.get(i)) && this.onlyAnimalsAt(listOfObjectsAt(potentialPlaces.get(i))) )
                potentialPlaces.remove(potentialPlaces.get(i));
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
        }while( this.isOccupied(candidate) );

        return candidate;
    }

    public Vector2d getRandomJunglePosition()
    {
        int i = jungleHeight * jungleWidth;
        Vector2d candidate;
        do{
            candidate = new Vector2d(random.nextInt(jungleWidth), random.nextInt(jungleHeight));
            candidate = candidate.add(jungleLowerCorner);
            i--;
            if (i == 0)
                return null;
        }while( this.isOccupied(candidate) );
        return candidate;
    }

    public Vector2d getRandomNonJunglePosition()
    {
        int i = 0;
        Vector2d candidate;
        do{
            candidate = new Vector2d(random.nextInt(this.width), random.nextInt(this.height));
            i--;
            if (i == 0)
                return null;
        }while( this.isOccupied(candidate) || this.belongsToJungle(candidate));

        return candidate;
    }

    public void makeFuneral()
    {
        ArrayList<IMapElement> deathNote = new ArrayList<>();
        for (IMapElement it : objectsOnTheMap ) {
            if ( it.getEnergyLevel() <= 0 )
            {
                deathNote.add(it);
            }
        }

        for (IMapElement it : deathNote)
        {
            elements.get(it.getPosition()).remove(it);
            objectsOnTheMap.remove(it);
        }
    }

    public void moveAnimals()
    {
        for (IMapElement it : objectsOnTheMap ) {
            if ( !(it instanceof Tree) )
            {
                Vector2d oldPosition = it.getPosition();
                it.move();
                Vector2d newPosition = it.getPosition();
                if (elements.get(newPosition) == null)
                    elements.put(newPosition, new ArrayList<IMapElement>());

                elements.get(newPosition).add(it);

                elements.get(oldPosition).remove(it);

            }

        }
    }

    public void feedAnimals()
    {
        for (IMapElement it : objectsOnTheMap)
        {
            if (it instanceof Tree && elements.get(it.getPosition()).size() > 1 )
            {
                Tree temp = (Tree) it;
                temp.eatTree(elements.get(it.getPosition()));
            }
        }
    }

    public void reproduction()
    {
        ArrayList<Vector2d> reproductionList = new ArrayList<>();
        for (int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                if ( elements.get(new Vector2d(i, j)).size() > 1 )
                    reproductionList.add(new Vector2d(i, j));
            }
        }

        for (Vector2d position : reproductionList)
        {
            Animal first = null;
            Animal second = null;
            for (IMapElement animal : elements.get(position) ) {
                if (first == null)
                    first = (Animal) animal;
                else if (second == null)
                {
                    if (animal.getEnergyLevel() < first.getEnergyLevel())
                        second = (Animal) animal;
                    else
                    {
                        second = first;
                        first = (Animal) animal;
                    }
                }
                else
                {
                    if (animal.getEnergyLevel() > first.getEnergyLevel())
                    {
                        second = first;
                        first = (Animal) animal;
                    } else if (animal.getEnergyLevel() > second.getEnergyLevel())
                    {
                        second = (Animal) animal;
                    }
                }
            }
            this.place(new Animal(this, first, second));
        }
    }

}

