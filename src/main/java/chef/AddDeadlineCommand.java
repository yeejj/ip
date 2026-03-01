package chef;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 * Executes the AddDeadline command.
 *
 */
public class AddDeadlineCommand extends Command {

    private final String description;
    private final String byString;

    public AddDeadlineCommand(String description, String byString) {
        this.description = description;
        this.byString = byString;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChefException {

        try {
            LocalDate date = LocalDate.parse(byString);

            Task task = new Deadline(description, date);
            tasks.add(task);
            storage.save(tasks.getAll());

            ui.showMessage("Got it. I've added this task:");
            ui.showMessage("  " + task);
            ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");

        } catch (DateTimeParseException e) {
            throw new ChefException("Invalid date format! Use yyyy-MM-dd (e.g., 2019-12-02).");
        }
    }
}