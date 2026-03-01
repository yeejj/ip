package chef;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Handles loading tasks from file and saving tasks to file.
 */
public class Storage {

    private final String filePath;

    /**
     * Creates a Storage object with the specified file path.
     *
     * @param filePath Path to the data file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return List of tasks loaded from file.
     */
    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                return tasks;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Warning: Could not load tasks. Starting with empty list.");
        }

        return tasks;
    }

    /**
     * Saves the given list of tasks to file.
     *
     * @param tasks List of tasks to save.
     */
    public void save(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (Task task : tasks) {
                writer.write(encodeTask(task));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    /**
     * Converts a Task into its file storage format.
     *
     * @param task Task to encode.
     * @return Encoded string representation.
     */
    private String encodeTask(Task task) {
        String status = task.isDone ? "1" : "0";

        if (task instanceof Todo) {
            return "T | " + status + " | " + task.description;

        } else if (task instanceof Deadline) {
            Deadline d = (Deadline) task;
            // LocalDate automatically saves in yyyy-MM-dd format
            return "D | " + status + " | "
                    + d.description + " | "
                    + d.getBy();

        } else if (task instanceof Event) {
            Event e = (Event) task;
            return "E | " + status + " | "
                    + e.description + " | "
                    + e.from + " | "
                    + e.to;
        }

        return "";
    }

    /**
     * Parses a line from the storage file into a Task object.
     *
     * @param line A single line from the file.
     * @return Parsed Task object, or null if corrupted.
     */
    private Task parseTask(String line) {        try {
            String[] parts = line.split(" \\| ");

            String type = parts[0];
            boolean isDone = parts[1].equals("1");

            Task task;

            switch (type) {
                case "T":
                    task = new Todo(parts[2]);
                    break;

                case "D":
                    // Parse ISO format date back to LocalDate
                    task = new Deadline(parts[2], LocalDate.parse(parts[3]));
                    break;

                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;

                default:
                    return null;
            }

            if (isDone) {
                task.markDone();
            }

            return task;

        } catch (Exception e) {
            // corrupted line — ignore it
            return null;
        }
    }
}