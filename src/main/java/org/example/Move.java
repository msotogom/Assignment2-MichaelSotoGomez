package org.example;

/**
 * Action that moves the player to another chamber through a door,
 */
public class Move implements Action {
    private Dungeon dungeon;
    private Door door;

    /**
     * Constructs a Move action.
     *
     * @param dungeon the dungeon
     * @param door    the door
     */
    public Move(Dungeon dungeon, Door door) {
        this.dungeon = dungeon;
        this.door = door;
    }

    /**
     * Executes the move action. Player can only move if the door is unguarded or the monster fight is won
     */
    @Override
    public void execute() {
        Monster monster = door.getMonster();
        if (monster != null && monster.isAlive()) {
            System.out.println("You can't move through this door. It's still guarded by a monster!");
            return;
        }

        Chamber current = dungeon.getCurrentChamber();
        Chamber next = door.getOtherChamber(current);
        dungeon.setCurrentChamber(next);
        System.out.println("You moved into the next chamber.");
    }

    /**
     * Describes this action.
     * @return action name
     */
    @Override
    public String toString() {
        return "Move through door";
    }
}
