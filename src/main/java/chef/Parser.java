package chef;

public class Parser {

    public static Command parse(String input) throws ChefException {

        String lower = input.toLowerCase();

        if (lower.equals("bye")) {
            return new ExitCommand();
        }

        if (lower.equals("list")) {
            return new ListCommand();
        }

        if (lower.startsWith("mark ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(index);
        }

        if (lower.startsWith("unmark ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(index);
        }

        if (lower.startsWith("delete ")) {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(index);
        }

        if (lower.startsWith("todo")) {
            String desc = input.substring(5).trim();
            if (desc.isEmpty()) {
                throw new ChefException("A todo cannot have empty description.");
            }
            return new AddTodoCommand(desc);
        }

        if (lower.startsWith("deadline")) {
            String rest = input.substring(8).trim();

            if (!rest.contains(" /by ")) {
                throw new ChefException("A deadline must have /by.");
            }

            String[] parts = rest.split(" /by ", 2);

            if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                throw new ChefException("Deadline needs description and date.");
            }

            return new AddDeadlineCommand(parts[0].trim(), parts[1].trim());
        }

        if (lower.startsWith("event")) {
            String rest = input.substring(5).trim();

            if (!rest.contains(" /from ") || !rest.contains(" /to ")) {
                throw new ChefException("Event must have /from and /to.");
            }

            String[] part1 = rest.split(" /from ", 2);
            String[] part2 = part1[1].split(" /to ", 2);

            if (part1[0].trim().isEmpty()
                    || part2[0].trim().isEmpty()
                    || part2[1].trim().isEmpty()) {
                throw new ChefException("Event must have description, start and end.");
            }

            return new AddEventCommand(
                    part1[0].trim(),
                    part2[0].trim(),
                    part2[1].trim()
            );
        }

        throw new ChefException("I don't recognize that command.");
    }
}