import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskScheduler {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\nClick 1 to add new task");
            System.out.println("Click 2 to see all taks");
            System.out.println("Click 3 to exit app");
            System.out.print("\nchoice: ");

            int choice = scanner.nextInt();

            switch (choice) 
		{
                case 1:

                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:

                    System.out.println("You have exited");
                    System.exit(0);
                    break;
                default:

                    System.out.println("enter between 1,2,3");
            }
        }
    }

    private static void addTask(Scanner scanner) 
	{
        System.out.print("Enter title: ");
        String title = scanner.next();


        System.out.print("Enter deadline date: ");
        String dueDate = scanner.next();


        System.out.print("priority from 1 2 3 :");
        int priority = scanner.nextInt();


        Task newTask = new Task(title, dueDate, priority);
        tasks.add(newTask);

        System.out.println("added task successfully.");
    	}

    private static void viewTasks() 
	{
        if (tasks.isEmpty()) {
            System.out.println("No tasks");
        } else 
		{
           
            Collections.sort(tasks, Comparator.comparing(Task::getDueDate).thenComparing(Task::getPriority));

            System.out.println("\nTask List:");
            for (Task task : tasks) {
                System.out.println("Title: " + task.getTitle());
                System.out.println("Due Date: " + task.getDueDate());
                System.out.println("Priority: " + task.getPriority());
                System.out.println("---------------");
            	}
       }
    }
}
class Task 
{
    private String title;
    private String dueDate;
    private int priority;

    public Task(String title, String dueDate, int priority) 
    {
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
    }
    public String getTitle() 
    {
        return title;
    }
    public String getDueDate()
    {
        return dueDate;
    }
    public int getPriority() 
    {
        return priority;
    }
}

