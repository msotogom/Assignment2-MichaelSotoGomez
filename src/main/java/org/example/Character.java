package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Characters class that has health, strength, craft, and can hold and equip items.
 * This class is extended character types Wizard or Warrior.
 */
public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int craft;
    protected List<Item> inventory;
    protected List<Item> equipped;

    /**
     * Constructs a new character with base stats and empty inventory.
     *
     * @param name     the name of the character
     * @param strength the base strength value
     * @param craft    the base craft value
     * @param health   starting health
     */
    public Character(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.inventory = new ArrayList<>();
        this.equipped = new ArrayList<>();
    }

    /**
     * Returns true if the character health is above zero.
     *
     * @return true if alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Reduces the character's health by the specified damage value.
     *
     * @param damage how much damage to apply
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }


    /**
     * Adds an item to the character's inventory.
     *
     * @param item the item
     */
    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    /**
     * Equips an item from the inventory if there's a free hand.
     *
     * @param item the item to equip
     */
    public void equipItem(Item item) {
        if (equipped.size() < 2 && inventory.contains(item)) {
            equipped.add(item);
        }
    }

    /**
     * Gets the total strength including base and equipped items.
     *
     * @return total strength
     */
    public int getTotalStrength() {
        int total = strength;
        for (Item item : equipped) {
            total += item.getStrength();
        }
        return total;
    }

    /**
     * Gets the total craft (Special stat based on class and gear).
     *
     * @return total craft
     */
    public int getTotalCraft() {
        int total = craft;
        for (Item item : equipped) {
            total += item.getCraft();
        }
        return total;
    }

    /**
     * Randomized combat score that will be used for fighting
     *
     * @return total combat score
     */
    public int rollCombatScore(boolean useStrength) {
        int roll = new Random().nextInt(6) + 1;
        int stat = useStrength ? getTotalStrength() : getTotalCraft();
        return roll + stat;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Item> getEquipped() {
        return equipped;
    }
}
