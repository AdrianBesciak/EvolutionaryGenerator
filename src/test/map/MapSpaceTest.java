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

public class MapSpaceTest {


    @Test
    public void getJungleHigherCorner() {
        MapSpace map = new MapSpace();
        Assert.assertEquals(new Vector2d(70,70), map.getJungleHigherCorner());
    }

    @Test
    public void getJungleLowerCorner() {
        MapSpace map = new MapSpace();
        Assert.assertEquals(new Vector2d(30,30), map.getJungleLowerCorner());
    }

    @Test
    public void belongsToJungle() {
        MapSpace map = new MapSpace();
        Assert.assertFalse(map.belongsToJungle(new Vector2d(10,10)));
        Assert.assertTrue(map.belongsToJungle(new Vector2d(50,50)));
        Assert.assertTrue(map.belongsToJungle(new Vector2d(70,70)));
        Assert.assertTrue(map.belongsToJungle(new Vector2d(30,30)));
        Assert.assertFalse(map.belongsToJungle(new Vector2d(71,71)));
        Assert.assertFalse(map.belongsToJungle(new Vector2d(29,29)));
    }
}
