package chef;
/**
 * Creates a ChefException with the specified message.
 *
 * @param message Error message.
 * Custom exception used for handling Chef-related errors.
 */
public class ChefException extends Exception {

    public ChefException(String message) {
        super(message);
    }
}
