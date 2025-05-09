package org.example;

/**
 * Wizard subcharacter in the game.
 * Wizards use magic.
 * They have high craft, low strength, and moderate health.
 */
public class Wizard extends Character {

    /**
     * Constructs a Wizard with  strength, craft, and health values.
     * Wizards have high craft (5) and low strength (2).
     */
    public Wizard(String name) {
        super(name, 2, 5, 10); // strength, craft, health
    }
}
