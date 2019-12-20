package map;

import map.element.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Tests are prepared for StartValues:
 *      private int energyOnStart = 100;
 *      private int mapWidth = 100;
 *      private int mapHeight = 100;
 *      private int jungleRelationToMap = 40;
 */

public class WorldMapTest {
    private static final Random random = new Random();


    @Test
    public void getRandomEmptyPosition() {
        WorldMap map  = new WorldMap();
        for (int i = 0; i < 10; i++)
        {
            Vector2d received = map.getRandomEmptyPosition();
            Assert.assertTrue(received.follows(map.lowerCorner) && received.precedes(map.higherCorner) && !map.isOccupied(received));
        }

    }

    @Test
    public void getRandomJunglePosition() {
        WorldMap map = new WorldMap();
        for (int i = 0; i < 10; i++)
        {
            Vector2d received = map.getRandomJunglePosition();
            Assert.assertTrue(received.follows(map.jungleLowerCorner) && received.precedes(map.jungleHigherCorner) && !map.isOccupied(received));
        }
    }

    @Test
    public void getRandomNonJunglePosition() {
        WorldMap map = new WorldMap();
        for (int i = 0; i < 10; i++)
        {
            Vector2d received = map.getRandomNonJunglePosition();
            Assert.assertTrue(!( received.follows(map.jungleLowerCorner) && received.precedes(map.jungleHigherCorner) )/* && !map.isOccupied(received)*/);
        }
    }


    @Test
    public void isOccupied() {
        WorldMap map = new WorldMap();
        IMapElement first = new Animal(map);
        map.place(first);
        Assert.assertTrue(map.isOccupied(first.getPosition()));
        Vector2d temp = map.getRandomEmptyPosition();
        Assert.assertFalse(map.isOccupied(temp));
    }

    @Test
    public void listOfObjectsAt() {
        WorldMap map = new WorldMap();
        IMapElement first = new Animal(map);
        map.place(first);
        Assert.assertTrue(map.listOfObjectsAt(first.getPosition()).size() == 1);
        Assert.assertTrue(map.listOfObjectsAt(map.getRandomEmptyPosition()).size() == 0);
    }
}
