package org.example;

import java.util.Random;

/**
 * Monster character in the dungeon
 * A monster has either strength or craft.
 */
public class Monster {
    private String name;
    private int strength;
    private int craft;
    private int health;
    private Random random;

    /**
     * Constructs a monster with either strength or craft, but not both.
     *
     * @param name     the type of monster
     * @param strength monster strength
     * @param craft    the monster's craft
     * @param health   the monster's health
     */
    public Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.random = new Random();
    }

    /**
     * Returns true if the monster is above 0.
     *
     * @return true if alive, false if defeated
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Reduces the monster's health by the damage.
     *
     * @param damage amount of health to subtract
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     *Simulated dice roll for combat score + strength or crafts.
     * @return total combat value
     */
    public int rollCombatScore() {
        int roll = random.nextInt(6) + 1;
        int stat = (strength > 0) ? strength : craft;
        return roll + stat;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getCraft() {
        return craft;
    }
}
