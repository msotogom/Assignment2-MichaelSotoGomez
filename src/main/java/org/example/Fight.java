package org.example;

import java.util.Random;

/**
 * Action that lets the player fight a monster guarding a door.
 */
public class Fight implements Action {
    private Character player;
    private Monster monster;
    private Door door;

    /**
     * Constructs a Fight action.
     *
     * @param player  the player
     * @param monster the monster
     * @param door    the door being guarded
     */
    public Fight(Character player, Monster monster, Door door) {
        this.player = player;
        this.monster = monster;
        this.door = door;
    }

    /**
     * Executes a full fight loop between the player and monster.
     */
    @Override
    public void execute() {
        boolean useStrength = monster.getCraft() == 0;

        System.out.println("Combat begins against " + monster.getName() + "!");

        while (player.isAlive() && monster.isAlive()) {
            int playerScore = player.rollCombatScore(useStrength);
            int monsterScore = monster.rollCombatScore();

            System.out.println("You rolled: " + playerScore);
            System.out.println(monster.getName() + " rolled: " + monsterScore);

            int damage = Math.abs(playerScore - monsterScore);
            if (playerScore > monsterScore) {
                monster.takeDamage(damage);
                System.out.println("You hit the monster for " + damage + " damage!");
            } else if (monsterScore > playerScore) {
                player.takeDamage(damage);
                System.out.println("The monster hits you for " + damage + " damage!");
            } else {
                System.out.println("Both attacks miss!");
            }

            System.out.println("Your health: " + player.getHealth());
            System.out.println(monster.getName() + "'s health: " + monster.getHealth());
            System.out.println();
        }

        if (!monster.isAlive()) {
            door.clearMonster();
            System.out.println("You defeated the monster!");
        }

        if (!player.isAlive()) {
            System.out.println("You have been defeated.");
        }
    }


    @Override
    public String toString() {
        return "Fight monster: " + monster.getName();
    }
}
