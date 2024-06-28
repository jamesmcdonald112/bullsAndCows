package util;

import exception.InvalidNumberOfSymbolsException;
import exception.InvalidPasswordLengthException;

/**
 * The ValidationUtil class provides utility methods for validating the password length
 * and number of symbols for the Bulls and Cows game.
 */
public class ValidationUtil {

    /**
     * Checks if the provided password length is within the valid range.
     *
     * @param passwordLength the length of the password
     * @return true if the password length is valid, false otherwise
     */
    public static boolean isValidPasswordLength(int passwordLength) {
        int minPasswordLength = ConfigUtil.getMinPasswordLength();
        int maxPasswordLength = ConfigUtil.getMaxPasswordLength();
        return passwordLength >= minPasswordLength && passwordLength <= maxPasswordLength;
    }

    /**
     * Validates the password length, throwing an exception if it is invalid.
     *
     * @param passwordLength the length of the password
     * @throws InvalidPasswordLengthException if the password length is invalid
     */
    public static void validatePasswordLength(int passwordLength) throws InvalidPasswordLengthException {
        int minPasswordLength = ConfigUtil.getMinPasswordLength();
        int maxPasswordLength = ConfigUtil.getMaxPasswordLength();
        if (!isValidPasswordLength(passwordLength)) {
            throw new InvalidPasswordLengthException("Error: Invalid password length: " + passwordLength +
                    ". Must be between " + minPasswordLength + " and " + maxPasswordLength + ".");
        }
    }

    /**
     * Validates the number of symbols, throwing an exception if it is invalid.
     *
     * @param numberOfSymbols the number of possible symbols in the code
     * @param passwordLength  the length of the password
     * @throws InvalidNumberOfSymbolsException if the number of symbols is invalid
     */
    public static void validateNumberOfSymbols(int numberOfSymbols, int passwordLength) throws InvalidNumberOfSymbolsException {
        if (numberOfSymbols < passwordLength) {
            throw new InvalidNumberOfSymbolsException("Error: Number of symbols cannot be less " +
                    "than the " +
                    "password length.");
        } else if (numberOfSymbols > 36) {
            throw new InvalidNumberOfSymbolsException("Error: Number of symbols cannot be greater" +
                    " than " +
                    "36.");
        }
    }
}
