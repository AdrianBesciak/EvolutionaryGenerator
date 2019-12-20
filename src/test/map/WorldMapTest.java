package map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Tests are prepared for StartValues:
 *      private int energyOnStart = 100;
 *      private int mapWidth = 100;
 *      private int mapHeight = 100;
 *      private int jungleRelationToMap = 40;
 */

public class WorldMapTest {

    @Test
    public void getRandomEmptyPosition() {
        WorldMap map  = new WorldMap();
        for (int i = 0; i < 10; i++)
        {
            Vector2d received = map.getRandomJunglePosition();
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
}
