package map;

import java.util.Random;

public enum MapDirection {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST;

    private final int countOfDirections = 8;
    private static final Random random = new Random();

    public String toString(){
        switch (this)
        {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTHEAST:
                return  "Północny-wschód";
            case NORTHWEST:
                return "Północny-zachód";
            case SOUTHEAST:
                return "Południowy-wschód";
            case SOUTHWEST:
                return "Południowy-zachód";
            default:
                return  null;
        }
    }
    public MapDirection next()
    {
        MapDirection[] dir = MapDirection.values();
        return dir[(this.ordinal() + 1) % dir.length];
    }

    public MapDirection previous()
    {
        MapDirection[] dir = MapDirection.values();
        int res = this.ordinal() - 1;
        if (res == -1)
            res = dir.length-1;
        return dir[res];
    }

    public Vector2d toUnitVector()
    {
        switch (this)
        {
            case NORTH:
                return new Vector2d(0, 1);
            case EAST:
                return new Vector2d(1, 0);
            case SOUTH:
                return new Vector2d(0, -1);
            case WEST:
                return new Vector2d(-1, 0);
            case SOUTHWEST:
                return new Vector2d(-1,-1);
            case SOUTHEAST:
                return new Vector2d(1, -1);
            case NORTHWEST:
                return new Vector2d(-1, 1);
            case NORTHEAST:
                return new Vector2d(1, 1);
            default:
                return new Vector2d(0,0);

        }
    }

    public MapDirection getFirstOrientation()
    {
        MapDirection[] dir = MapDirection.values();
        return dir[random.nextInt(countOfDirections)];
    }

}
