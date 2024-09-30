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
        String loginMessage = login.returnLoginStatus(username, "Ch&&sec@ke99!");
        System.out.println(loginMessage);
    }
}