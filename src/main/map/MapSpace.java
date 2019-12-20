package map;

import json.StartValues;

import java.util.ArrayList;
import java.util.Random;

public class MapSpace {
    protected int width;
    protected int height;
    protected int jungleWidth;
    protected int jungleHeight;
    protected final Vector2d higherCorner;
    protected final Vector2d lowerCorner;
    protected Vector2d jungleHigherCorner;
    protected Vector2d jungleLowerCorner;
    private static StartValues startValues = new StartValues();
    private static final Random random = new Random();

    public MapSpace()
    {
        width = startValues.getMapWidth();
        height = startValues.getMapHeight();
        this.higherCorner = new Vector2d(this.width, this.height);
        this.lowerCorner = new Vector2d(0, 0);
        if (startValues.getJungleRelationToMap() < 0 || startValues.getJungleRelationToMap() > 100)
            throw new IllegalArgumentException(startValues.getJungleRelationToMap() + " is not a proper percentage relation of size between Jungle and Map. Use value between 0 and 100");
        setJungleSize(startValues.getJungleRelationToMap());
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

    public boolean belongsToJungle(Vector2d position)
    {
        return (position.precedes(jungleHigherCorner) && position.follows(jungleLowerCorner));
    }

}
