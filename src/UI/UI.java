package UI;

import java.io.IOException;
import java.util.Scanner;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entities.TutorialGroup;

public class UI {
    
    Scanner scanner = new Scanner(System.in);
    public int getChoice(){
        int choice;
        if (!scanner.hasNextInt()) {
            choice = 99;
            scanner.nextLine();
        }else{
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        return choice;
    }

    //Display Menu
    public void mainMenuDisplay(String error){
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

    public void tutorialMenuDisplay(String error){
        clearScreen();
        System.out.println("Tutorial Group Registration");
        System.out.println("-------------------------------");
        System.out.println("1. Add Tutorial Group");
        System.out.println("2. List Tutorial Group");
        System.out.println("3. Remove Tutorial Groups");
        System.out.println("4. Edit Tutorial Group");
        System.out.println("5. Test Codes");
        System.out.println("6. Return to menu");
        System.out.println("0. Exit");

        if (error != null){
            System.out.println("");
            System.out.println(error);
        }
    }

    public TutorialGroup inputTutorialGroup(CircularListInterface<String> course, CircularListInterface<String> tutor){
        TutorialGroup newGroup = new TutorialGroup();
        clearScreen();
        String grpID;
        String courseID;
        String tutorID;
        System.out.println("Tutorial Group Registration");
        System.out.println("-------------------------------");
        System.out.println("Enter Tutorial GroupID");
        grpID = getString(6);
        newGroup.setId(grpID);
        inputTutor(tutor);
        System.out.println("Select Associated Tutor ID");
        tutorID = getString(6);
        newGroup.setTutor(tutorID);
        inputCourse(course);
        System.out.println("Select Associated Course ID");
        courseID = getString(10);
        newGroup.setCourseID(courseID);
        return newGroup;
    }

    public void editGrpMenuDisplay(String error){
        clearScreen();
        System.out.println("Tutorial Group Editor");
        System.out.println("-------------------------------");
        System.out.println("1. change group information");
        System.out.println("2. replace group");
        System.out.println("3. Remove Duplicate groups");
        System.out.println("0. Return");

        if (error != null){
            System.out.println("");
            System.out.println(error);
        }
    }

    public void editGrpInformation(String error){
        clearScreen();
        System.out.println("Change Group Information");
        System.out.println("-------------------------------");
        System.out.println("1. ID");
        System.out.println("2. Tutor");
        System.out.println("3. Course");
        System.out.println("4. Add Student");
        System.out.println("5. Remove Student");
        System.out.println("0. Return");
        if (error != null){
            System.out.println("");
            System.out.println(error);
        }
    }

    public TutorialGroup removeInput(CircularListInterface<TutorialGroup> tut){
        TutorialGroup rmvGroup = new TutorialGroup();
        String id = "";
        System.out.println("Tutorial Group Removal");
        System.out.println("-------------------------------");
        tutorialGroupDisplay(tut);
        System.out.println("Enter the ID of group to be removed: ");
        id = getString(5);
        rmvGroup.setId(id);
        return rmvGroup;
    }

    public void editIDInput(CircularListInterface<TutorialGroup> tut){
        
    }

    


    //TODO: Use Tutor class
    public void inputTutor(CircularListInterface<String> tutor){
        clearScreen();
        System.out.println("SELECT TUTOR LIST");
        System.out.printf("%-4s %-10s\n", "no", "Name");
        int i = 1;
        for (String item: tutor){
            System.out.printf("%-4d %-10s\n", i, item);
            i++;
        }
    }

    public void inputCourse(CircularListInterface<String> course){
        clearScreen();
        System.out.println("SELECT COURSE LIST");
        System.out.printf("%-4s %-10s\n", "no", "course ID");
        int i = 1;
        for (String item: course){
            System.out.printf("%-4d %-10s\n", i, item);
            i++;
        }
    }

    public void tutorialGroupDisplay(CircularListInterface<TutorialGroup> tut){
        clearScreen();
        System.out.println("Tutorial Group List");
        System.out.println("-------------------------------");
        // Print header
        System.out.printf("%-10s%-10s%-10s%-10s\n", "Group ID", "Tutor", "Course", "Student");
        // Print tutorial groups
        for (TutorialGroup group : tut) {
            String groupId = group.getId();
            String tutorId = group.getTutor();
            String courseId = group.getCourseID();
            int studentIds = group.getStudentlist().size();
            
            // Print each tutorial group with proper formatting
            System.out.printf("%-10s%-10s%-10s%-10s\n", groupId, tutorId, courseId, studentIds);
        }

    }

    public void print(String x){
        System.out.println(x);
    }

    /*
     * @param max : specify the maximum lenght of input
     */
    public String getString(int max) {
        String input = "";
        do{
            if(input.length() > max){
                System.out.println("Please Enter between 0 - "+ max +"integer");
            }
            input = scanner.nextLine();
        }while(input.length() > max);
        return input;
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
