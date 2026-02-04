import java.util.Scanner;

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

        Task[] tasks = new Task[100];
        int count = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                scanner.close();
                System.exit(0);
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                if (count == 0) {
                    System.out.println(" No tasks yet!");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println(" " + (i + 1) + "." + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (input.toLowerCase().startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index >= 0 && index < count) {
                        tasks[index].markDone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" Nice! I've marked this task as done:");
                        System.out.println("   " + tasks[index]);
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("____________________________________________________________");
                        System.out.println(" Invalid task number!");
                        System.out.println("____________________________________________________________");
                    }
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Please provide a valid task number after 'mark'.");
                    System.out.println("____________________________________________________________");
                }
            }
            else if (input.toLowerCase().startsWith("unmark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index >= 0 && index < count) {
                        tasks[index].markUndone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" OK, I've marked this task as not done yet:");
                        System.out.println("   " + tasks[index]);
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("____________________________________________________________");
                        System.out.println(" Invalid task number!");
                        System.out.println("____________________________________________________________");
                    }
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Please provide a valid task number after 'unmark'.");
                    System.out.println("____________________________________________________________");
                }
            }

            else if (input.toLowerCase().startsWith("todo ")) {

                String description = input.substring(5);

                tasks[count] = new Todo(description);
                count++;

                System.out.println("____________________________________________________________");
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[count - 1]);
                System.out.println(" Now you have " + count + " tasks in the list.");
                System.out.println("____________________________________________________________");

            }
            else if (input.toLowerCase().startsWith("deadline ")) {

                String rest = input.substring(9);

                String[] parts = rest.split(" /by ", 2);

                String description = parts[0];
                String by = parts[1];

                tasks[count] = new Deadline(description, by);
                count++;

                System.out.println("____________________________________________________________");
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[count - 1]);
                System.out.println(" Now you have " + count + " tasks in the list.");
                System.out.println("____________________________________________________________");

            }
            else if (input.toLowerCase().startsWith("event ")) {

                String rest = input.substring(6);

                String[] part1 = rest.split(" /from ", 2);
                String description = part1[0];

                String[] part2 = part1[1].split(" /to ", 2);
                String from = part2[0];
                String to = part2[1];

                tasks[count] = new Event(description, from, to);
                count++;

                System.out.println("____________________________________________________________");
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[count - 1]);
                System.out.println(" Now you have " + count + " tasks in the list.");
                System.out.println("____________________________________________________________");

            }

            else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Task list full! Cannot add more.");
                    System.out.println("____________________________________________________________");
                }
        }
    }
}