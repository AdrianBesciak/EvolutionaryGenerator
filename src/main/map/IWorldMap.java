package map;

import map.element.Animal;

import java.util.ArrayList;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 * @modified by adrian_besciak
 *
 */
public interface IWorldMap {

    /**
     * Place a animal or tree on the map.
     *
     * @param animal
     *            The animal to place on the map.
     *
     */
    void place(IMapElement animal);

    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     * @param directions
     *            Array of move directions.
     */

    boolean isOccupied(Vector2d position);

    /**
     * Return an list of objects at a given position.
     *
     * @param position
     *            The position of the object.
     * @return ArrayList of objects
     */
    ArrayList<IMapElement> listOfObjectsAt(Vector2d position);

    /**
     * Return a correct position of animal after movement, especially if the animal is out of map, this method moves animal to the opposite side of the map
     *
     * @param position
     * @return
     */
    Vector2d calculateCorrectPositionOfElement(Vector2d position);


    /**
     * Return place where child can appear
     * @param parentsPosition
     *          The position of the parents
     * @return
     */
    Vector2d findPlaceForBirth(Vector2d parentsPosition);

    /**
     * Return an empty position, where we can place new animal.
     * @return
     */
    Vector2d getRandomEmptyPosition();

    /**
     * Return an empty position to place a tree in a Jungle
     * @return
     */
    Vector2d getRandomJunglePosition();

    /**
     * Return an empty position to place a tree outside a Jungle
     * @return
     */
    Vector2d getRandomNonJunglePosition();


}