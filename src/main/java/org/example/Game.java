package org.example;

/**
 * Main class that sets up the game and starts it.
 */
public class Game {
    public static void main(String[] args) {
        // Create chambers
        Chamber[] chambers = new Chamber[] {
                new Chamber(),
                new Chamber(new Axe()),
                new Chamber(new Shield()),
                new Chamber(),
                new Chamber()
        };

        // Connect chambers with doors (some guarded by monsters)
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Troll", 1, 0, 3));
        Door.connect(chambers[2], chambers[3], new Monster("Spider", 0, 3, 5));
        Door.connect(chambers[3], chambers[4]);

        // Create the player (can also try Warrior if you made it)
        Character player = new Wizard("Mike");

        // Create dungeon with player, start chamber, and goal chamber
        Dungeon dungeon = new Dungeon(player, chambers[0], chambers[4]);

        // Start the game using TextUI
        TextUI ui = new TextUI();
        ui.play(dungeon);
    }
}
