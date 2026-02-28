package chef;

public class AddDeadlineCommand extends Command {

    private final String description;
    private final String by;

    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        Task task = new Deadline(description, by);
        tasks.add(task);
        storage.save(tasks.getAll());

        ui.showMessage("Got it. I've added this task:");
        ui.showMessage("  " + task);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}