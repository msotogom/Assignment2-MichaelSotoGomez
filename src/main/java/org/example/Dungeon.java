package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *Builds dungeon level
 */
public class Dungeon {
    private Character player;
    private Chamber current;
    private Chamber goal;

    /**
     * Constructs a dungeon with the player, start chamber, and goal chamber.
     *
     * @param player  the player
     * @param current the starting chamber
     * @param goal    the final chamber/ exit
     */
    public Dungeon(Character player, Chamber current, Chamber goal) {
        this.player = player;
        this.current = current;
        this.goal = goal;
    }

    /**
     * Checks whether the player has reached the goal.
     * @return true if the game is finished
     */
    public boolean isFinished() {
        return current == goal || !player.isAlive();
    }

    /**
     * Gets the player's current chamber.
     * @return the current chamber
     */
    public Chamber getCurrentChamber() {
        return current;
    }

    /**
     * Sets the player's new current chamber
     */
    public void setCurrentChamber(Chamber next) {
        this.current = next;
    }

    /**
     * Gets the player character.
     * @return the player
     */
    public Character getPlayer() {
        return player;
    }

    /**
     * Returns a list of possible actions for the game
     * @return list of available actions
     */
    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();

        // Pick up all items (if any)
        for (Item item : current.getItems()) {
            actions.add(new Pick(player, item));
        }

        // Add movement/fight actions for each door
        for (Door door : current.getDoors()) {
            Monster m = door.getMonster();
            if (m != null && m.isAlive()) {
                actions.add(new Fight(player, m, door));
            } else {
                actions.add(new Move(this, door));
            }
        }

        return actions;
    }
}
