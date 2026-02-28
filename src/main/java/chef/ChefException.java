package chef;
/**
 * Custom exception used for handling Chef-related errors.
 */
public class ChefException extends Exception {

    public ChefException(String message) {
        super(message);
    }
}
