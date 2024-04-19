/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entity.*;
import UI.*;
import dao.Initializer;

/**
 *
 * @author wongp
 */
public class StudentRegistration {
    Initializer init = new Initializer();
    CircularListInterface<Student> studentlist = new CLinkedList<>();
    CircularListInterface<Course> courselist = new CLinkedList<>();
    CircularListInterface<TutorialGroup> tutorialGroupList = new CLinkedList<>();
    UI ui = new UI();


    public StudentRegistration(
     CircularListInterface<Student> S, 
     CircularListInterface<Course> C,
     CircularListInterface<TutorialGroup> T){
        studentlist = S;
        courselist = C;
        tutorialGroupList = T;
     }

    public CircularListInterface<Student> runStudentRegistration(){
        int choice = 0;
        String errorMsg = null;
        
        do {
            ui.studentRegisterMenu(errorMsg);
            choice = ui.getChoice(4);
            // Process the user's choice 
            switch (choice) {
                case 1:
                    errorMsg = addStudents();
                    break;
                case 2:
                    listStudent();
                    break;
                case 3:
                    errorMsg = removeStudent();
                    break;
                case 4:
                    updateStudentDetails();
                    break;
                case 5:
                    displayRegisteredCourses();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
        return studentlist;
    }

//public String registerStudents() {
//    // Attempt to add the new student to the studentlist
//    if (studentDetailList.add(ui.registerStudent(studentName))) {
//        return "Successfully Added";
//    } else {
//        return "Unable to add new Student";
//    }
//}

    public String removeStudent(){
        if (studentlist.remove(ui.removeStudent(studentlist))){
            return "Sucessfully Removed";
        }else{
            return "Nothing is removed";
        }
    }

    public void listStudent(){
        ui.studentDisplay(studentlist);
        int choice;
        ui.print("0 to return to menu");
        do{
            choice = ui.getChoice(0);
        }while (choice != 0);
    }
    
    public String addStudents() {
        System.out.println("Selected Choice: Add students");
            Student newStudent = ui.registerStudent(courselist);
            studentlist.add(newStudent);
            System.out.println("Successfully Added.");
        return null;
    }
    
        public void updateStudentDetails() {
        System.out.println("Enter the id of the student to be edited:");
        int studentId = ui.getStudentId();
        Student selectedStudent = findStudentById(studentId);

        if (selectedStudent != null) {
            selectedStudent = ui.updateStudentDetails(selectedStudent);
            // No need to call updateStudentDetails() multiple times for different fields

            // Save the updated student to your data store or perform any necessary operations
            // For example, if you're using a list to store students, you might need to update the list:
            // studentList.set(index, selectedStudent);

            System.out.println("Student details updated successfully.");
          
        } else {
            System.out.println("Student not found.");
        }
    }
        
    public void addStudentToCourse() {
        System.out.println("Enter the name of the student to add courses:");
        String studentName = ui.getStudentName(); // Assuming ui.getStudentName() gets the student name from user input
        
        Student selectedStudent = findStudentByName(studentName);
      
        
        if (selectedStudent != null) {
            System.out.println("Enter the courses to add for " + selectedStudent.getName() + " (separate multiple courses by commas):");
            String coursesInput = ui.getCoursesInput(); // Get the course input from user
        
            // Split the courses input by commas
            String[] courseNameToAdd = coursesInput.split(",");
            Course[] courseToAdd = new Course[courseNameToAdd.length];
            for(int i = 0 ; i < courseToAdd.length; i++){
             
                courseToAdd[i]=findCourseByName(courseNameToAdd[i]);
            }
           
            
            
        
            System.out.println("Courses added successfully for " + selectedStudent.getName());
        } else {
            System.out.println("Student not found.");
        }
        
    }
    
    private void displayRegisteredCourses(){
        ui.registeredCoursesDisplay(studentlist);
        int choice;
        ui.print("0 to return to menu");
        do{
            choice = ui.getChoice(0);
        }while (choice != 0);
    }
    
    public Course findCourseByName(String courseName) {
        for (Course course : courselist) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        return null;
}
    

    
    private Student findStudentById(int id) {
        for (Student student : studentlist) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
}
    
    private Student findStudentByName(String studentName){
        for (Student student : studentlist) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }

//    public void editTutorialGroupMenu(){
//        String error = null;
//        int choice;
//        do{
//            ui.editGrpMenuDisplay(error);
//            choice = ui.getChoice(3);
//
//            switch(choice){
//                case 1:
//                    error = changeGroupInformationMenu();
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                default:
//            }   
//
//        }while (choice != 0);
//
//        
//    }  
//
//    public String changeGroupInformationMenu(){
//        String selectedGroup = null;
//        String error = null;
//        int choice = 0;
//        ui.tutorialGroupDisplay(tutorialGrpList);
//        ui.print("Please Select the group you want to edit");
//        selectedGroup = ui.getString(5);
//        if (!tutorialGrpList.contains(new TutorialGroup(selectedGroup))){
//            return "Group ID not found";
//        }
//        do{
//            ui.editGrpInformation(error, selectedGroup);
//            choice = ui.getChoice(5);
//            switch(choice){
//                case 1: //Change ID
//                    Object[] result = changeID(selectedGroup);
//                    error = (String) result[0];
//                    if ((String) result[1] != null){
//                        selectedGroup = (String) result[1];
//                    }
//                    break;
//                case 2: //Change tutor
//                    error = changeTutor(selectedGroup);
//                    break;
//                case 3: //Change course
//                    error = changeCourse(selectedGroup);
//                    break;
//                case 4: //Add student
//                    error = addStudent(selectedGroup);
//                    break;
//                case 5: //remove student
//                    error = removeStudent(selectedGroup);
//                    break;
//                default: 
//            }
//        }while(choice != 0);
//        
//        tutorialGrpList.sort();
//        return null;
//    }
//
//
//    public Object[] changeID(String selectedGroupID){
//        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
//        ui.print("Enter new ID: ");
//        String newID = ui.getString(5);
//
//        if(tutorialGrpList.isEmpty()){
//            return null;
//        }
//
//        if (newID == selectedGroupID){
//            return new Object[]{"No changes made",newID};
//        }
//        
//        if(tutorialGrpList.contains(new TutorialGroup(newID))){
//            return new Object[]{"ID Already Exists",null};
//        }
//
//        objectrefs.setId(newID);
//        return new Object[]{"ID Changed",newID};
//    }
//
//    public String changeTutor(String selectedGroupID){
//        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
//        ui.print("Enter new Tutor ID: ");
//        String newTutor = ui.getString(6);
//        objectrefs.setTutor(newTutor);
//        return "Sucess";
//    }
//
//    public String changeCourse(String selectedGroupID){
//        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
//        ui.print("Enter new Tutor ID: ");
//        String newCourse = ui.getString(6);
//        objectrefs.setCourseID(newCourse);
//        return "Sucess";
//    }
//
//    public String addStudent(String selectedGroupID){
//        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
//        ui.print("Enter new student Name ID: ");
//        String newStudent = ui.getString(10);
//        if (objectrefs.getStudentlist().add(newStudent)){
//            return "Student Added";
//        }
//        return "Unable to add new student";
//    }
//
//    public String removeStudent(String selectedGroupID){
//        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
//        ui.print("Enter new student Name ID: ");
//        String remStudent = ui.getString(5);
//        if (objectrefs.getStudentlist().remove(remStudent)){
//            return "Student Removed";
//        }
//        return "Unable to remove student";
//    }   
//}

}
