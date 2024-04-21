package dao;

import ADT.CLinkedList;
import ADT.CircularListInterface;
import Entity.*;

public class Initializer {

    //desmond Tutorial Group Init
    public CircularListInterface<TutorialGroup> tutorialGroupListInit(CircularListInterface<Student> t) {
        CircularListInterface<TutorialGroup> tutorialGrouplist = new CLinkedList<>();
        CircularListInterface<Student> stdlist = t;

        tutorialGrouplist.add(new TutorialGroup("GRP1", "unassigned", "RSA", 16));
        tutorialGrouplist.add(new TutorialGroup("GRP2", "unassigned", "RSA", 16));
        tutorialGrouplist.add(new TutorialGroup("GRP3", "unassigned", "RSA", 16));
        tutorialGrouplist.add(new TutorialGroup("GRP4", "unassigned", "RSB", 24));
        tutorialGrouplist.add(new TutorialGroup("GRP5", "unassigned", "RSB", 24));
        tutorialGrouplist.add(new TutorialGroup("GRP6", "unassigned", "RSB", 24));
        tutorialGrouplist.add(new TutorialGroup("GRP7", "unassigned", "RSC", 12));
        tutorialGrouplist.add(new TutorialGroup("GRP8", "unassigned", "RSC", 12));

        TutorialGroup objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP7"));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(37)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(42)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(41)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(40)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(39)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(38)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(36)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(35)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(34)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(33)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(32)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(31)));

        objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP1"));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(1)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(2)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(3)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(4)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(5)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(6)));

        objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP4"));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(7)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(8)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(9)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(10)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(11)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(12)));

        objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP3"));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(13)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(14)));

        objectrefs = tutorialGrouplist.getData(new TutorialGroup("GRP8"));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(15)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(16)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(17)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(18)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(19)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(20)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(21)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(22)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(23)));
        objectrefs.getStudentlist().add(stdlist.getData(new Student(24)));

        return tutorialGrouplist;
    }

    //init program with tutorial groups
    public CircularListInterface<Program> programListInit(CircularListInterface<TutorialGroup> T){
        CircularListInterface<Program> programlist = new CLinkedList<>();
        CircularListInterface<TutorialGroup> tutorialGrpList = T;
        programlist.add(new Program("RSA"));
        programlist.add(new Program("RSB"));
        programlist.add(new Program("RSC"));
        programlist.add(new Program("RSD"));
        programlist.add(new Program("RSE"));
        programlist.add(new Program("RSF"));
        programlist.add(new Program("RSG"));
        programlist.add(new Program("RSH"));
        programlist.add(new Program("RSW"));

        programlist.getData(new Program("RSA"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP1")));
        
        programlist.getData(new Program("RSA"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP2")));

        programlist.getData(new Program("RSA"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP3")));

        programlist.getData(new Program("RSB"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP4")));

        programlist.getData(new Program("RSB"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP5")));

        programlist.getData(new Program("RSB"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP6")));

        programlist.getData(new Program("RSC"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP7")));

        programlist.getData(new Program("RSC"))
            .getTutorialGrouplist()
            .add(tutorialGrpList.getData(new TutorialGroup("GRP8")));

        return programlist;
        
    }

    //Wongwh studentlist init
    public CircularListInterface<Student> studentDetailListInit() {
        CircularListInterface<Student> studentlist = new CLinkedList<>();
        studentlist.add(new Student("Alice", "RSD", "RSD", "FOCS", "Alice@tarc.edu.my"));
        studentlist.add(new Student("Bob", "RSD", "RSD", "FOCS", "Bob@tarc.edu.my"));
        studentlist.add(new Student("Charlie", "RSD", "RSD", "FOCS", "Charlie@tarc.edu.my"));
        studentlist.add(new Student("Carl", "RSD", "RSD", "FOCS", "Carl@tarc.edu.my"));
        studentlist.add(new Student("Molly", "RSD", "RSD", "FOCS", "Molly@tarc.edu.my"));
        studentlist.add(new Student("Bobby", "RSD", "RSD", "FOCS", "Bobby@tarc.edu.my"));
        studentlist.add(new Student("Conny", "RSD", "RSD", "FOCS", "Conny@tarc.edu.my"));
        studentlist.add(new Student("Polly", "RSD", "RSD", "FOCS", "Polly@tarc.edu.my"));
        studentlist.add(new Student("Ken", "RSD", "RSD", "FOCS", "Ken@tarc.edu.my"));
        studentlist.add(new Student("Sacy", "RSD", "RSD", "FOCS", "Sacy@tarc.edu.my"));
        studentlist.add(new Student("Paul", "RSD", "RSD", "FOCS", "Paul@tarc.edu.my"));
        studentlist.add(new Student("Darren", "RSD", "RSD", "FOCS", "Darren@tarc.edu.my"));
        studentlist.add(new Student("Eva", "RSD", "RSD", "FOCS", "Eva@tarc.edu.my"));
        studentlist.add(new Student("Fiona", "RSD", "RSD", "FOCS", "Fiona@tarc.edu.my"));
        studentlist.add(new Student("Gary", "RSD", "RSD", "FOCS", "Gary@tarc.edu.my"));
        studentlist.add(new Student("Hannah", "RSD", "RSD", "FOCS", "Hannah@tarc.edu.my"));
        studentlist.add(new Student("Ian", "RSD", "RSD", "FOCS", "Ian@tarc.edu.my"));
        studentlist.add(new Student("Jenny", "RSD", "RSD", "FOCS", "Jenny@tarc.edu.my"));
        studentlist.add(new Student("Kevin", "RSD", "RSD", "FOCS", "Kevin@tarc.edu.my"));
        studentlist.add(new Student("Linda", "RSD", "RSD", "FOCS", "Linda@tarc.edu.my"));
        studentlist.add(new Student("Michael", "RSD", "RSD", "FOCS", "Michael@tarc.edu.my"));
        studentlist.add(new Student("Nancy", "RSD", "RSD", "FOCS", "Nancy@tarc.edu.my"));
        studentlist.add(new Student("Olivia", "RSD", "RSD", "FOCS", "Olivia@tarc.edu.my"));
        studentlist.add(new Student("Peter", "RSD", "RSD", "FOCS", "Peter@tarc.edu.my"));
        studentlist.add(new Student("Queenie", "RSD", "RSD", "FOCS", "Queenie@tarc.edu.my"));
        studentlist.add(new Student("Roger", "RSD", "RSD", "FOCS", "Roger@tarc.edu.my"));
        studentlist.add(new Student("Sarah", "RSD", "RSD", "FOCS", "Sarah@tarc.edu.my"));
        studentlist.add(new Student("Tom", "RSD", "RSD", "FOCS", "Tom@tarc.edu.my"));
        studentlist.add(new Student("Uma", "RSD", "RSD", "FOCS", "Uma@tarc.edu.my"));
        studentlist.add(new Student("Victor", "RSD", "RSD", "FOCS", "Victor@tarc.edu.my"));
        studentlist.add(new Student("Wendy", "RSD", "RSD", "FOCS", "Wendy@tarc.edu.my"));
        studentlist.add(new Student("Xander", "RSD", "RSD", "FOCS", "Xander@tarc.edu.my"));
        studentlist.add(new Student("Yara", "RSD", "RSD", "FOCS", "Yara@tarc.edu.my"));
        studentlist.add(new Student("Zack", "RSD", "RSD", "FOCS", "Zack@tarc.edu.my"));
        studentlist.add(new Student("Anna", "RSD", "RSD", "FOCS", "Anna@tarc.edu.my"));
        studentlist.add(new Student("Ben", "RSD", "RSD", "FOCS", "Ben@tarc.edu.my"));
        studentlist.add(new Student("Cathy", "RSD", "RSD", "FOCS", "Cathy@tarc.edu.my"));
        studentlist.add(new Student("David", "RSD", "RSD", "FOCS", "David@tarc.edu.my"));
        studentlist.add(new Student("Emma", "RSD", "RSD", "FOCS", "Emma@tarc.edu.my"));
        studentlist.add(new Student("Frank", "RSD", "RSD", "FOCS", "Frank@tarc.edu.my"));
        studentlist.add(new Student("Grace", "RSD", "RSD", "FOCS", "Grace@tarc.edu.my"));
        studentlist.add(new Student("Henry", "RSD", "RSD", "FOCS", "Henry@tarc.edu.my"));
        return studentlist;
    }

    
    public CircularListInterface<String> studentClassInitString() {
        CircularListInterface<String> studentClassList = new CLinkedList<>();
        studentClassList.add("FOCS");
        return studentClassList;
    }




    //Chia Hang Course List init
    public CircularListInterface<Course> courseProgramListInit() {
        CircularListInterface<Course> courseProgramList = new CLinkedList<>();
        courseProgramList.add(new Course("BACS1011", "RSW", "Computer Programming!", "Semester1", "FOCS", 100));
        courseProgramList.add(new Course("BACS1012", "RSA", "Computer Networks", "Semester1", "FOCS", 100));
        courseProgramList.add(new Course("BACS1013", "RSC", "Database Management Systems", "Semester1", "FOCS", 100));
        courseProgramList
                .add(new Course("BACS1014", "RSB", "Software Engineering Principles", "Semester1", "FOCS", 200));
        courseProgramList
                .add(new Course("BACS1015", "RSA", "Operating Systems Fundamentals", "Semester2", "FOCS", 200));
        courseProgramList.add(new Course("BACS1016", "RSB", "Web Development Technologies", "Semester3", "FOCS", 200));
        courseProgramList.add(new Course("BACS1017", "RSC", "Cybersecurity Essentials", "Semester1", "FOCS", 300));
        courseProgramList.add(new Course("BACS1018", "RSD", "Artificial Intelligence and Machine Learning", "Semester2",
                "FOCS", 300));
        courseProgramList.add(new Course("BACS1019", "RSW", "Cloud Computing Technologies", "Semester3", "FOCS", 300));
        courseProgramList.add(new Course("BACS1010", "RSH", "Mobile App Development", "Semester1", "FOCS", 400));
        courseProgramList
                .add(new Course("BACS1020", "RSG", "Computer Graphics and Visualization", "Semester2", "FOCS", 500));
        courseProgramList
                .add(new Course("BACS1021", "RSB", "Internet of Things (IoT) Applications", "Semester3", "FOCS", 700));
        courseProgramList.add(new Course("BACS1022", "RSA", "Big Data Analytics", "Semester2", "FOCS", 400));
        courseProgramList.add(new Course("BACS1023", "RSB", "Game Development Fundamentals", "Semester3", "FOCS", 500));
        courseProgramList.add(new Course("BACS1024", "RSA", "Human-Computer Interaction", "Semester1", "FOCS", 600));
        courseProgramList.add(new Course("BACS1025", "RSB", "Embedded Systems Design", "Semester3", "FOCS", 400));
        courseProgramList
                .add(new Course("BACS1026", "RSD", "Parallel and Distributed Computing", "Semester2", "FOCS", 600));
        courseProgramList
                .add(new Course("BACS1027", "RSA", "Cryptography and Network Security", "Semester1", "FOCS", 1000));

        return courseProgramList;
    }

    

 

    


    //chiyan Tutor List
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

    public CircularListInterface<Tutor> tutorInit(CircularListInterface<TutorialGroup> T){
        CircularListInterface<Tutor> tutorCourselist = new CLinkedList<>();
        CircularListInterface<TutorialGroup> tutorialList = T;
        
        tutorCourselist.add(new Tutor(1,"BACS1003", "Tutor1","P"));
        tutorCourselist.add(new Tutor(2,"BACS1203", "Tutor2","L"));
        tutorCourselist.add(new Tutor(3,"BACS1203", "Tutor3","T"));
        tutorCourselist.add(new Tutor(4,"BAMS1303", "Tutor4","T"));
        tutorCourselist.add(new Tutor(5,"BACS1403", "Tutor1","T"));
        tutorCourselist.add(new Tutor(6,"BAMS1003", "Tutor6","P"));
        tutorCourselist.add(new Tutor(7,"BAMS1003", "Tutor7","L"));
        tutorCourselist.add(new Tutor(8,"BACS1403", "Tutor7","L"));
        tutorCourselist.add(new Tutor(9,"BACS1203", "Tutor3","L"));
        tutorCourselist.add(new Tutor(10,"BACS1403", "Tutor7","L"));
        Tutor objectrefs2 = tutorCourselist.getData(new Tutor (4));
        Tutor objectrefs1 = tutorCourselist.getData(new Tutor (3));
        Tutor objectrefs = tutorCourselist.getData(new Tutor (6));
        
        objectrefs.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP1")));
        objectrefs.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP2")));
        objectrefs.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP3")));
        
        objectrefs1.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP1")));
        objectrefs1.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP3")));
        objectrefs1.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP4")));
        objectrefs1.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP2")));
        objectrefs2.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP1")));
        objectrefs2.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP2")));
        objectrefs2.getGrouplist().add(tutorialList.getData(new TutorialGroup("GRP3")));
        return tutorCourselist;
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
}
