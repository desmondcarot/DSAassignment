/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entities.Student;
import Entities.TutorialGroup;
import dao.Initializer;
import UI.*;

/**
 *
 * @author Desmond
 */
public class DSAssignment {
    UI ui = new UI();
    Initializer init = new Initializer();
    CircularListInterface<TutorialGroup> tutorialGrpList = init.tutorialGroupListInit();
    CircularListInterface<String> studentlist = new CLinkedList<>();
    CircularListInterface<String> tutorlist = new CLinkedList<>();
    CircularListInterface<String> courselist = new CLinkedList<>();

    public static void main(String[] args) {
        DSAssignment run = new DSAssignment();
        run.runMenu();
    }

    public void runMenu(){
        int choice = 0;
        String errorMsg = null;
        do {
            ui.mainMenuDisplay(errorMsg);
            choice = ui.getChoice(5);
            // Process the user's choice 
            switch (choice) {
                case 1:
                    System.out.println("Student Registration selected.");
                    break;
                case 2:
                    TutorialManagement tut = new TutorialManagement(tutorialGrpList, studentlist, tutorlist, courselist);
                    //update the tutorial group list
                    tutorialGrpList = tut.runTutorial();
                    break;
                case 3:
                    System.out.println("Assignment Registration selected.");
                    // Add your assignment registration logic here
                    break;
                case 4:
                    System.out.println("Tutor Registration selected.");
                    // Add your tutor registration logic here
                    break;
                case 5:
                    System.out.println("Testing Code");
                    test();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }


    //method to test implementations 
    static public void test(){
        Initializer init = new Initializer();
        UI ui = new UI();
        CircularListInterface<Student> studentList = init.studentInitialize1();
        CircularListInterface<Student> studentList2 = init.studentInitialize2();
        
        //Display method
        System.out.println("List 1");
        System.out.println("=================");
        studentList.display();
        System.out.println("\n");

        System.out.println("List 2");
        System.out.println("=================");
        studentList2.display();
        System.out.println("\n");
        

        //contains method
        System.out.println("Does List 1 contains student id 3?");
        System.out.println("=================");
        Boolean test = studentList.contains(new Student(3, "Ross","Bos", "G2S", "FOCS", "Ross@tarc.edu.my" ));
        System.out.println(test);
        System.out.println("\n");

        //remove method
        System.out.println("Does List 1 contains student id 3? after removing it");
        System.out.println("=================");
        studentList.remove(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        Boolean test1 = studentList.contains(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.display();
        System.out.println(test1);
        System.out.println("\n");


        //toJson method
        System.out.println("Print List 1 as JSON string");
        System.out.println("=================");
        String jsontest = studentList.toJSON();
        System.out.println(jsontest);
        System.out.println("\n");


        //iterator method 
        System.out.println("Print each item in the list using iterator");
        System.out.println("=================");
        for (Student item : studentList) {
            System.out.println(item.toString());
        }
        System.out.println("\n");


        //merge list1 and list2
        System.out.println("merge list1 and list2");
        System.out.println("=================");
        studentList.merge(studentList2);
        studentList.display();
        System.out.println("\n");

        //remove duplicate
        System.out.println("remove duplicate");
        System.out.println("=================");
        studentList.removeDuplicates();
        studentList.display();
        System.out.println("\n");

        System.out.println("Final Size");
        System.out.println("=================");
        studentList.sort();
        studentList.display();
        System.out.println("\n");

        System.out.println("Final Size");
        System.out.println("=================");
        System.out.println(studentList.size());
        System.out.println("\n");
        

        System.out.println("Enter 1 to exit");
        int choice = 0;
        do{
            choice = ui.getChoice(1);
            if(choice == 1){
                return;
            }
        }while(choice != 1);
        
    }
}
