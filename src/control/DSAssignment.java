/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import ADT.CircularListInterface;
import Entity.*;
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
    CircularListInterface<Student> studentlist = init.studentDetailListInit();
    CircularListInterface<String> tutorlist = init.tutorlistinit();
    CircularListInterface<Course> courselist = init.courseProgramListInit();

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
                    StudentRegistration std = new StudentRegistration(studentlist, courselist, tutorialGrpList);
                    studentlist = std.runStudentRegistration();
                    break;
                case 2:
                    TutorialManagement tut = new TutorialManagement(tutorialGrpList, studentlist, tutorlist, courselist);
                    //update the tutorial group master list
                    tutorialGrpList = tut.runTutorial();
                    break;
                case 3:
                    CourseManagement course = new CourseManagement(courselist);
                    courselist = course.runCourse();
                    break;
                case 4:
                    System.out.println("Tutor Registration selected.");
                    // Add your tutor registration logic here
                    break;
                case 5:
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }
}
