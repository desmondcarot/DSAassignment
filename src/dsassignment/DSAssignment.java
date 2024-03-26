/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsassignment;

import java.io.IOException;
import java.util.Scanner;
import ADT.CLinkedList;
import Entities.Student;

/**
 *
 * @author Desmond
 */
public class DSAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String errormsg = null;
        do {
            mainMenu(errormsg);
            //check input validation
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                errormsg = "Invalid input. Please enter a number.";
                scanner.next(); // consume the invalid input
            }else{
                choice = scanner.nextInt();
                //checks if the choice is available
                if (choice > 5){
                    errormsg = "Invalid choice. Please select a valid option.";
                }else{
                    break;  
                }
            }
        } while (true);
        scanner.close();
            // Process the user's choice 
            // implement your module here
            switch (choice) {
                case 1:
                    System.out.println("Student Registration selected.");
                    choice = 0;
                    break;
                case 2:
                    System.out.println("Tutorial Registration selected.");
                    choice = 0;
                    break;
                case 3:
                    System.out.println("Assignment Registration selected.");
                    choice = 0;
                    break;
                case 4:
                    System.out.println("Tutor Registration selected.");
                    choice = 0;
                    break;
                case 5:
                    System.out.println("Testing Code");
                    test();
                    choice = 0;
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

    }


    //method to test implementations 
    static public void test(){
        CLinkedList<Student> studentList = new CLinkedList<>();
        studentList.add(new Student(1, "Alice", "RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.add(new Student(2, "Bob", "RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.add(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.add(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.display();

        var test = studentList.contains(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        System.out.println(test);

        var jsontest = studentList.toJSON();
        System.out.println("JSON");
        System.out.println(jsontest);

        for (Student item : studentList) {
            System.out.println(item.toString());
        }

    }

    //Display main menu
    static public void mainMenu(String error){
        clearScreen();
        System.out.println("UNIVERSITY SYSTEM");
        System.out.println("-------------------------------");
        System.out.println("1. Student Registration");
        System.out.println("2. Tutorial Registration");
        System.out.println("3. Assignment Registration");
        System.out.println("4. Tutor Registration");
        System.out.println("5. Test Codes");
        System.out.println("0. Exit");

        if (error != null){
            System.out.println("");
            System.out.println(error);
        }
        
    }

    //method to clear CLI
    public static void clearScreen() {
        try {
            // Clear screen command for Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // Clear screen command for Unix-based systems
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing the screen: " + ex.getMessage());
        }
    }
}
