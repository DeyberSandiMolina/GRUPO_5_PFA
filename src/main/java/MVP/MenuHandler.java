package MVP;

import MVP.GameFunctions.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuHandler {

    private final Scanner scanner=new Scanner(System.in);
    private final Game game=new Game();
    private final Help help=new Help();

    public MenuHandler() {
    }

    /**
     * Starts the menu loop, displaying options to the user and handling their input.
     * This method runs indefinitely until the user chooses to exit.
     *
     * @author Lorenzo
     * STILL DEVELOPING
     */
    public void start() {
        while (true) {
             
            System.out.println("\n=== MVP RACING GAME ===");
            System.out.println("1. Play game(4 players required)");
            System.out.println("2. Help");
            System.out.println("3. Exit\n");

            int input = getUserInput();
            scanner.nextLine();

            switch (input) {
                case 1:
                    game.gameStart();
                    break;
                case 2:
                    System.out.println(help.displayHelp());
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Prompts the user to enter an integer input for menu selection, ensuring the input is valid.
     * The valid input is an integer between 1 and 2.
     *
     * @return the valid integer input from the user
     * @author Lorenzo
     */

    private int getUserInput() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter an integer selecting the option: ");
                input = scanner.nextInt();
                if (input >= 1 && input <= 3) {
                    validInput = true;
                } else {
                    System.out.println(
                            "Invalid input. Please enter a valid integer between " +
                                    1 +
                                    " and " +
                                    3 +
                                    "."
                    );
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input. Please enter a valid integer between " +
                                1 +
                                " and " +
                                3 +
                                "."
                );
                scanner.nextLine();
            }
        }

        return input;
    }
}
