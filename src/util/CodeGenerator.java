package util;

import java.util.*;

/**
 * The CodeGenerator class is responsible for generating a valid secret code
 * based on the specified code length and number of symbols.
 */
public class CodeGenerator {

    /**
     * Generates a valid secret code of the specified length and number of symbols.
     *
     * @param codeLength      the length of the secret code
     * @param numberOfSymbols the number of possible symbols in the code
     * @return the generated valid secret code
     */
    public static String generateValidCode(int codeLength, int numberOfSymbols) {
        String code = generateRandomCode(codeLength, numberOfSymbols);
        while (!isValidCode(code)) {
            code = generateRandomCode(codeLength, numberOfSymbols);
        }
        return code;
    }

    /**
     * Generates a random code of the specified length and number of symbols.
     *
     * @param codeLength      the length of the secret code
     * @param numberOfSymbols the number of possible symbols in the code
     * @return the generated random code
     */
    private static String generateRandomCode(int codeLength, int numberOfSymbols) {
        List<Character> symbols = generateSymbols(numberOfSymbols);

        StringBuilder code = new StringBuilder();
        Random random = new Random();
        Set<Character> usedCharacters = new HashSet<>();

        while (code.length() < codeLength) {
            char randomChar = getRandomSymbol(symbols, random);
            if (isUniqueCharacter(randomChar, usedCharacters)) {
                code.append(randomChar);
                usedCharacters.add(randomChar);
            }
        }
        return code.toString();
    }

    /**
     * Checks if the generated code is valid (i.e., no repeating characters).
     *
     * @param code the generated code
     * @return true if the code is valid, false otherwise
     */
    private static boolean isValidCode(String code) {
        return noRepeatingCharacters(code);
    }

    /**
     * Generates a list of possible symbols based on the number of symbols specified.
     *
     * @param numberOfSymbols the number of possible symbols
     * @return the list of possible symbols
     */
    private static List<Character> generateSymbols(int numberOfSymbols) {
        List<Character> symbols = new ArrayList<>();
        for (int i = 0; i < numberOfSymbols; i++) {
            if (i < 10) {
                symbols.add((char) ('0' + i));
            } else {
                symbols.add((char) ('a' + i - 10));
            }
        }
        return symbols;
    }

    /**
     * Returns a random symbol from the list of possible symbols.
     *
     * @param symbols the list of possible symbols
     * @param random  the Random object used to generate the random symbol
     * @return the random symbol
     */
    private static char getRandomSymbol(List<Character> symbols, Random random) {
        return symbols.get(random.nextInt(symbols.size()));
    }

    /**
     * Checks if the character is unique (i.e., not already used in the code).
     *
     * @param character      the character to check
     * @param usedCharacters the set of characters already used in the code
     * @return true if the character is unique, false otherwise
     */
    private static boolean isUniqueCharacter(char character, Set<Character> usedCharacters) {
        return !usedCharacters.contains(character);
    }

    /**
     * Checks if there are no repeating characters in the code.
     *
     * @param code the generated code
     * @return true if there are no repeating characters, false otherwise
     */
    private static boolean noRepeatingCharacters(String code) {
        for (int i = 0; i < code.length(); i++) {
            for (int j = i + 1; j < code.length(); j++) {
                if (code.charAt(i) == code.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
