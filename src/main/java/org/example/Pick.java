package org.example;

/**
 * Action that allows the player to pick up an item
 */
public class Pick implements Action {
    private Character player;
    private Item item;

    /**
     * Constructs a Pick action for player and item
     * @param player the player
     * @param item   the item being pickled up
     */
    public Pick(Character player, Item item) {
        this.player = player;
        this.item = item;
    }

    /**
     * Executes the action: picks up the item and adds it to the player's inventory.
     */
    @Override
    public void execute() {
        player.pickUpItem(item);
        System.out.println(player.getName() + " picked up a " + item.getName());
    }

    /**
     * Returns a string describing the action.
     */
    @Override
    public String toString() {
        return "Pick up " + item.getName();
    }
}
