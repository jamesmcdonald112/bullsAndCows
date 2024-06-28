package game;


import exception.InvalidNumberOfSymbolsException;
import exception.InvalidPasswordLengthException;
import input.InputHandler;
import util.CodeGenerator;
import util.OutputUtil;
import util.ValidationUtil;

import java.util.Scanner;

/**
 * The Game class represents the Bulls and Cows game.
 * It handles the game logic, user input, and manages the game state.
 */

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    // INSTANCE VARIABLES
    private int codeLength;
    private int numberOfSymbols;
    private String secretCode;

    // GETTERS AND SETTERS
    public Scanner getScanner() {
        return scanner;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Starts the game by prompting the user for code length and number of symbols,
     * generating the secret code, and then running the main game loop.
     */
    public void start() {
        setCodeLength(promptCodeLength());
        setNumberOfSymbols(promptNumberOfSymbols());
        setSecretCode(CodeGenerator.generateValidCode(getCodeLength(), getNumberOfSymbols()));
        System.out.println(OutputUtil.generateSymbolMessage(codeLength, numberOfSymbols));
        playGame();
    }

    /**
     * Prompts the user to enter the length of the secret code and validates the input.
     *
     * @return the valid code length entered by the user
     */
    private int promptCodeLength() {
        int codeLength = -1;
        while (codeLength == -1) {
            InputHandler.printCodeSizePrompt();
            codeLength = InputHandler.readCodeSize(scanner);
            try {
                ValidationUtil.validatePasswordLength(codeLength);
            } catch (InvalidPasswordLengthException e) {
                System.err.println(e.getMessage());
                codeLength = -1;
            }
        }
        return codeLength;
    }

    /**
     * Prompts the user to enter the number of possible symbols in the code and validates the input.
     *
     * @return the valid number of symbols entered by the user
     */
    private int promptNumberOfSymbols() {
        int numberOfSymbols = -1;
        while (numberOfSymbols == -1) {
            InputHandler.printSymbolSizePrompt();
            numberOfSymbols = InputHandler.readSymbolSize(scanner);
            try {
                ValidationUtil.validateNumberOfSymbols(numberOfSymbols, codeLength);
            } catch (InvalidNumberOfSymbolsException e) {
                System.err.println(e.getMessage());
                numberOfSymbols = -1;
            }
        }
        return numberOfSymbols;
    }

    /**
     * Main game loop that handles user guesses, checks for correctness,
     * and provides feedback until the secret code is guessed.
     */
    private void playGame() {
        System.out.println("Okay, let's start the game!");
        int turn = 1;
        int bulls = 0;
        String userGuess;

        while (bulls < this.codeLength) {
            System.out.println("Turn " + turn + ": ");
            userGuess = InputHandler.getUserGuess(scanner);
            bulls = calculateBulls(this.secretCode, userGuess);
            int cows = calculateCows(this.secretCode, userGuess);
            printResult(bulls, cows);
            turn++;
        }
        System.out.println("Congratulations! You guessed the secret code: " + this.secretCode);
    }

    /**
     * Calculates the number of bulls (correct digits in the correct position).
     *
     * @param secretCode the generated secret code
     * @param userGuess  the user's guess
     * @return the number of bulls
     */
    private int calculateBulls(String secretCode, String userGuess) {
        int bulls = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (i < userGuess.length() && secretCode.charAt(i) == userGuess.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    /**
     * Calculates the number of cows (correct digits in the wrong position).
     *
     * @param secretCode the generated secret code
     * @param userGuess  the user's guess
     * @return the number of cows
     */
    private int calculateCows(String secretCode, String userGuess) {
        int cows = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            for (int j = 0; j < userGuess.length(); j++) {
                if (i != j && secretCode.charAt(i) == userGuess.charAt(j)) {
                    cows++;
                }
            }
        }
        return cows;
    }

    /**
     * Prints the result of the user's guess (number of bulls and cows).
     *
     * @param bulls the number of bulls
     * @param cows  the number of cows
     */
    private void printResult(int bulls, int cows) {
        if (bulls == 0 && cows == 0) {
            System.out.print("Grade: None. ");
        } else if (bulls > 0 && cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s)");
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s)");
        } else {
            System.out.print("Grade: " + bulls + " bull(s) and " + cows + " cow(s). ");
        }
    }
}
