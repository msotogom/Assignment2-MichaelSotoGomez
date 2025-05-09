package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chamber in the dungeon
 * Can contain items and other doors.
 */
public class Chamber {
    private List<Item> items;
    private List<Door> doors;

    /**
     * Creates a chamber with no items or doors.
     */
    public Chamber() {
        this.items = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    /**
     * Creates a chamber with one item.
     *
     */
    public Chamber(Item item) {
        this();
        items.add(item);
    }

    /**
     * Adds an item to the chamber's item count.
     *
     * @param item item being added
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Adds a door to the chamber.
     */
    public void addDoor(Door door) {
        doors.add(door);
    }

    /**
     * Gets the list of items in this chamber.
     * @return a list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Gets the list of doors connected to this chamber.
     * @return a list of Door objects
     */
    public List<Door> getDoors() {
        return doors;
    }
}
