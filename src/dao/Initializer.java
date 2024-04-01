package dao;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entities.Student;
import Entities.TutorialGroup;

public class Initializer {
    

    public CircularListInterface<Student> studentInitialize1(){
        CircularListInterface<Student> studentlist = new CLinkedList<>();
        studentlist.add(new Student(1, "Alice", "RSD", "G1", "FOCS", "Alice@tarc.edu.my" ));
        studentlist.add(new Student(2, "Bob", "RSD", "G1", "FOCS", "Bob@tarc.edu.my" ));
        studentlist.add(new Student(3, "Charlie","RSD", "G1", "FOCS", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student(3, "Carl","RSD", "G1", "FOCS", "Carl@tarc.edu.my" ));
        studentlist.add(new Student(4, "Molly","RSD", "G1", "FOCS", "Molly@tarc.edu.my" ));

        return studentlist;
    }
    public CircularListInterface<Student> studentInitialize2(){
        CircularListInterface<Student> studentlist2 = new CLinkedList<>();
        studentlist2.add(new Student(5, "Bobby","RSD", "G1", "FOCS", "Bobby@tarc.edu.my" ));
        studentlist2.add(new Student(6, "Conny","RSD", "G1", "FOCS", "Conny@tarc.edu.my" ));
        studentlist2.add(new Student(7, "Polly","RSD", "G1", "FOCS", "Polly@tarc.edu.my" ));
        studentlist2.add(new Student(2, "Ken","RSD", "G1", "FOCS", "Ken@tarc.edu.my" ));
        studentlist2.add(new Student(3, "Sacy","RSD", "G1", "FOCS", "Sacy@tarc.edu.my" ));
        studentlist2.add(new Student(8, "Paul","RSD", "G1", "FOCS", "Paul@tarc.edu.my" ));
        studentlist2.add(new Student(9, "Darren","RSD", "G1", "FOCS", "Darren@tarc.edu.my" ));
        return studentlist2;
    }


    // TODO: change to student class
    public CircularListInterface<String> studentInitString(){
        CircularListInterface<String> studentList = new CLinkedList<>();
        studentList.add("Charlie");
        studentList.add("Bob");
        studentList.add("Carl");
        studentList.add("Sally");
        studentList.add("Dave");
        studentList.add("Chum");
        studentList.add("Chummy");
        studentList.add("John");
        studentList.add("Mike");
        studentList.add("Emily");
        studentList.add("Sarah");
        studentList.add("Alex");
        studentList.add("Jessica");
        studentList.add("Tyler");
        studentList.add("Liam");
        studentList.add("Olivia");
        studentList.add("Ethan");
        studentList.add("Ava");
        studentList.add("Noah");
        studentList.add("Isabella");
        studentList.add("Mason");
        return studentList;
    }

    // TODO: change to tutor class
    public CircularListInterface<String> tutorlistinit(){
        CircularListInterface<String> tutorList = new CLinkedList<>();
        tutorList.add("Tutor1");
        tutorList.add("Tutor2");
        tutorList.add("Tutor3");
        tutorList.add("Tutor4");
        tutorList.add("Tutor5");
        tutorList.add("Tutor6");
        tutorList.add("Tutor7");
        return tutorList;
    }

    // TODO: change to course class
    public CircularListInterface<String> courseListInit(){
        CircularListInterface<String> courseList = new CLinkedList<>();
        courseList.add("Course1");
        courseList.add("Course2");
        courseList.add("Course3");
        courseList.add("Course4");
        courseList.add("Course5");
        courseList.add("Course6");
        courseList.add("Course7");
        return courseList;
    }

    public CircularListInterface<TutorialGroup> tutorialGroupListInit(){
        CircularListInterface<TutorialGroup> tutorialGrouplist = new CLinkedList<>();
        tutorialGrouplist.add(new TutorialGroup("GRP1", "Tutor1", "Course1"));
        tutorialGrouplist.add(new TutorialGroup("GRP2", "Tutor2", "Course2"));
        tutorialGrouplist.add(new TutorialGroup("GRP3", "Tutor3", "Course3"));
        tutorialGrouplist.add(new TutorialGroup("GRP4", "Tutor4", "Course4"));
        tutorialGrouplist.add(new TutorialGroup("GRP5", "Tutor5", "Course5"));
        tutorialGrouplist.add(new TutorialGroup("GRP6", "Tutor6", "Course6"));
        tutorialGrouplist.add(new TutorialGroup("GRP7", "Tutor7", "Course7"));
        tutorialGrouplist.add(new TutorialGroup("GRP8", "Tutor8", "Course8"));
        return tutorialGrouplist;
    }
}
