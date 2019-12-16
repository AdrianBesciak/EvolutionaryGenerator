package map;

import java.util.ArrayList;
import java.util.Random;

public class MapSpace {
    private int width;
    private int height;
    protected final Vector2d higherCorner;
    protected final Vector2d lowerCorner;
    protected Vector2d jungleHigherCorner;
    protected Vector2d jungleLowerCorner;
    private static final Random random = new Random();

    public MapSpace(int width, int height, int jungleRelation)
    {
        this.width = width;
        this.height = height;
        this.higherCorner = new Vector2d(width, height);
        this.lowerCorner = new Vector2d(0, 0);
        if (jungleRelation < 0 || jungleRelation > 100)
            throw new IllegalArgumentException(jungleRelation + " is not a proper percentage relation of size between Jungle and Map. Use value between 0 and 100");
        setJungleSize(jungleRelation);
    }

    private void setJungleSize(int proportion)
    {
        int jungleWidth = this.width * proportion / 100;
        int jungleHeight = this.height * proportion / 100;
        this.jungleHigherCorner = new Vector2d(this.width / 2 + jungleWidth / 2, this.height / 2 + jungleHeight / 2);
        this.jungleLowerCorner = new Vector2d(this.width / 2 - jungleWidth / 2, this.height / 2 - jungleHeight / 2);
    }

    public Vector2d getJungleHigherCorner(){return jungleHigherCorner;}

    public Vector2d getJungleLowerCorner(){return jungleLowerCorner;}

}
