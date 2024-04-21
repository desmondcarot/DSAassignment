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
    CircularListInterface<Course> courselist = init.courseProgramListInit();
    CircularListInterface<Program> programlist = init.programListInit(tutorialGrpList);
    CircularListInterface<Tutor> tutorlist = init.tutorInit(tutorialGrpList);


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
                    TutorialManagement tut = new TutorialManagement(tutorialGrpList, studentlist, tutorlist, courselist, programlist);
                    //update the tutorial group master list
                    tutorialGrpList = tut.runTutorial();

                    //update program list with tutorial group
                    programlist = tut.getProgramlist();
                    ui.getString(5);
                    break;
                case 3:
                    CourseManagement course = new CourseManagement(courselist);
                    courselist = course.runCourse();
                    break;
                case 4:
                    TutorManagement tutor = new TutorManagement(tutorlist,tutorialGrpList);
                    tutorlist = tutor.runTutor();
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
        String errMsg = null;
        int choice = 0;
        do{
            UI.clearScreen();
            ui.reportMenu(errMsg);
            choice = ui.getChoice(4);
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
                default:
                    errMsg = "invalid Option";
                    break;
            }
        }while(choice != 0);
    }


    public void tutorialReport(){
        String errMsg = null;
        int choice = 0;
        do{
            UI.clearScreen();
            ui.tutorialReportMenu(errMsg);
            choice = ui.getChoice(6);
            switch (choice) {
                case 1:
                    UI.clearScreen();
                    listAllGroup(tutorialGrpList);
                    break;
                case 2:
                    listEmptyGroup();
                    break;
                case 3:
                    listFullGroup();
                    break;
                case 4:
                    listAvailableGroup();
                    break;
                case 5:
                    errMsg = DetailedGroupReport();
                    break;
                case 6: 
                    errMsg = getTutorialGroupByProgramme();
                default:
                    break;
            }
        }while(choice != 0);
    }

    public void listAllGroup(CircularListInterface<TutorialGroup> t){
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID" , "CourseID" , "Students");
        for (TutorialGroup item: t){
            ui.print("=".repeat(45));
            System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(), item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
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
        ui.getString(999);
    }

    public void listEmptyGroup(){
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID" , "CourseID" , "Students");
        for (TutorialGroup item: tutorialGrpList){
            if (item.getStudentlist().size() == 0){
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(), item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(5);
    }

    public void listFullGroup(){
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID" , "CourseID" , "Students");
        for (TutorialGroup item: tutorialGrpList){
            if (item.getStudentlist().size() >= item.getMaxSize()){
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(), item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(5);
    }

    public void listAvailableGroup(){
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID" , "CourseID" , "Students");
        for (TutorialGroup item: tutorialGrpList){
            int size = item.getStudentlist().size();
            int maxSize = item.getMaxSize();
            if (size <= maxSize && size != 0){
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(), item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(999);
    }

    public String DetailedGroupReport(){
        UI.clearScreen();
        ui.tutorialGroupDisplay(tutorialGrpList);
        ui.print("Select the Group to view their details: ");
        String selectedGroup = ui.getString(6);
        
        if (tutorialGrpList.contains(new TutorialGroup(selectedGroup))){
            UI.clearScreen();
            TutorialGroup TG = tutorialGrpList.getData(new TutorialGroup(selectedGroup));
            CircularListInterface<Student> stdlist = TG.getStudentlist();
            ui.print("=".repeat(45));
            System.out.printf("%-3s %-10s %-10s %-10s %3d/%-3d\n","No." ,TG.getId(), TG.getTutor(), TG.getProgram(), TG.getStudentlist().size(), TG.getMaxSize());
            ui.print("=".repeat(45));
            int x = 1;
            for (Student student: stdlist){
                System.out.printf("%3d. %-10d %-10s %-20s\n", x, student.getId(), student.getName(), student.getEmail());
                x++;
            }
            ui.getString(999);
            return null;
        }else{
            return "Group selected is invalid";
        }
    }

    public String getTutorialGroupByProgramme(){
        UI.clearScreen();
        ui.displayProgram(programlist);
        ui.print("Enter program name to show its tutorial group");
        String s = ui.getString(3);

        if (programlist.contains(new Program(s))){
            Program programrefs = programlist.getData(new Program(s));
            CircularListInterface<TutorialGroup> tgList= programrefs.getTutorialGrouplist();
            if(tgList.size() == 0){
                return "Program has no tutorial Group assigned";
            }
            UI.clearScreen();
            System.out.printf("Program : %s, No of Groups: %d\n", programrefs.getProgramName(), tgList.size());
            System.out.print("=".repeat(45) + "\n");
            listAllGroup(tgList);
            return null;
        }

        return "program not found";
    }
}
