# Chef User Guide
```
____________________________________________________________
Hello from
 _____   _               ____   
|  ___| | |      ____   /  _ \
| |     | |___, / __ \ |  /\_/  
| |___  | ,_, | |  __/ | |---  
|_____| |_| |_| \___| |__|

What can I do for you?
____________________________________________________________
```

Chef is a simple command-line chatbot that helps you manage your tasks, including todos, deadlines, and events. It automatically saves your tasks and allows you to mark them as done, delete, or search for tasks quickly.

---

## Adding Todos

Adds a simple task without a date. 
The input must begin with the word "todo".

Example: `todo read book`

```
expected output

____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
```

## Adding deadlines

Adds a task with a specific deadline date.
The input must begin with the word "deadline".
The date must come after the task with "/by".
Dates must be in `yyyy-MM-dd` format.

Example: `deadline return book /by 2026-03-05`

```
expected output

____________________________________________________________
Got it. I've added this task:
[D][ ] return book (by: Mar 05 2026)
Now you have 2 tasks in the list.
____________________________________________________________
```


## Adding Events 

Adds a task with a start and end time. 
The input must begin with the word "event".
The timings must start with "/by".

Example: `event team meeting /from 2pm /to 4pm`

```
expected output

____________________________________________________________
Got it. I've added this task:
[E][ ] team meeting (from: 2pm to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
```

## Adding Events

Adds a task with a start and end time.
The input must begin with the word "event".
The timings must start with "/by".

Example: `list`

```
expected output

____________________________________________________________
1.[T][ ] read book
2.[D][ ] return book (by: Mar 05 2026)
3.[E][ ] team meeting (from: 2pm to: 4pm)
____________________________________________________________
```

## Marking a Task as Done

Marks a task as completed.
The input must begin with the word "mark", followed by the number corresponding to the task.

Example: `mark 1`

```
expected output

____________________________________________________________
Nice! I've marked this task as done:
[T][X] read book
____________________________________________________________
```

## Unmarking a Task as Undone

Marks a completed task as not done.
The input must begin with the word "unmark", followed by the number corresponding to the task.

Example: `mark 1`

```
expected output

____________________________________________________________
OK, I've marked this task as not done yet:
[T][ ] read book
____________________________________________________________
```

## Deleting a Task

Removes a task from the list.
The input must begin with the word "delete", followed by the number corresponding to the task.

Example: `delete 2`

```
expected output

____________________________________________________________
Noted. I've removed this task:
[D][ ] return book (by: Mar 05 2026)
Now you have 2 tasks in the list.
____________________________________________________________
```

## Finding a Task

Searches for tasks containing a keyword. Search is **case-insensitive**.
The input must begin with the word "find".

Example: `find book`

```
expected output

____________________________________________________________
Here are the matching tasks in your list:
1.[T][ ] read book
____________________________________________________________
```

## Finding a Task

Closes the chatbot.

Example: `bye`

```
expected output

____________________________________________________________
Bye. Hope to see you again soon!
____________________________________________________________
```


---

## Notes & Reminders

- Task numbers start from 1.
- Dates for deadlines must be in `yyyy-MM-dd`.
- Commands are case-insensitive.
- All changes in the list are automatically saved in `data/duke.txt`.

---

## Summary of Commands

| Feature | Command |
|---------|---------|
| Add todo | `todo DESCRIPTION` |
| Add deadline | `deadline DESCRIPTION /by yyyy-MM-dd` |
| Add event | `event DESCRIPTION /from START /to END` |
| List tasks | `list` |
| Mark task | `mark NUMBER` |
| Unmark task | `unmark NUMBER` |
| Delete task | `delete NUMBER` |
| Find task | `find KEYWORD` |
| Exit | `bye` |

---

Thank you for using **Chef**! 🍳 Keep your tasks organized and efficient.