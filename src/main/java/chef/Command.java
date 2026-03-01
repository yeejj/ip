package chef;

/**
 * Represents a generic executable command.
 * Subclasses implement specific behaviors.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks TaskList containing tasks.
     * @param ui UI handler for displaying messages.
     * @param storage Storage handler for saving data.
     * @throws ChefException If execution fails.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ChefException;

    public boolean isExit() {
        return false;
    }
}