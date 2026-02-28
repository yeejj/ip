package chef;

import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task remove(int index) throws ChefException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChefException("That task number doesn't exist.");
        }
        return tasks.remove(index);
    }

    public Task get(int index) throws ChefException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChefException("That task number doesn't exist.");
        }
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public ArrayList<Task> getAll() {
        return tasks;
    }

    public java.util.ArrayList<Task> find(String keyword) {
        java.util.ArrayList<Task> matches = new java.util.ArrayList<>();

        for (Task task : tasks) {
            if (task.description.toLowerCase().contains(keyword.toLowerCase())) {
                matches.add(task);
            }
        }

        return matches;
    }
}