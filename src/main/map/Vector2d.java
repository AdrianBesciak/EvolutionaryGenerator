package map;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d()
    {
        x = 0;
        y = 0;
    }

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other)
    {
        if (this.x <= other.x && this.y <= other.y)
            return true;
        return false;
    }

    public boolean follows(Vector2d other)
    {
        if (this.x >= other.x && this.y >= other.y)
            return true;
        return false;
    }

    public Vector2d upperRight(Vector2d other)
    {
        Vector2d result = new Vector2d(Math.max(this.x, other.x),Math.max(this.y, other.y));
        return  result;
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        Vector2d result = new Vector2d(Math.min(this.x, other.x),Math.min(this.y, other.y));
        return  result;
    }

    public Vector2d add(Vector2d other)
    {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other)
    {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other)
    {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d temp = (Vector2d) other;
        return this.x == temp.x && this.y == temp.y;
    }

    public int hashCode()
    {
        int hash = 13;
        hash += this.x * 31;
        hash +=this.y * 17;
        return hash;
    }

    public Vector2d opposite()
    {
        return new Vector2d(-1 * this.x, -1 * this.y);
    }

}
