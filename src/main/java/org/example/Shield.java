package org.example;

/**
 * Shield Item
 * +1 strength and +1 craft.
 */
public class Shield implements Item {

    /**
     * Returns the strength bonus from the Shield.
     */
    @Override
    public int getStrength() {
        return 1;
    }

    /**
     * Returns the craft bonus from the Shield.
     */
    @Override
    public int getCraft() {
        return 1;
    }

    /**
     * Gets the name of this item.
     */
    @Override
    public String getName() {
        return "Shield";
    }
}
