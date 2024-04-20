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
                    report();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
    }



    public void report(){
        UI.clearScreen();
        String errMsg = null;
        ui.reportMenu(errMsg);
        int choice = ui.getChoice(4);
        
        switch (choice){
            case 1:
                tutorialReport();
                break;
            case 2:
                //student
            case 3:
                //course
            case 4:
                //Tutor
        }
        
    }


    public void tutorialReport(){
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID" , "CourseID" , "Students");
        for (TutorialGroup item: tutorialGrpList){
            ui.print("=".repeat(45));
            System.out.printf("%-4d %-10s %-10s %-10s %-8d\n", x, item.getId(), item.getTutor(), item.getCourseID(), item.getStudentlist().size());
            ui.print("=".repeat(45));
            if (item.getStudentlist().size() != 0){
                for (Student student: item.getStudentlist()){
                    System.out.printf("%-10d %-10s %-20s\n", student.getId(), student.getName(), student.getEmail());
                }
            }else{
                ui.print("No student.");
            }
            
            x++;
        }

        ui.getString(5);
    }
}
