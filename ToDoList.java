import java.util.*;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TODOListManager todoListManager = new TODOListManager();
        int choice;

        do {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. View Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter due date (e.g., 2026-03-15): ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    todoListManager.addTask(title, dueDate, priority);
                    break;
                case 2:
                    todoListManager.viewAllTasks();
                    System.out.print("Enter task number to delete: ");
                    int delIndex = scanner.nextInt() - 1;
                    todoListManager.deleteTask(delIndex);
                    break;
                case 3:
                    todoListManager.viewAllTasks();
                    System.out.print("Enter task number to mark completed: ");
                    int compIndex = scanner.nextInt() - 1;
                    todoListManager.markTaskCompleted(compIndex);
                    break;
                case 4:
                    todoListManager.viewAllTasks();
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
class Task{
    private String title;
    private String dueDate;
    private String priority;
    private boolean isCompleted;
    //adding constrt
    public Task(String title,String dueDate,String priority,boolean isCompleted){
        this.title=title;
        this.dueDate=dueDate;
        this.priority=priority;
        this.isCompleted=isCompleted;
    }
    //now lets create a void method to mark the tasks to be complted or not
    public void markCompleted(){
        isCompleted=true;
    }
    //now i create a void method to display the task details
     public void displayTaskDetails() {
        String status = isCompleted ? "✔ Completed" : "✖ Pending";
        System.out.println("Task: " + title);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("-----------------------------------");
    }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }
}
class TODOListManager {
    private ArrayList<Task> tk;

    public TODOListManager() {
        tk = new ArrayList<>();
    }

    // Adding a task
    public void addTask(String title, String dueDate, String priority) {
        Task newTask = new Task(title, dueDate, priority, false);
        tk.add(newTask);
        System.out.println("Task added: " + newTask.getTitle());
    }

    // Viewing all tasks
    public void viewAllTasks() {
        if (tk.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (int i = 0; i < tk.size(); i++) {
            System.out.println("Task #" + (i + 1));
            tk.get(i).displayTaskDetails();
        }
    }

    // Deleting a task by index
    public void deleteTask(int index) {
        if (index >= 0 && index < tk.size()) {
            System.out.println("Deleted task: " + tk.get(index).getTitle());
            tk.remove(index);
        } else {
            System.out.println("Invalid task index. Cannot delete.");
        }
    }

    // Marking a task as completed by index
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tk.size()) {
            tk.get(index).markCompleted();
            System.out.println("Marked task as completed: " + tk.get(index).getTitle());
        } else {
            System.out.println("Invalid task index. Cannot mark as completed.");
        }
    }
}