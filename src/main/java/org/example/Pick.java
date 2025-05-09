package org.example;

/**
 * Action to pick up an item from the current chamber.
 */
public class Pick implements Action {
    private Character player;
    private Item item;
    private Dungeon dungeon;


    public Pick(Character player, Item item, Dungeon dungeon) {
        this.player = player;
        this.item = item;
        this.dungeon = dungeon;
    }

    @Override
    public void execute() {
        player.pickUpItem(item);
        dungeon.getCurrentChamber().getItems().remove(item);
        System.out.println(player.getName() + " picked up a " + item.getName());
    }

    @Override
    public String toString() {
        return "Pick up " + item.getName();
    }
}
