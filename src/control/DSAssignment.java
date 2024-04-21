/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import ADT.CLinkedList;
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
    CircularListInterface<Student> studentlist = init.studentDetailListInit();
    CircularListInterface<TutorialGroup> tutorialGrpList = init.tutorialGroupListInit(studentlist);
    CircularListInterface<Course> courselist = init.courseProgramListInit();
    CircularListInterface<Program> programlist = init.programListInit(tutorialGrpList);
    CircularListInterface<Tutor> tutorlist = init.tutorInit(tutorialGrpList);

    public static void main(String[] args) {
        DSAssignment run = new DSAssignment();
        run.runMenu();
    }

    public void runMenu() {
        int choice = 0;
        String errorMsg = null;
        do {
            ui.mainMenuDisplay(errorMsg);
            choice = ui.getChoice(4);
            // Process the user's choice
            switch (choice) {
                case 1:
                    StudentRegistration std = new StudentRegistration(studentlist, courselist, tutorialGrpList);
                    studentlist = std.runStudentRegistration();
                    break;
                case 2:
                    TutorialManagement tut = new TutorialManagement(tutorialGrpList, studentlist, tutorlist, courselist,
                            programlist);
                    // update the tutorial group master list
                    tutorialGrpList = tut.runTutorial();

                    // update program list with tutorial group
                    programlist = tut.getProgramlist();
                    break;
                case 3:
                    CourseManagement course = new CourseManagement(courselist);
                    courselist = course.runCourse();
                    break;
                case 4:
                    TutorManagement tutor = new TutorManagement(tutorlist, tutorialGrpList);
                    tutorlist = tutor.runTutor();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }

   
}
