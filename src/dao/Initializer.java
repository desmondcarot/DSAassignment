package dao;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entity.*;

public class Initializer {
    
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
    
    public CircularListInterface<Student> studentDetailListInit(){
        CircularListInterface<Student> studentlist = new CLinkedList<>();
        studentlist.add(new Student( "Alice", "RSD", "RSD", "FOCS", "Alice@tarc.edu.my" ));
        studentlist.add(new Student( "Bob", "RSD", "RSD", "FOCS", "Bob@tarc.edu.my" ));
        studentlist.add(new Student( "Charlie","RSD", "RSD", "FOCS", "Charlie@tarc.edu.my" ));
        studentlist.add(new Student( "Carl","RSD", "RSD", "FOCS", "Carl@tarc.edu.my" ));
        studentlist.add(new Student( "Molly","RSD", "RSD", "FOCS", "Molly@tarc.edu.my" ));
        studentlist.add(new Student( "Bobby","RSD", "RSD", "FOCS", "Bobby@tarc.edu.my" ));
        studentlist.add(new Student( "Conny","RSD", "RSD", "FOCS", "Conny@tarc.edu.my" ));
        studentlist.add(new Student("Polly","RSD", "RSD", "FOCS", "Polly@tarc.edu.my" ));
        studentlist.add(new Student( "Ken","RSD", "RSD", "FOCS", "Ken@tarc.edu.my" ));
        studentlist.add(new Student( "Sacy","RSD", "RSD", "FOCS", "Sacy@tarc.edu.my" ));
        studentlist.add(new Student( "Paul","RSD", "RSD", "FOCS", "Paul@tarc.edu.my" ));
        studentlist.add(new Student( "Darren","RSD", "RSD", "FOCS", "Darren@tarc.edu.my" ));
        return studentlist;
    }

    public CircularListInterface<TutorialGroup> tutorialGroupListInit(){
        CircularListInterface<TutorialGroup> tutorialGrouplist = new CLinkedList<>();
        CircularListInterface<Student> stdlist = studentDetailListInit();

        tutorialGrouplist.add(new TutorialGroup("GRP1", "Tutor1", "BACS1011"));
        tutorialGrouplist.add(new TutorialGroup("GRP2", "Tutor2", "BACS1011"));
        tutorialGrouplist.add(new TutorialGroup("GRP3", "Tutor3", "BACS1011"));
        tutorialGrouplist.add(new TutorialGroup("GRP4", "Tutor4", "BACS1012"));
        tutorialGrouplist.add(new TutorialGroup("GRP5", "Tutor5", "BACS1012"));
        tutorialGrouplist.add(new TutorialGroup("GRP6", "Tutor6", "BACS1013"));
        tutorialGrouplist.add(new TutorialGroup("GRP7", "Tutor7", "BACS1014"));
        tutorialGrouplist.add(new TutorialGroup("GRP8", "Tutor8", "BACS1013"));
        TutorialGroup objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP7"));
        
        objectrefs.getStudentlist().add(stdlist.getData(new Student(12)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(1)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(3)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(4)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(5)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(6)));


        return tutorialGrouplist;
    }
    
    public CircularListInterface<String> courseListInitString(){
        CircularListInterface<String> courseList = new CLinkedList<>();
        courseList.add("DataScience");
        courseList.add("Python");
        courseList.add("Java");
        courseList.add("C++");
        courseList.add("Kotlin");
        courseList.add("MobileApplication");
        courseList.add("MySQL");
        courseList.add("ASP.NET");
        courseList.add("HTML");
        return courseList;
    }
        
    public CircularListInterface<String> studentClassInitString(){
        CircularListInterface<String> studentClassList = new CLinkedList<>();
        studentClassList.add("FOCS");
        return studentClassList;
    }
     
     public CircularListInterface<Course> courseProgramListInit(){
        CircularListInterface<Course> courseProgramList = new CLinkedList<>();
        courseProgramList.add(new Course("BACS1011","RSW", "Computer Programming!","Semester1","FOCS",100));
        courseProgramList.add(new Course("BACS1012","RSA", "Computer Networks","Semester1","FOCS",100));
        courseProgramList.add(new Course("BACS1013","RSC", "Database Management Systems","Semester1","FOCS",100));
        courseProgramList.add(new Course("BACS1014","RSB", "Software Engineering Principles","Semester1","FOCS",200));
        courseProgramList.add(new Course("BACS1015","RSA", "Operating Systems Fundamentals","Semester2","FOCS",200));
        courseProgramList.add(new Course("BACS1016","RSB", "Web Development Technologies","Semester3","FOCS",200));
        courseProgramList.add(new Course("BACS1017","RSC", "Cybersecurity Essentials","Semester1","FOCS",300));
        courseProgramList.add(new Course("BACS1018","RSD", "Artificial Intelligence and Machine Learning","Semester2","FOCS",300));
        courseProgramList.add(new Course("BACS1019","RSW", "Cloud Computing Technologies","Semester3","FOCS",300));
        courseProgramList.add(new Course("BACS1010","RSH", "Mobile App Development","Semester1","FOCS",400));
        courseProgramList.add(new Course("BACS1020","RSG", "Computer Graphics and Visualization","Semester2","FOCS",500));
        courseProgramList.add(new Course("BACS1021","RSB", "Internet of Things (IoT) Applications","Semester3","FOCS",700));
        courseProgramList.add(new Course("BACS1022","RSA", "Big Data Analytics","Semester2","FOCS",400));
        courseProgramList.add(new Course("BACS1023","RSB", "Game Development Fundamentals","Semester3","FOCS",500));
        courseProgramList.add(new Course("BACS1024","RSA", "Human-Computer Interaction","Semester1","FOCS",600));
        courseProgramList.add(new Course("BACS1025","RSB", "Embedded Systems Design","Semester3","FOCS",400));
        courseProgramList.add(new Course("BACS1026","RSD", "Parallel and Distributed Computing","Semester2","FOCS",600));
        courseProgramList.add(new Course("BACS1027","RSA", "Cryptography and Network Security","Semester1","FOCS", 1000));

        return courseProgramList;
    }
     
}
