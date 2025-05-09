package org.example;

/**
 * Axe item
 * +2 strength.
 */
public class Axe implements Item {

    /**
     * Returns the strength bonus from the Axe.
     */
    @Override
    public int getStrength() {
        return 2;
    }

    /**
     * Returns the craft bonus from the Axe (+0).
     */
    @Override
    public int getCraft() {
        return 0;
    }

    /**
     * Gets the name of this item.
     * @return "Axe"
     */
    @Override
    public String getName() {
        return "Axe";
    }
}
