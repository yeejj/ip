/**
 * Represents a generic task with a description
 * and completion status.
 */
package chef;
public class Task {

    protected String description;
    protected  boolean isDone;
    /**
     * Creates a task with the given description.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks this task as completed.
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Marks this task as not completed.
     */
    public void markUndone() {
        isDone= false;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " " ;
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}