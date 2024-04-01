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
    CircularListInterface<String> studentlist = init.studentInitString();
    CircularListInterface<String> tutorlist = init.tutorlistinit();
    CircularListInterface<String> courselist = init.courseListInit();

    public static void main(String[] args) {
        DSAssignment run = new DSAssignment();
        run.runMenu();
    }

    public void runMenu(){
        int choice = 0;
        String errorMsg = null;
        do {
            ui.mainMenuDisplay(errorMsg);
            System.out.print("Enter your choice: ");
            choice = ui.getChoice();
            if (choice == 99) {
                errorMsg = "Invalid input. Please enter a number.";
            } else if (choice > 5 || choice < 0) {
                errorMsg = "Invalid choice. Please select a valid option.";
            } else {
                errorMsg = null; // Reset error message if choice is valid
            }
            // Process the user's choice 
            switch (choice) {
                case 1:
                    System.out.println("Student Registration selected.");
                    break;
                case 2:
                    System.out.println("Tutorial Registration selected.");
                    runTutorial();
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


    public void runTutorial(){
        int choice = 0;
        String errorMsg = null;
        do {
            ui.tutorialMenuDisplay(errorMsg);
            System.out.print("Enter your choice: ");
            choice = ui.getChoice();
            if (choice == 99) {
                errorMsg = "Invalid input. Please enter a number.";
            } else if (choice > 5 || choice < 0) {
                errorMsg = "Invalid choice. Please select a valid option.";
            } else {
                errorMsg = null; // Reset error message if choice is valid
            }
            // Process the user's choice 
            switch (choice) {
                case 1:
                    errorMsg = addTutorialGroup();
                    break;
                case 2:
                    listTutorialGroup();
                    break;
                case 3:
                    errorMsg = removeTutorialGroup();
                    break;
                case 4:
                    editGrpMenu();
                    break;
                case 5:
                    System.out.println("Testing Code");
                    test();
                    break;
                case 6:
                    main(null);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }

    public void editGrpMenu(){
        int choice = 0;
        String errorMsg = null;
        do {
            ui.editGrpMenuDisplay(errorMsg);
            System.out.print("Enter your choice: ");
            choice = ui.getChoice();
            if (choice == 99) {
                errorMsg = "Invalid input. Please enter a number.";
            } else if (choice > 5 || choice < 0) {
                errorMsg = "Invalid choice. Please select a valid option.";
            } else {
                errorMsg = null; // Reset error message if choice is valid
            }
            // Process the user's choice 
            switch (choice) {
                case 1: //change group info
                    editGrpInformationMenu();
                    break;
                case 2: //replace grp
                    break;
                case 3: //Remove Duplicate
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }
    
    public void editGrpInformationMenu(){
        int choice = 0;
        String errorMsg = null;
        TutorialGroup selectedGroup = selectGroup();
        TutorialGroup updatedGroup = new TutorialGroup();
        do {
            ui.editGrpInformation(errorMsg);
            System.out.print("Enter your choice: ");
            choice = ui.getChoice();
            if (choice == 99) {
                errorMsg = "Invalid input. Please enter a number.";
            } else if (choice > 5 || choice < 0) {
                errorMsg = "Invalid choice. Please select a valid option.";
            } else {
                errorMsg = null; // Reset error message if choice is valid
            }
            // Process the user's choice 
            switch (choice) {
                case 1: //change group info
                    break;
                case 2: //replace grp
                    break;
                case 3: //Remove Duplicate
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }

    public String editID(){
        ui.print("Enter the new ID for this group")
    }
    public TutorialGroup selectGroup(){
        ui.tutorialGroupDisplay(tutorialGrpList);
        TutorialGroup selectedGroup = new TutorialGroup();
        do{ 
            if (selectedGroup == null){
                ui.print("Enter the tutorial groupID of the group you want to edit: ");
            }else{
                ui.print("Group Does not exists, please enter again: ");
            }
            selectedGroup.setId(ui.getString(6));
        }while(!tutorialGrpList.contains(selectedGroup));

        return selectedGroup;
    }



    public String addTutorialGroup(){
        if (tutorialGrpList.add(ui.inputTutorialGroup(courselist, tutorlist))){
            return "Sucessfully Added";
        }else{
            return "Unable to add new Tutorial Group";
        }
    }

    

    public String removeTutorialGroup(){
        if (tutorialGrpList.remove(ui.removeInput(tutorialGrpList))){
            return "Sucessfully Removed";
        }else{
            return "Nothing is removed";
        }
    }

    public void listTutorialGroup(){
        ui.tutorialGroupDisplay(tutorialGrpList);

        int choice;
        ui.print("0 to return to menu");
        do{
            ui.print("Enter your choice");
            choice = ui.getChoice();
        }while (choice != 0);
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
        var test = studentList.contains(new Student(3, "Ross","Bos", "G2S", "FOCS", "Ross@tarc.edu.my" ));
        System.out.println(test);
        System.out.println("\n");

        //remove method
        System.out.println("Does List 1 contains student id 3? after removing it");
        System.out.println("=================");
        studentList.remove(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        var test1 = studentList.contains(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.display();
        System.out.println(test1);
        System.out.println("\n");


        //toJson method
        System.out.println("Print List 1 as JSON string");
        System.out.println("=================");
        var jsontest = studentList.toJSON();
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
            choice = ui.getChoice();
            if(choice == 1){
                return;
            }
        }while(choice != 1);
        
    }
}
