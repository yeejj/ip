package chef;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (tasks.isEmpty()) {
            ui.showMessage("No tasks yet!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            ui.showMessage((i + 1) + ". " + tasks.getAll().get(i));
        }
    }
}