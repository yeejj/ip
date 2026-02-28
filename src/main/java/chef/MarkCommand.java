package chef;

public class MarkCommand extends Command {

    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChefException {

        Task task = tasks.get(index);
        task.markDone();
        storage.save(tasks.getAll());

        ui.showMessage("Nice! I've marked this task as done:");
        ui.showMessage("  " + task);
    }
}