package element;


import Maps.Vector2d;

/**
 * The interface responsible for methods in elements on the map
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */

public interface IMapElement  {
    /**
     * getting position of the element
     * @return Vector2D position on the map of this element
     */
    Vector2d getPosition();

    /**
     * Parse this element to string in readable form of this obcject
     * @return string describing this element
     */
    String toString();

    /**
     * Move element on the map
     */
    void move();


}
