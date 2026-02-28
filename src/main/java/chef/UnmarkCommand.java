package chef;

public class UnmarkCommand extends Command {

    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChefException {

        Task task = tasks.get(index);
        task.markUndone();
        storage.save(tasks.getAll());

        ui.showMessage("OK, I've marked this task as not done yet:");
        ui.showMessage("  " + task);
    }
}