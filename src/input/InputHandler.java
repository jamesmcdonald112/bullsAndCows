package input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The InputHandler class is responsible for handling all user inputs,
 * including prompting for code length, number of symbols, and user guesses.
 */
public class InputHandler {

    /**
     * Prints a prompt asking the user to enter the length of the password.
     */
    public static void printCodeSizePrompt() {
        System.out.println("Enter the length of the password:");
    }

    /**
     * Reads the code length input from the user.
     * Repeatedly prompts the user until a valid integer is entered.
     *
     * @param scanner the Scanner object to read user input
     * @return the valid code length entered by the user
     */
    public static int readCodeSize(Scanner scanner) {
        int passwordSize = -1;
        while (passwordSize == -1) {
            try {
                passwordSize = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Error: Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return passwordSize;
    }

    /**
     * Prints a prompt asking the user to enter the number of possible symbols in the code.
     */
    public static void printSymbolSizePrompt() {
        System.out.println("Input the number of possible symbols in the code: ");
    }

    /**
     * Reads the number of symbols input from the user.
     * Repeatedly prompts the user until a valid integer is entered.
     *
     * @param scanner the Scanner object to read user input
     * @return the valid number of symbols entered by the user
     */
    public static int readSymbolSize(Scanner scanner) {
        int numberOfSymbols = -1;
        while (numberOfSymbols == -1) {
            try {
                numberOfSymbols = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Error: Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return numberOfSymbols;
    }

    /**
     * Prompts the user to enter their guess for the secret code.
     *
     * @param scanner the Scanner object to read user input
     * @return the user's guess as a string
     */
    public static String getUserGuess(Scanner scanner) {
        System.out.println("Enter your guess: ");
        return scanner.next();
    }
}
