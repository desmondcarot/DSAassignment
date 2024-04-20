package UI;

import java.io.IOException;
import java.util.Scanner;

import ADT.CircularListInterface;
import Entity.*;

public class UI {
    //Tutorial Management UI
    //Desmond
    Scanner scanner = new Scanner(System.in);

    //Display Menu
    public void mainMenuDisplay(String error){
        clearScreen();
        System.out.println("UNIVERSITY SYSTEM");
        System.out.println("-------------------------------");
        System.out.println("1. Student Registration");
        System.out.println("2. Tutorial Management");
        System.out.println("3. Course Management");
        System.out.println("4. Tutor Management");
        System.out.println("5. Report");
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
        System.out.println("0. Return to menu");

        if (error != null){
            System.out.println("");
            System.out.println(error);
        }
    }

    public TutorialGroup inputTutorialGroup(CircularListInterface<Course> course, CircularListInterface<String> tutor){
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
        displayTutor(tutor);
        System.out.println("Select Associated Tutor ID");
        tutorID = getString(6);
        newGroup.setTutor(tutorID);
        displayCourse(course);
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

    public void editGrpInformation(String error, String selectedGroup){
        clearScreen();
        System.out.println("Change Group Information for " + selectedGroup);
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

    //TODO: Use Tutor class
    public void displayTutor(CircularListInterface<String> tutor){
        clearScreen();
        System.out.println("SELECT TUTOR LIST");
        System.out.printf("%-4s %-10s\n", "no", "Name");
        int i = 1;
        for (String item: tutor){
            System.out.printf("%-4d %-10s\n", i, item);
            i++;
        }
    }

    public void displayCourse(CircularListInterface<Course> course){
        clearScreen();
        System.out.println("SELECT COURSE LIST");
        System.out.printf("%-10s %-10s\n", "Course ID", "Course name");
        for (Course item: course){
            System.out.printf("%-10s %-10s\n", item.getCourseId(), item.getCourseName());
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

    /**
     * @param max : specify the maximum lenght of input
     */
    public String getString(int max) {
        String input = "";
        do{
            if(input.length() > max){
                System.out.println("Please Enter between 0 - "+ max +" Characters");
            }
            input = scanner.nextLine();
        }while(input.length() > max);
        return input;
    }
    
    /**
     * @param max : specify the max choice user can select
     * @return an int of the choice selected by user
     */
    public int getChoice(int max){
        int maxinput = max;
        int choice = 20202;
        do{
            System.out.println("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                print("Invalid Choice!");
                choice = 99999;
                scanner.nextLine();
            }else{
                choice = scanner.nextInt();
                scanner.nextLine();
            }
        }while (choice < 0 || choice > maxinput);

        return choice;
    }

    //method to clear CLI for linux and windows
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

    //Student Registration UI
    //Wongwh
    public void studentRegisterMenu(String error){
        clearScreen();
        System.out.println("Student Registration");
        System.out.println("-------------------------------");
        System.out.println("1. Add Students");
        System.out.println("2. List Students");
        System.out.println("3. Remove Students");
        System.out.println("4. Edit Students Details");
        System.out.println("5. Display registered courses");
        System.out.println("0. Return to menu");
        System.out.println("-------------------------------");
    }

    public Student removeStudent(CircularListInterface<Student> std) {
        Student rmvStd = new Student();
        int id = -1; // Initialize id with a default value

        System.out.println("Student Removal");
        System.out.println("-------------------------------");
        studentDisplay(std);
        System.out.println("Enter the ID of the student to be removed: ");
        id = Integer.parseInt(getString(5)); // Convert user input from String to int
        rmvStd.setId(id);
        return rmvStd;
    }

    public void studentDisplay(CircularListInterface<Student> std){
        clearScreen();
        System.out.println("Student List");
        System.out.println("-------------------------------");
        // Print header
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Student ID", "Name", "Course", "Programme","Class","Email");
        // Print tutorial groups
        for (Student stu : std) {
            int studentID = stu.getId();
            String name = stu.getName();
            String course = stu.getCourse();
            String programme = stu.getProgramme();
            String stuClass = stu.getStudentClass();
            String email = stu.getEmail();
            
            
            // Print each tutorial group with proper formatting
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", studentID, name,course, programme, stuClass,email);
        }
    }

    public Student registerStudent(CircularListInterface<Course> courseProgramList){
        Student newStudent = new Student();
        clearScreen();
        String studentName = null;
        String studentProgramme = null;
        String studentCourse = null;
        String studentEmail = null;
        String studentClass = null;
        
        newStudent.setName(studentName);
        newStudent.setProgramme(studentProgramme);
        newStudent.setCourse(studentCourse);
        newStudent.setEmail(studentEmail);
        newStudent.setStudentClass(studentClass);
        
        System.out.println("-------------------------------");
        System.out.println("Enter the name");
        studentName = getString(100);
        newStudent.setName(studentName);

        System.out.println("-------------------------------");
        System.out.println("Enter the programme");
        studentProgramme = getString(100);
        newStudent.setProgramme(studentProgramme);
        
        System.out.println("-------------------------------");
        System.out.println("Enter the course");
        studentCourse = getString(100);
        newStudent.setCourse(studentCourse);
        newStudent.addCourse(studentCourse, courseProgramList);
        
        System.out.println("-------------------------------");
         System.out.println("Enter the student class");
        studentClass = getString(100);
        newStudent.setStudentClass(studentClass);
        
        System.out.println("-------------------------------");
        System.out.println("Enter the email");
        studentEmail = getString(100);
        newStudent.setEmail(studentEmail);

        return newStudent;
    }

    public int getStudentId() {
        System.out.print("Enter the id of student: ");
        String idString = scanner.nextLine();
        getString(10);
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return getStudentId();
        }
    }

    public Student updateStudentDetails(Student selectedStudent) {
        boolean isEditing = true;
        while (isEditing) {
            clearScreen();
            System.out.println("Update Student Detail");
            System.out.println("-------------------------------");
            System.out.println("Selected Student ID: " + selectedStudent.getId());
            System.out.println("Choose which detail you want to edit:");
            System.out.println("1. Student Name");
            System.out.println("2. Student Course");
            System.out.println("3. Student Programme");
            System.out.println("4. Student Class");
            System.out.println("5. Student Email");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getChoice(6);
            
            switch (choice) {
                case 1:
                    System.out.println("Enter New Name: ");
                    String newStudentName = scanner.nextLine();
                    selectedStudent.setName(newStudentName);
                    break;
                case 2:
                    System.out.println("Enter New Course: ");
                    String newCourse = scanner.nextLine().toUpperCase();
                    selectedStudent.setCourse(newCourse);
                    break;
                case 3:
                    System.out.println("Enter New Programme: ");
                    String newProgramme = scanner.nextLine().toUpperCase();
                    selectedStudent.setProgramme(newProgramme);
                    break;
                case 4:
                    System.out.println("Enter New Student Class: ");
                    String newStudentClass = scanner.nextLine().toUpperCase();
                    selectedStudent.setStudentClass(newStudentClass);
                    break;
                case 5:
                    System.out.println("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    selectedStudent.setEmail(newEmail);
                    break;
                case 6:
                    isEditing = false; // Exit the loop to return to main menu
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        return selectedStudent;
    }
    
    public String getStudentName() {
        System.out.print("Enter the student name: ");
        return getString(10);
    }

    public String getCoursesInput(){
        System.out.print("Enter the courses to be added: ");
        return getString(5);
    }

    public void registeredCoursesDisplay(CircularListInterface<Student> std){
        clearScreen();
        System.out.println("Registered Course List");
        System.out.println("-------------------------------");
        // Print header
        System.out.printf("%-10s%-10s%-10s\n", "Name", "Course", "CoursePrice" );
        // Print tutorial groups
        for (Student stu : std) {
            String name = stu.getName();
            CircularListInterface<Course> courseList = stu.getStudentCourseList();
            // Print each tutorial group with proper formatting
            for(Course course: courseList){
                System.out.printf("%-10s%-10s%-10s\n", name,course.getCourseName(),course.getCoursePrice());
            }
        }
    }

    public void courselistDisplay(CircularListInterface<Course> courselist){
        System.out.printf("%-10s %-10s\n2", "Course ID", "Course Name");
        for (Course course: courselist){
            System.out.printf("%-10s %-10s\n", course.getCourseId(), course.getCourseName());
        }
    }

    //Course managment UI
    //Chia Hang
    public void courseMenuDisplay(String error) {
        clearScreen();
        System.out.println(" ");
        System.out.println("Course Management");
        System.out.println("-------------------------------");
        System.out.println("1. Add a Program to Course(s)");
        System.out.println("2. Add a Course to Program(s)");
        System.out.println("3. List the Program and Course");
        System.out.println("4. Remove a Program from Course");
        System.out.println("5. Remove a Course from Program");
        System.out.println("6. Search Course offered in Semester");
        System.out.println("7. Amend Course details for a Programme");
        System.out.println("8. List Courses taken by Faculties");
        System.out.println("9. List All Courses of One Program");

        if (error != null) {
            System.out.println("");
            System.out.println(error);
        }

        
    }

    public int getNumberCourseInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("This program will be added to how many course(s)?");
        return scanner.nextInt();
    }

    public int getNumberProgramInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("This course will be added to how many program(s)?");
        return scanner.nextInt();
    }

    public String getSemesterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the semester: ");
        return scanner.nextLine();
    }

    public String getMultipleCourseName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getMultipleProgramName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getProgramName() {
        System.out.print("Enter the name of the program: ");
        System.out.println("E.g. of Program: RSW, RSD, RSF ");
        return getString(3);
    }
    
    public String getCourseName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the name of the Courses");
        System.out.println("E.g. of Course: Course1, Course2 ");
        return scanner.nextLine();
    }

    public Course addProgramToCourse(String courseName){
        Course newCourse = new Course();
        clearScreen();
        String programName;

        newCourse.setCourseName(courseName);

        System.out.println("-------------------------------");
        System.out.println("Enter the name of the New Program to be added into the Course(s):");
        System.out.println("E.g. of Program: RSW, RSD, RSF ");
        programName = getString(100);
        newCourse.setProgramName(programName);


        return newCourse;
    }

    public Course addProgramToMultiplteCourse(String courseName, String programName){
        Course newCourse = new Course();
        clearScreen();

        newCourse.setCourseName(courseName);
        newCourse.setProgramName(programName);


        return newCourse;
    }

    public Course addCourseToProgram(String programName){
        Course newProgram = new Course();
        clearScreen();
        String courseName;

        newProgram.setProgramName(programName);

        System.out.println("-------------------------------");
        System.out.println("Enter the name of the New Course to be added into the Program(s):");
        System.out.println("E.g. of Course: OOP, DSA, C++ ");
        courseName = getString(100);
        newProgram.setCourseName(courseName);

        return newProgram;
    }

    public Course addCourseToMultiplteProgram(String courseName, String programName){
        Course newCourse = new Course();
        clearScreen();

        newCourse.setCourseName(courseName);
        newCourse.setProgramName(programName);


        return newCourse;
    }
    
    public Course removeProgramFromCourse(String courseName){
        Course newCourse = new Course();
        clearScreen();
        String programName;

        newCourse.setCourseName(courseName);

        System.out.println("-------------------------------");
        System.out.println("Enter the name of the Program to be removed from the Course:");
        programName = getString(20);
        newCourse.setProgramName(programName);

        return newCourse;
    }

    public Course removeCourseFromProgram(String programName){
        Course newCourse = new Course();
        clearScreen();
        String courseName;

        newCourse.setProgramName(programName);

        System.out.println("-------------------------------");
        System.out.println("Enter the name of the Course to be removed from the Program:");
        courseName = getString(20);
        newCourse.setCourseName(courseName);

        return newCourse;
    }

    public String getCourseDetail() {
        clearScreen();
        String coursing = getString(100);

        return coursing;
    }


    public void reportMenu(String erroString){
        print("REPORT MENU");
        print("==============");
        print("1. Tutorial report");
        print("2. Student Report");
        print("3. Course Report");
        print("4. Tutor Report");

        if (erroString != null){
            print(erroString);
        }
    }
}
