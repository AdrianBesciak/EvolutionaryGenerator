package Maps;

import Maps.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {


    @Test
    public void testToString() {
        int x = 5;
        int y = 5;
        Vector2d a = new Vector2d(x, y);
        Assert.assertEquals("(5,5)", a.toString());
    }

    @Test
    public void precedes() {
        Vector2d lower = new Vector2d(3,3);
        Vector2d higher = new Vector2d(4, 4);
        Vector2d higherEqual = new Vector2d(4, 3);
        Vector2d higherEqual2 = new Vector2d(3, 4);
        Assert.assertFalse(higher.precedes(lower));
        Assert.assertTrue(lower.precedes(higher));
        Assert.assertTrue(lower.precedes(higherEqual));
        Assert.assertTrue(lower.precedes(higherEqual2));
        Assert.assertFalse(higherEqual.precedes(lower));
        Assert.assertFalse(higherEqual2.precedes(lower));
    }

    @Test
    public void follows() {
        Vector2d lower = new Vector2d(3,3);
        Vector2d higher = new Vector2d(4, 4);
        Vector2d lowerEqual = new Vector2d(4, 3);
        Vector2d lowerEqual2 = new Vector2d(3, 4);
        Assert.assertTrue(higher.follows(lower));
        Assert.assertFalse(lower.follows(higher));
        Assert.assertFalse(lower.follows(lowerEqual));
        Assert.assertFalse(lower.follows(lowerEqual2));
        Assert.assertTrue(lowerEqual.follows(lower));
        Assert.assertTrue(lowerEqual2.follows(lower));
    }

    @Test
    public void upperRight() {
        Vector2d a = new Vector2d(3,8);
        Vector2d b = new Vector2d(8, 3);
        Vector2d expected = new Vector2d(8, 8);
        Assert.assertEquals(expected, a.upperRight(b));
    }

    @Test
    public void lowerLeft() {
        Vector2d a = new Vector2d(3,8);
        Vector2d b = new Vector2d(8, 3);
        Vector2d expected = new Vector2d(3, 3);
        Assert.assertEquals(expected, a.lowerLeft(b));
    }

    @Test
    public void add() {
        Vector2d a = new Vector2d(3,8);
        Vector2d b = new Vector2d(2, 3);
        Vector2d expected = new Vector2d(5, 11);
        Assert.assertEquals(expected, a.add(b));
    }

    @Test
    public void subtract() {
        Vector2d a = new Vector2d(3,8);
        Vector2d b = new Vector2d(2, 3);
        Vector2d expected = new Vector2d(1, 5);
        Assert.assertEquals(expected, a.subtract(b));
    }

    @Test
    public void testEquals() {
        Vector2d a = new Vector2d(3,8);
        Vector2d other = new Vector2d(2, 3);
        Vector2d equal = new Vector2d(3, 8);
        Assert.assertTrue(a.equals(equal));
        Assert.assertFalse(a.equals(other));
    }

    @Test
    public void opposite() {
        Vector2d a = new Vector2d(3, 5);
        Vector2d expected = new Vector2d(-3, -5);
        Assert.assertEquals(expected, a.opposite());
    }
}