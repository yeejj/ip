package chef;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ChefException;

    public boolean isExit() {
        return false;
    }
}