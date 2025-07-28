package com.tss.test;

import java.util.Scanner;
import com.tss.controller.StudentController;

public class StudentAppTest {

    public static void main(String[] args) {

        StudentController controller = new StudentController();
        Scanner sc = new Scanner(System.in);

        boolean isTrue = true;

        while (isTrue) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Read All Students");
            System.out.println("2. Add New Student Record");
            System.out.println("3. Read a Student by ID");
            System.out.println("4. Update Student's Percentage by ID");
            System.out.println("5. Delete a Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    controller.readAllRecords();
                    break;

                case 2:
                    controller.addNewStudent(sc);
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int id = sc.nextInt();
                    controller.readStudentById(id);
                    break;
                    
                case 4 : 
                {
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new percentage: ");
                    double newPercentage = sc.nextDouble();

                    controller.updatePercentageById(updateId, newPercentage);
                    
                }break;
                
                case 5 : 
                {
                	System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    controller.deleteStudentById(deleteId);
                }break;

                case 6:
                    isTrue = false;
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
