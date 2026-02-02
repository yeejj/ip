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

        String[] tasks = new String[100];
        boolean[] isDone = new boolean[100];
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
                        String status = isDone[i] ? "[X]" : "[ ]";
                        System.out.println(" " + (i + 1) + "." + status + " git t" + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (input.toLowerCase().startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index >= 0 && index < count) {
                        isDone[index] = true;
                        System.out.println("____________________________________________________________");
                        System.out.println(" Nice! I've marked this task as done:");
                        System.out.println("   [X] " + tasks[index]);
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
                        isDone[index] = false;
                        System.out.println("____________________________________________________________");
                        System.out.println(" OK, I've marked this task as not done yet:");
                        System.out.println("   [ ] " + tasks[index]);
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

            else {
                if (count < tasks.length) {
                    tasks[count] = input;
                    count++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Task list full! Cannot add more.");
                    System.out.println("____________________________________________________________");
                }
        }
        }
    }
}