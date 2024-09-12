/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project.master;
import java.util.Scanner;
  import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author tlesi
 */
public class ProjectMaster {
static class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

static class Login {
    private List<User> users;

    public Login() {
        this.users = new ArrayList<>();
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                } else if (Character.isDigit(c)) {
                    hasNumber = true;
                } else {
                    hasSpecialChar = true;
                }
            }
        }

        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
    }

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            users.add(new User(username, password, firstName, lastName));
            return "User registered successfully!";
        }
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String returnLoginStatus(boolean loginSuccess, String username) {
        if (loginSuccess) {
            User user = getUserByUsername(username);
            return "Welcome " + user.getFirstName() + " " + user.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    private User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner, login);
                    break;
                case 2:
                    loginUser(scanner, login);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner, Login login) {
        System.out.println("\nRegister User:");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);
    }

    private static void loginUser(Scanner scanner, Login login) {
        System.out.println("\nLogin User:");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean loginSuccess = login.loginUser(username, password);
        String loginMessage = login.returnLoginStatus(loginSuccess, username);
        System.out.println(loginMessage);
    }
}

   

