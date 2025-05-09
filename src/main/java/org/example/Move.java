package org.example;

/**
 * Action that moves the player to another chamber
 */
public class Move implements Action {
    private Dungeon dungeon;
    private Door door;

    /**
     * Constructs a Move action.
     * @param door    the door to move through
     */
    public Move(Dungeon dungeon, Door door) {
        this.dungeon = dungeon;
        this.door = door;
    }

    /**
     * Executes the move action by updating the player's current chamber.
     */
    @Override
    public void execute() {
        Chamber current = dungeon.getCurrentChamber();
        Chamber next = door.getOtherChamber(current);
        dungeon.setCurrentChamber(next);
        System.out.println("You moved into the next chamber.");
    }


    @Override
    public String toString() {
        return "Move through door";
    }
}
