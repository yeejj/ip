package chef;
import java.util.Scanner;
import java.util.ArrayList;

public class Chef {
    public static void main(String[] args) {
        String logo =
                        " _____   _               ____   \n"
                        + "|  ___| | |      ____   /  _ \\ \n"
                        + "| |     | |___, / __ \\ |  /\\_/  \n"
                        + "| |___  | ,_, | |  __/ | |---  \n"
                        + "|_____| |_| |_| \\___| |__|       \n";
        System.out.println("____________________________________________________________");
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
        Scanner scanner = new Scanner(System.in);

        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            try {

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("____________________________________________________________");
                    scanner.close();
                    System.exit(0);
                }

                else if (input.equalsIgnoreCase("list")) {
                    System.out.println("____________________________________________________________");
                    if (tasks.isEmpty()) {
                        System.out.println(" No tasks yet!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(" " + (i + 1) + "." + tasks.get(i));
                        }
                    }
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("mark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new ChefException("That task number doesn't exist.");
                    }

                    tasks.get(index).markDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks.get(index));
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("unmark ")) {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new ChefException("That task number doesn't exist.");
                    }

                    tasks.get(index).markUndone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks.get(index));
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("todo")) {

                    if (input.length() <= 5) {
                        throw new ChefException("A todo needs a description. Try: todo read book");
                    }

                    String description = input.substring(5).trim();

                    if (description.isEmpty()) {
                        throw new ChefException("A todo cannot have an empty description.");
                    }

                    tasks.add(new Todo(description));

                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " +tasks.get(tasks.size() - 1));
                    System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("deadline")) {

                    String rest = input.substring(8).trim();

                    if (!rest.contains(" /by ")) {
                        throw new ChefException("A deadline must have /by. Example: deadline return book /by Sunday");
                    }

                    String[] parts = rest.split(" /by ", 2);

                    if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new ChefException("Deadline needs both description and date.");
                    }

                    tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));

                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " + tasks.get(tasks.size()  - 1));
                    System.out.println(" Now you have " +  tasks.size()  + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("event")) {

                    String rest = input.substring(5).trim();

                    if (!rest.contains(" /from ") || !rest.contains(" /to ")) {
                        throw new ChefException("An event needs /from and /to. Example: event meeting /from 2pm /to 4pm");
                    }

                    String[] part1 = rest.split(" /from ", 2);
                    String[] part2 = part1[1].split(" /to ", 2);

                    if (part1[0].trim().isEmpty() ||
                            part2[0].trim().isEmpty() ||
                            part2[1].trim().isEmpty()) {
                        throw new ChefException("Event must have description, start time and end time.");
                    }

                    tasks.add(new Event(
                            part1[0].trim(),
                            part2[0].trim(),
                            part2[1].trim()
                    ));

                    System.out.println("____________________________________________________________");
                    System.out.println(" Got it. I've added this task:");
                    System.out.println("   " + tasks.get(tasks.size()- 1));
                    System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }

                else if (input.toLowerCase().startsWith("delete ")) {

                    int index = Integer.parseInt(input.split(" ")[1]) - 1;

                    if (index < 0 || index >= tasks.size()) {
                        throw new ChefException("That task number doesn't exist.");
                    }

                    Task removedTask = tasks.remove(index);

                    System.out.println("____________________________________________________________");
                    System.out.println(" Noted. I've removed this task:");
                    System.out.println("   " + removedTask);
                    System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                }

                else {
                    throw new ChefException("I don't recognize that command. Try: todo, deadline, event, list, mark, unmark, or bye.");
                }

            } catch (ChefException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" Error: " + e.getMessage());
                System.out.println("____________________________________________________________");
            } catch (Exception e) {
                System.out.println("____________________________________________________________");
                System.out.println(" Something went wrong. Please check your command format.");
                System.out.println("____________________________________________________________");
            }
        }
    }
}