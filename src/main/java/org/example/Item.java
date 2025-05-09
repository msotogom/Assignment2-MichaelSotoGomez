package org.example;

/**
 * Item Interface
 */
public interface Item {

    /**
     * Gets the item's strength bonus.
     * @return Strength bonus from item.
     */
    int getStrength();

    /**
     * Gets the item's craft bonus.
     * @return the craft value from item
     */
    int getCraft();

    /**
     * Gets the name of item
     *
     * @return the name of the item
     */
    String getName();
}
