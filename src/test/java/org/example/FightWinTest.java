package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Happy path test: Player defeats a monster
 */
public class FightWinTest {

    @Test
    public void testPlayerWinsFight() {
        // Create a player with a weapon
        Character player = new Wizard("TestWizard");
        player.pickUpItem(new Axe());
        player.equipItem(new Axe());

        // Create a weak monster
        Monster weakMonster = new Monster("Goblin", 1, 0, 2);

        // Connect the monster to a dummy door
        Door dummyDoor = new Door(new Chamber(), new Chamber(), weakMonster);

        // Execute fight
        Fight fight = new Fight(player, weakMonster, dummyDoor);
        fight.execute();

        // Assertions (happy path)
        assertTrue(player.isAlive(), "Player should survive the fight.");
        assertFalse(weakMonster.isAlive(), "Monster should be defeated.");
    }
}
