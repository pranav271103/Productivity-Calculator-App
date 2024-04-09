//package ProdCalcApp;
import java.util.*;
class Task{
    private String name;
    private String category;
    private int hours;

    public Task(String name, String category, int hours){
        this.name = name;
        this.category = category;
        this.hours = hours;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public int getHours(){
        return hours;
    }
}

class ProductivityCalculator{
    private static Scanner scanner = new Scanner(System.in);
    private static boolean login(String username, String password){
        return username.equals("admin") && password.equals("password");
    }

    private static List<Task> createTaskList(){
        System.out.println("Enter the number of tasks:");
        int numTasks = scanner.nextInt();
        scanner.nextLine();

        List<Task> taskList = new ArrayList<>();
        for (int i = 1; i <= numTasks; i++){
            System.out.println("Enter details for Task " + i + ":");
            System.out.print("Task name: ");
            String name = scanner.nextLine();
            System.out.print("Category (Productive/Non-Productive): ");
            String category = scanner.nextLine();
            System.out.print("Hours to accomplish the task: ");
            int hours = scanner.nextInt();
            scanner.nextLine();

            Task task = new Task(name, category, hours);
            taskList.add(task);
        }
        return taskList;
    }

    private static void performOperations(List<Task> taskList){
        boolean running = true;

        while (running){
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add a task");
            System.out.println("2. Update a task");
            System.out.println("3. Delete a task");
            System.out.println("4. Calculate productive hours");
            System.out.println("5. Display Tasks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addTask(taskList);
                    break;
                case 2:
                    updateTask(taskList);
                    break;
                case 3:
                    deleteTask(taskList);
                    break;
                case 4:
                    calculateProductiveHours(taskList);
                    break;
                case 5:
                    displayTasks(taskList);
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addTask(List<Task> taskList){
    System.out.print("Task name: ");
    String name = scanner.nextLine();
    System.out.print("Category (Productive/Non-Productive): ");
    String category = scanner.nextLine();
    System.out.print("Hours to accomplish the task: ");
    int hours = scanner.nextInt();
    scanner.nextLine();
    Task task = new Task(name, category, hours);
    taskList.add(task);
    System.out.println("Task added successfully!");
    }  

    private static void updateTask(List<Task> taskList){
    System.out.println("Enter the task name to update:");
    String taskName = scanner.nextLine();
    Task taskToUpdate = null;
    for (Task task : taskList){
        if (task.getName().equalsIgnoreCase(taskName)){
            taskToUpdate = task;
            break;
        }
    }
    if (taskToUpdate != null){
        System.out.println("Enter the new details for the task:");
        System.out.print("Category (Productive/Non-Productive): ");
        String newCategory = scanner.nextLine();
        System.out.print("Hours to accomplish the task: ");
        int newHours = scanner.nextInt();
        scanner.nextLine();
        taskToUpdate.equals(newCategory);
        taskToUpdate.equals(newHours);
        System.out.println("Task updated successfully!");
    }
    else{
        System.out.println("Task not found. Update failed.");
    }
    }
    private static void deleteTask(List<Task> taskList){
    System.out.println("Enter the task name to delete:");
    String taskName = scanner.nextLine();
    Task taskToDelete = null;
    for (Task task : taskList){
        if (task.getName().equalsIgnoreCase(taskName)){
            taskToDelete = task;
            break;
        }
    }
    if (taskToDelete != null){
        taskList.remove(taskToDelete);
        System.out.println("Task deleted successfully!");
    }
    else{
        System.out.println("Task not found. Deletion failed.");
    }
    }  

    private static void calculateProductiveHours(List<Task> taskList){
    int totalHours = 0;
    int nonProductiveHours = 0;
    for (Task task : taskList){
        totalHours += task.getHours();
        if (task.getCategory().equalsIgnoreCase("Non-Productive")){
            nonProductiveHours += task.getHours();
        }
    }
    int productiveHours = totalHours - nonProductiveHours;
    System.out.println("Total hours: " + totalHours);
    System.out.println("Non-productive hours: " + nonProductiveHours);
    System.out.println("Productive hours: " + productiveHours);
    }

    private static void displayTasks(List<Task> taskList){
    if (taskList.isEmpty()){
        System.out.println("No tasks found.");
    }
    else{
        System.out.println("Task List:");
        for (Task task : taskList) {
            System.out.println("Task Name: " + task.getName());
            System.out.println("Category: " + task.getCategory());
            System.out.println("Hours: " + task.getHours());
            System.out.println("-----------------------");
        }
    }
    }
   
    public static void main(String[] args){
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        if (login(username, password)){
            System.out.println("Login successful!");
            List<Task> taskList = createTaskList();

            if (taskList != null){
                System.out.println("Task List created!");
                performOperations(taskList);
            }
            else{
                System.out.println("Task List creation failed.");
            }
        }
        else{
            System.out.println("Invalid credentials. Login failed.");
        }
    }

}
