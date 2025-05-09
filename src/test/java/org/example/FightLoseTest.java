package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Sad path test: Player loses to a strong monster.
 */
public class FightLoseTest {

    @Test
    public void testPlayerLosesFight() {
        // Create a weak player (no weapon)
        Character player = new Wizard("WeakWizard");

        // Create a strong monster with high health and strength
        Monster strongMonster = new Monster("Dragon", 6, 0, 20);
        Door dummyDoor = new Door(new Chamber(), new Chamber(), strongMonster);

        // Execute fight
        Fight fight = new Fight(player, strongMonster, dummyDoor);
        fight.execute();

        // Assertions (sad path)
        assertFalse(player.isAlive(), "Player should lose and be defeated.");
    }
}
