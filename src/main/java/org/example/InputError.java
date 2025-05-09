package org.example;

/**
 * Action that handles invalid user input during the game.
 */
public class InputError implements Action {
    /**
     * Constructs an InputError action.
     */
    public InputError() {
        // No need to store anything
    }

    /**
     * Executes the error-handling action by printing invalid input
     */
    @Override
    public void execute() {
        System.out.println("Invalid input. Please try again.");
    }
}
