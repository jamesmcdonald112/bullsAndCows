package util;
/**
 * The OutputUtil class is responsible for generating output messages related to
 * the game, such as the symbol message indicating the code length and range of symbols.
 */
public class OutputUtil {

    /**
     * Generates a message indicating the preparation of the secret code, including the
     * code length and the range of symbols used.
     *
     * @param codeLength      the length of the secret code
     * @param numberOfSymbols the number of possible symbols in the code
     * @return the generated message
     */
    public static String generateSymbolMessage(int codeLength, int numberOfSymbols) {
        StringBuilder result = new StringBuilder("The secret code is prepared: ");
        result.append(generateAsterisks(codeLength));
        result.append(" (0-9)");

        if (numberOfSymbols > 10) {
            if (numberOfSymbols == 11) {
                result.append('a');
            } else {
                result.append(generateAlphabetRange(numberOfSymbols));
            }
        }

        result.append(").");
        return result.toString();
    }

    /**
     * Generates a string of asterisks of the specified length.
     *
     * @param length the length of the asterisk string
     * @return the generated asterisk string
     */
    private static String generateAsterisks(int length) {
        return "*".repeat(length);
    }

    /**
     * Generates a string representing the range of alphabet symbols used in the code.
     *
     * @param numberOfSymbols the number of possible symbols in the code
     * @return the generated alphabet range string
     */
    private static String generateAlphabetRange(int numberOfSymbols) {
        StringBuilder alphabetRange = new StringBuilder();
        alphabetRange.append(", a-");
        char lastChar = (char) ('a' + numberOfSymbols - 11);
        alphabetRange.append(lastChar);
        return alphabetRange.toString();
    }
}
