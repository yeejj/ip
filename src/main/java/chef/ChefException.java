package chef;
/**
 * Creates a ChefException with the specified message.
 *
 * @param message Error message.
 */
public class ChefException extends Exception {

    public ChefException(String message) {
        super(message);
    }
}
