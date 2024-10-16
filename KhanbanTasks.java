/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.master;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author tlesi
 */
public class KhanbanTasks {
     public static void main(String[] args) {
         

       Login loginSystem = new Login();  // Create an instance of the Login class

        // Menu for user registration and login
        boolean loggedIn = false;
        while (!loggedIn) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "1) Register a new user\n2) Login\n3) Quit"));
            
            switch (choice) {
                case 1 -> { // Registration
                    String username = JOptionPane.showInputDialog("Enter Username (must contain an underscore and no more than 5 characters):");
                    String password = JOptionPane.showInputDialog("Enter Password (must be at least 8 characters, include uppercase, lowercase, number, and special character):");
                    String firstName = JOptionPane.showInputDialog("Enter your First Name:");
                    String lastName = JOptionPane.showInputDialog("Enter your Last Name:");
                    
                    // Register user and display feedback
                    String registrationMessage = loginSystem.registerUser(username, password, firstName, lastName);
                    JOptionPane.showMessageDialog(null, registrationMessage);
                }
                
                case 2 -> { // Login
                    String username = JOptionPane.showInputDialog("Enter Username:");
                    String password = JOptionPane.showInputDialog("Enter Password:");
                    
                    // Attempt to log in
                    if (loginSystem.loginUser(username, password)) {
                        JOptionPane.showMessageDialog(null, loginSystem.returnLoginStatus(username, password));
                        loggedIn = true;  // User is now logged in, exit the login loop
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login credentials. Please try again.");
                    }
                }
                
                case 3 -> { // Quit
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    System.exit(0);
                }
                
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please choose a valid option.");
            }
        }

        // After login, show the Kanban task management menu
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        int option = 0;
        ArrayList<Task> tasks = new ArrayList<>();  // Store Task objects
        int totalHours = 0;

        while (option != 3) {
            option = Integer.parseInt(JOptionPane.showInputDialog("1) Add Tasks\n2) Show Report\n3) Quit"));
            switch (option) {
                case 1 -> {
                    // Get the number of tasks to be added
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));
                    // Add tasks
                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");

                        // Ensure description is less than 50 characters
                        if (taskDescription.length() > 50) {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            i--;
                            continue;
                        }

                        String developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
                        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration in hours:"));
                        String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do, Doing, Done):");

                        Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                        tasks.add(task);
                        totalHours = task.returnTotalHours(totalHours);

                        // Display task details
                        JOptionPane.showMessageDialog(null, task.printTaskDetails());
                    }
                    // Show total hours
                    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                }
                case 2 -> {
                    // Show Report: Display details of all tasks in the ArrayList
                    if (tasks.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No tasks available.");
                    } else {
                        StringBuilder report = new StringBuilder("Tasks Report:\n\n");
                        for (Task task : tasks) {
                            report.append(task.printTaskDetails()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, report.toString());
                    }
                }
                case 3 -> JOptionPane.showMessageDialog(null, "Exiting...");
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid option.");
            }
        }
    }
}
    
