package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class TextUI {
    private BufferedReader reader;


    public TextUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void play(Dungeon dungeon) {
        while (!dungeon.isFinished()) {
            Chamber current = dungeon.getCurrentChamber();

            System.out.println("\nYou are in a chamber.");
            List<Door> doors = current.getDoors();
            for (int i = 0; i < doors.size(); i++) {
                Monster m = doors.get(i).getMonster();
                if (m != null && m.isAlive()) {
                    System.out.println("Door " + i + ": guarded by " + m.getName() +
                            " (Strength: " + m.getStrength() +
                            ", Craft: " + m.getCraft() +
                            ", Health: " + m.getHealth() + ")");
                } else {
                    System.out.println("Door " + i + ": unguarded");
                }
            }

            List<Action> actions = dungeon.getActions();
            System.out.println("\nChoose an action:");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(i + ": " + actions.get(i));
            }

            Action action;
            try {
                int choice = Integer.parseInt(reader.readLine());
                action = actions.get(choice);
            } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
                action = new InputError();
            }

            action.execute();
        }

        System.out.println("\nGame over.");
        if (dungeon.getCurrentChamber() == dungeon.getCurrentChamber() && dungeon.getPlayer().isAlive()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose.");
        }
    }
}
