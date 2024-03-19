/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsassignment;

import ADT.StudentCLL;
import Entities.Student;

/**
 *
 * @author Desmond
 */
public class DSAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentCLL<Student> studentList = new StudentCLL<>();
        studentList.add(new Student(1, "Alice", "RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.add(new Student(2, "Bob", "RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentList.add(new Student(3, "Charlie","RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        
        studentList.display();
    }
    
}
