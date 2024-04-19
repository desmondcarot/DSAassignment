package control;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entity.*;
import UI.*;
import dao.Initializer;

public class CourseManagement {

    Initializer init = new Initializer();
    CircularListInterface<Course> courseProgramlist = init.courseProgramListInit();
    CircularListInterface<String> facultyList = new CLinkedList<>();
    CircularListInterface<String> allCourseList = new CLinkedList<>();
    CircularListInterface<String> courseSemesterList = new CLinkedList<>();
    CircularListInterface<String> courseDetailList = new CLinkedList<>();
    UI ui = new UI();

    public CourseManagement(CircularListInterface<Course> CP){
        courseProgramlist = CP;
    }

    public CircularListInterface<Course> runCourse(){
        int choice = 0;
        String errorMsg = null;

        do {
            ui.courseMenuDisplay(errorMsg);
            choice = ui.getChoice(20);
            // Process the user's choice
            switch (choice) {
                case 1:
                    errorMsg = addProgram();
                    break;
                case 2:
                    errorMsg = addCourse();
                    break;
                case 3:
                    listCourseDetails();
                    break;
                case 4:
                    errorMsg = removeProgram();
                    break;
                case 5:
                    errorMsg = removeCourses();
                    break;
                case 6:
                    errorMsg = findCourseInSemester();
                    break;
                case 7:
                    errorMsg = amendCourseDetails();
                    break;
                case 8:
                    errorMsg = listCourseByFaculty();
                    break;
                case 9:
                    errorMsg = listCourseOfProgramme();
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        return courseProgramlist;
    }

    public String addProgram() {
        System.out.println("Selected Choice: Add Program To Course(s)");

        int numberOfInputs = ui.getNumberCourseInputs();
        System.out.println(" ");
        if (numberOfInputs == 1) {

            String courseName = ui.getCourseName();
            Course selectedCourse = findCourseByName(courseName);

            if (selectedCourse != null) {
                Course newCourse = ui.addProgramToCourse(courseName);
                courseProgramlist.addSame(newCourse);
                System.out.println("Successfully Added.");

            } else {
                System.out.println("Course not found.");
                System.out.println("Unable to add new Program.");
                System.out.println(" ");
            }

        }else{
            String programmeName = ui.getProgramName();

            for (int i = 1; i <=numberOfInputs ; i++){
                System.out.println("Course " + i + ": ");
                String courseName = ui.getMultipleCourseName();
                Course newCourse = ui.addProgramToMultiplteCourse(courseName, programmeName);
                
                Course selectedCourse = findCourseByName(courseName);

                if (selectedCourse != null) {
                    courseProgramlist.addSame(newCourse);

                } else {
                    System.out.println("Course not found.");
                    System.out.println("Unable to add new Program.");
                    System.out.println(" ");
                }
            }
            System.out.println("Successfully Added.");

        }

        return " ";
    }

    public String addCourse() {
        System.out.println("Selected Choice: Add Course To Program(s)");

        int numberOfInputs = ui.getNumberProgramInputs();
        System.out.println(" ");
        if (numberOfInputs == 1) {

            String programName = ui.getProgramName();
            Course selectedProgram = findProgramByName(programName);

            if (selectedProgram != null) {
                Course newProgram = ui.addCourseToProgram(programName);
                courseProgramlist.addSame(newProgram);
                System.out.println("Successfully Added.");

            } else {
                System.out.println("Program not found.");
                System.out.println("Unable to add new Course.");
                System.out.println(" ");
            }

        }else{
            String courseName = ui.getCourseName();

            for (int i = 1; i <=numberOfInputs ; i++){
                System.out.println("Program " + i + ": ");
                String programName = ui.getMultipleProgramName();
                Course newProgram = ui.addCourseToMultiplteProgram(courseName, programName);

                Course selectedProgram = findProgramByName(programName);

                if (selectedProgram != null) {
                    courseProgramlist.addSame(newProgram);

                } else {
                    System.out.println("Program not found.");
                    System.out.println("Unable to add new Course.");
                    System.out.println(" ");
                }
            }
            System.out.println("Successfully Added.");

        }


        return " ";
    }



    public String removeProgram() {
        System.out.println("Selected Choice: Remove Program From Course");
        String courseName = ui.getCourseName();
        Course selectedCourse = findCourseByName(courseName);

        if (selectedCourse != null) {
            Course newCourse = ui.removeProgramFromCourse(courseName);
            String programName = newCourse.getProgramName();

            //Validate
            Course InputtedProgram = findCourseContainsProgram(courseName, programName);

            if (InputtedProgram != null){
                if(InputtedProgram.getProgramName().equals(programName) &&
                        InputtedProgram.getCourseName().equals(courseName)){
                    courseProgramlist.remove(InputtedProgram);
                }
                System.out.println("Successfully Removed.");

                System.out.println(" ");
            } else{
                System.out.println("This program " + programName
                        + " is not found in the Course "
                        + courseName);
                System.out.println("Please try again");
                System.out.println(" ");
            }

        } else {
            System.out.println("Course not found.");
            System.out.println("Unable to remove Program.");
            System.out.println(" ");
        }
        return " ";
    }

    public String removeCourses() {
        System.out.println("Selected Choice: Remove Course From Program");
        String programName = ui.getProgramName();
        Course selectedProgram = findProgramByName(programName);

        if (selectedProgram != null) {
            Course newProgram = ui.removeCourseFromProgram(programName);
            String courseName = newProgram.getCourseName();

            //Validate
            Course InputtedCourse = findProgramContainsCourse(courseName, programName);

            if (InputtedCourse != null){
                if(InputtedCourse.getProgramName().equals(programName) &&
                        InputtedCourse.getCourseName().equals(courseName)){
                    courseProgramlist.remove(InputtedCourse);
                }
                System.out.println("Successfully Removed.");

                System.out.println(" ");
            } else{
                System.out.println("This course " + courseName
                        + " is not found in the Program "
                        + programName);
                System.out.println("Please try again");
                System.out.println(" ");
            }

        } else {
            System.out.println("Program not found.");
            System.out.println("Unable to remove Course.");
            System.out.println(" ");
        }
        return " ";
    }


    //Search Courses offered in a semester
    public String findCourseInSemester(){
        System.out.println("Selected Choice: Search Course Offered In Semester");
        String semesterName = ui.getSemesterName();

        Course selectedSemester = findSemesterByName(semesterName);
        if (courseProgramlist.contains(selectedSemester)) {
            System.out.println("These are the Courses in " + semesterName);

            boolean foundCourses = false;

            for (Course course : courseProgramlist) {
                if (course.getSemesterName().equals(semesterName)) {
                    foundCourses = true;
                    //Add to courseSemesterList
                    courseSemesterList.addSame(course.getCourseName());

                }
            }

            //Output the course in courseSemesterList
            System.out.println(" ");
            System.out.println("The list consists of: ");
            facultyList.sort();
            for(String facultyName : courseSemesterList) {
                System.out.println(facultyName);

            }
            courseSemesterList.clear();


            if (!foundCourses) {
                System.out.println(" ");
                System.out.println("No courses found in " + semesterName);
            }
            System.out.println(" ");

            if (foundCourses) {
                System.out.println(" ");
                System.out.println("Enter a course name to search if it's offered in this semester:");
                String inputCourseName = ui.getCourseName();

                boolean courseFound = false;

                for (Course semester : courseProgramlist) {
                    if (semester.getSemesterName().contains(semesterName) &&
                            semester.getCourseName().contains(inputCourseName)) {
                        courseFound = true;
                    }
                }

                if (courseFound) {
                    System.out.println("Yes, the " + inputCourseName +
                            " is found in " + semesterName);
                } else {
                    System.out.println("No, this course is not offered in " + semesterName);
                    System.out.println(" ");
                }
            }

        } else {
            System.out.println("Semester not found.");
        }
        return " ";
    }


    //Amend course details for a programme
    public String amendCourseDetails() {
        System.out.println("Enter the name of the Program to update Course details:");
        String programName = ui.getProgramName();

        Course selectedProgram = findProgramByName(programName);

        if (selectedProgram != null) {

            //Get CourseName
            //List out ALL CourseNames in that Program
            for (Course faculty : courseProgramlist) {
                String programNames = faculty.getProgramName();
                String courseNames = faculty.getCourseName();
                String courseDetails = faculty.getCourseDetails();

                if (programName.equals(programNames)){
                    courseDetailList.addSame(programNames + " - "
                            + courseNames + " - " + courseDetails);

                }
            }

            //Display
            System.out.println(" ");
            System.out.println("The program consists of courses: ");
            courseDetailList.sort();
            for(String facultyName : courseDetailList) {
                System.out.println(facultyName);

            }

            //Now select the course
            String courseName = ui.getCourseName();
            Course selectedCourse = findCourseByName(courseName);


                //Update all details related to this course
            for (Course course : courseProgramlist) {
                if (course.getCourseName().equals(courseName) &&
                        course.getProgramName().equals(programName) ) {
                    System.out.println("-------------------------------");
                    System.out.println("Enter New Course Detail:");

                    String newCourseDetails = ui.getCourseDetail();

                    if(course.getProgramName().equals(programName) &&
                    course.getCourseName().equals(courseName)){
                        assert selectedCourse != null;
                        course.setCourseDetails(newCourseDetails);
                    }

                }
            }
                courseDetailList.clear();
            System.out.println("Succcessfully updated");


        } else {
            System.out.println("Course not found.");
        }
        return " ";
    }


    //List courses taken by different faculties
    public String listCourseByFaculty() {
        facultyList.clear();

        System.out.println("Selected Choice: List Course Taken By Different Faculties");

        for (Course faculty : courseProgramlist) {
            String currentFacultyName = faculty.getFacultyName();
            String courseNames = faculty.getCourseName();

            facultyList.addSame(currentFacultyName + " - " + courseNames);

        }


        System.out.println(" ");
        System.out.println("The faculty list is: ");
        System.out.println("New");
        facultyList.sort();
        for(String facultyName : facultyList) {
            System.out.println(facultyName);

        }

        return " ";
    }


    //List all courses for a programme
    public String listCourseOfProgramme() {
        allCourseList.clear();

        System.out.println("Selected Choice: List ALL Course(s) of 1 Program");

        String programName = ui.getProgramName();
        Course selectedProgram = findProgramByName(programName);

        if (selectedProgram != null) {

            for (Course program : courseProgramlist) {

                String currentProgramName = program.getProgramName();
                String courseNames = program.getCourseName();

                if (currentProgramName.equals(programName)) {
                    allCourseList.addSame(courseNames);
                }
            }

            System.out.println(" ");
            System.out.println("Program: " + programName);
            for(String coursesName : allCourseList) {
                System.out.println(coursesName);


            }

        } else {
            System.out.println("Program not found.");
            System.out.println(" ");
        }

        return " ";
    }



    private Course findCourseByName(String courseName) {
        for (Course course : courseProgramlist) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }
    private Course findProgramByName(String programName) {
        for (Course program : courseProgramlist) {
            if (program.getProgramName().equals(programName)) {
                return program;
            }
        }
        return null;
    }
    private Course findSemesterByName(String semesterName) {
        for (Course semester : courseProgramlist) {
            if (semester.getSemesterName().equals(semesterName)) {
                return semester;
            }
        }
        return null;
    }


    public Course findCourseContainsProgram(String courseName, String programName) {
        for (Course course : courseProgramlist) {
            if ((course.getProgramName().equals(programName)) &&
                    (course.getCourseName().equals(courseName))) {
                return course;
            }
        }
        return null;
    }
    public Course findProgramContainsCourse(String courseName, String programName) {
        for (Course program : courseProgramlist) {
            if ((program.getCourseName().equals(courseName)) &&
                    (program.getProgramName().equals(programName))) {
                return program;
            }
        }
        return null;
    }


    public void listCourseDetails() {
        System.out.println("List of Courses Details:");
        int index = 1;
        for (Course course : courseProgramlist) {
            System.out.println(index + ". " + course);
            index++;
        }
        ui.getString(99);
    }




}
