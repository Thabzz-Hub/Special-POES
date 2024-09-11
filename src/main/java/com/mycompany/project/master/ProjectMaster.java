/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project.master;

import java.util.Scanner;

/**
 *
 * @author tlesi
 */
public class ProjectMaster {

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public static boolean checkPasswordComplexity(String password) {
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

    // Method to register the user
    public static String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            return "User registered successfully!";
        }
    }

    // Method to login the user
    public static boolean loginUser(String username, String password, String storedUsername, String storedPassword) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Method to return login status message
    public static String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Method to handle user input for registration and login
    public static String[] getUserDetails(Scanner scanner, String action) {
        System.out.println(action + " User:");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        return new String[]{username, password, firstName, lastName};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] userDetails;
        String registrationMessage;
        boolean registered = false;

        // Keep trying registration until successful
        do {
            userDetails = getUserDetails(scanner, "Register");

            // Register the user and provide feedback
            registrationMessage = registerUser(userDetails[0], userDetails[1]);
            System.out.println(registrationMessage);

            if (registrationMessage.equals("User registered successfully!")) {
                registered = true;
            } else {
                System.out.println("Please try registering again.");
            }
        } while (!registered); // Retry if registration fails

        // Proceed to login once registered
        System.out.println("\nLogin User:");

        boolean loginSuccess = false;

        while (!loginSuccess) {
            System.out.print("Enter Username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = scanner.nextLine();

            // Check login details
            loginSuccess = loginUser(loginUsername, loginPassword, userDetails[0], userDetails[1]);
            String loginMessage = returnLoginStatus(loginSuccess, userDetails[2], userDetails[3]);
            System.out.println(loginMessage);

            if (!loginSuccess) {
                System.out.println("Please try again.\n");
            }
        }
    }
    }

