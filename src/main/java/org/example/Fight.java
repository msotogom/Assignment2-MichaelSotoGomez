package org.example;

import java.util.Random;

/**
 * Action that allows the player to fight a monster at a door
 */
public class Fight implements Action {
    private Character player;
    private Monster monster;
    private Door door;

    /**
     * Constructs a Fight action.
     * @param player  the player figthing
     * @param monster the monster being fought
     * @param door    the door the monster is guarding
     */
    public Fight(Character player, Monster monster, Door door) {
        this.player = player;
        this.monster = monster;
        this.door = door;
    }

    /**
     * rolls combat scores, applies damage, and checks if the monster is defeated.
     */
    @Override
    public void execute() {
        boolean useStrength = monster.getCraft() == 0;
        int playerScore = player.rollCombatScore(useStrength);
        int monsterScore = monster.rollCombatScore();

        System.out.println("Fight begins! You rolled " + playerScore + ". Monster rolled " + monsterScore + ".");

        int damage = Math.abs(playerScore - monsterScore);
        if (playerScore > monsterScore) {
            monster.takeDamage(damage);
            System.out.println("You hit the monster for " + damage + " damage!");
            if (!monster.isAlive()) {
                door.clearMonster();
                System.out.println("The monster is defeated!");
            }
        } else {
            player.takeDamage(damage);
            System.out.println("The monster damages you for " + damage + " damage!");
            if (!player.isAlive()) {
                System.out.println("You have been defeated.");
            }
        }
    }

    /**
     * Describes fight
     * @return fight string
     */
    @Override
    public String toString() {
        return "Fight monster: " + monster.getName();
    }
}
