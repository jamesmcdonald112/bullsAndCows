package exception;

/**
 * The InvalidNumberOfSymbolsException class is a custom exception that is thrown
 * when the number of symbols provided by the user is invalid (i.e., less than the
 * password length or greater than the maximum allowed symbols).
 */
public class InvalidNumberOfSymbolsException extends Exception{

    /**
     * Constructs a new InvalidNumberOfSymbolsException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidNumberOfSymbolsException(String message) {
        super(message);
    }
}
