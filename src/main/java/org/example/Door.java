package org.example;

/**
 * Represents a door that connects two chambers.
 * A door may be guarded by a monster.
 */
public class Door {
    private Chamber chamberA;
    private Chamber chamberB;
    private Monster monster;

    public Door(Chamber a, Chamber b, Monster monster) {
        this.chamberA = a;
        this.chamberB = b;
        this.monster = monster;
        a.addDoor(this);
        b.addDoor(this);
    }

    /**
     * Connects two chambers with an unguarded door.
     * @param a one chamber
     * @param b the other chamber
     */
    public static void connect(Chamber a, Chamber b) {
        new Door(a, b, null);
    }

    /**
     * Connects two chambers with a door with a monster
     *
     * @param a       one chamber
     * @param b       the other chamber
     * @param monster the monster
     */
    public static void connect(Chamber a, Chamber b, Monster monster) {
        new Door(a, b, monster);
    }

    /**
     * Gets the chamber on the opposite side.
     */
    public Chamber getOtherChamber(Chamber current) {
        return (current == chamberA) ? chamberB : chamberA;
    }

    /**
     * Returns the monster guarding this door (null if no monster).
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Removes the monster after defeat.
     */
    public void clearMonster() {
        monster = null;
    }
}
