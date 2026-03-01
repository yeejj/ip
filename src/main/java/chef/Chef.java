/**
 * Main entry point of the Chef chatbot application.
 * It initializes the UI, Storage, and TaskList,
 * and runs the main command loop.
 */

package chef;

public class Chef {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Creates a Chef instance using the given file path for storage.
     *
     * @param filePath Path to the data file.
     */
    public Chef(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the main chatbot loop until an exit command is issued.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();

                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();

            } catch (ChefException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Chef("data/duke.txt").run();
    }
}