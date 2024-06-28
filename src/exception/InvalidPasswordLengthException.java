package exception;

/**
 * The InvalidPasswordLengthException class is a custom exception that is thrown
 * when the password length provided by the user is invalid (i.e., less than the
 * minimum length or greater than the maximum allowed length).
 */
public class InvalidPasswordLengthException extends Exception{
    /**
     * Constructs a new InvalidPasswordLengthException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidPasswordLengthException(String message) {
        super(message);
    }
}
