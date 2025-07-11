package com.tss.test;

import java.util.Scanner;

public class AccountValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = getValidUsername(sc);
        String password = getValidPassword(sc);
        String email = getValidEmail(sc);

        System.out.println("All inputs are valid.");
        sc.close();
    }

    public static String getValidUsername(Scanner sc) {
        while (true) {
            System.out.print("Enter username: ");
            String username = sc.next();
            if (isUserNameValid(username)) {
                return username;
            } else {
                System.out.println("Invalid username.");
            }
        }
    }

    public static String getValidPassword(Scanner sc) {
        while (true) {
            System.out.print("Enter password: ");
            String password = sc.next();
            if (isPasswordValid(password)) {
                return password;
            } else {
                System.out.println("Invalid password.");
            }
        }
    }

    public static String getValidEmail(Scanner sc) {
        while (true) {
            System.out.print("Enter email: ");
            String email = sc.next();
            if (isEmailValid(email)) {
                return email;
            } else {
                System.out.println("Invalid email.");
            }
        }
    }

    public static boolean isUserNameValid(String username) {
        return username != null && username.length() >= 3 && username.length() <= 20;
    }

    public static boolean isPasswordValid(String password) {
        return password != null && password.length() >= 8 && password.length() <= 30;
    }

    public static boolean isEmailValid(String email) {
        return email != null && email.contains("@") && email.contains(".") && email.length() >= 5 && email.length() <= 50;
    }
}
