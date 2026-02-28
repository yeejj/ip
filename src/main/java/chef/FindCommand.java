package chef;

import java.util.ArrayList;

/**
 * Command that finds tasks matching a keyword.
 */
public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        ArrayList<Task> matches = tasks.find(keyword);

        if (matches.isEmpty()) {
            ui.showMessage("No matching tasks found.");
            return;
        }

        ui.showMessage("Here are the matching tasks in your list:");

        for (int i = 0; i < matches.size(); i++) {
            ui.showMessage((i + 1) + "." + matches.get(i));
        }
    }
}