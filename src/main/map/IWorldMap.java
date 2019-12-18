package map;

import map.animal.Animal;

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
     * Place a animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    boolean place(Animal animal);

    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     * @param directions
     *            Array of move directions.
     */
    void run(MoveDirection[] directions);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector2d position);

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
     * Returns a value of the energy that first animals has at the beginnig of the simulation.
     * @return
     */
    int getStartEnergy();

}