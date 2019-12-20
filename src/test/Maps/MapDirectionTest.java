package Maps;

import Maps.MapDirection;
import Maps.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {

    @Test
    public void testToString() {

    }

    @Test
    public void next() {
        MapDirection a = MapDirection.NORTH;
        Assert.assertEquals(MapDirection.NORTH, a);
        a = a.next();
        Assert.assertEquals(MapDirection.NORTHEAST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.EAST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.SOUTHEAST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.SOUTH, a);
        a = a.next();
        Assert.assertEquals(MapDirection.SOUTHWEST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.WEST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.NORTHWEST, a);
        a = a.next();
        Assert.assertEquals(MapDirection.NORTH, a);
    }

    @Test
    public void previous() {
        MapDirection a = MapDirection.NORTH;
        Assert.assertEquals(MapDirection.NORTH, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.NORTHWEST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.WEST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.SOUTHWEST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.SOUTH, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.SOUTHEAST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.EAST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.NORTHEAST, a);
        a = a.previous();
        Assert.assertEquals(MapDirection.NORTH, a);
    }

    @Test
    public void toUnitVector() {
        Assert.assertEquals(new Vector2d(0,1), MapDirection.NORTH.toUnitVector());
        Assert.assertEquals(new Vector2d(1,1), MapDirection.NORTHEAST.toUnitVector());
        Assert.assertEquals(new Vector2d(1,0), MapDirection.EAST.toUnitVector());
        Assert.assertEquals(new Vector2d(1,-1), MapDirection.SOUTHEAST.toUnitVector());
        Assert.assertEquals(new Vector2d(0,-1), MapDirection.SOUTH.toUnitVector());
        Assert.assertEquals(new Vector2d(-1,-1), MapDirection.SOUTHWEST.toUnitVector());
        Assert.assertEquals(new Vector2d(-1,0), MapDirection.WEST.toUnitVector());
        Assert.assertEquals(new Vector2d(-1,1), MapDirection.NORTHWEST.toUnitVector());

    }
}