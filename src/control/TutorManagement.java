package control;

import ADT.CircularListInterface;
import Entity.*;
import UI.*;
import dao.Initializer;

public class TutorManagement {

    Initializer init = new Initializer();
    CircularListInterface<Tutor> tutorList = null;
    CircularListInterface<TutorialGroup> tutorialGrpList = null;
    CircularListInterface<String> tutorlist = init.tutorlistinit();
    CircularListInterface<String> courselist = init.courseListInit();
    UI ui = new UI();

    public TutorManagement(CircularListInterface<Tutor> T,
            CircularListInterface<TutorialGroup> TG) {
        tutorialGrpList = TG;
        tutorList = T;
    }

    public CircularListInterface<Tutor> runTutor() {
        int choice = 0;
        String errorMsg = null;

        do {
            ui.tutoringMenu(errorMsg);//
            choice = ui.getChoice(4);
            // Process the user's choice 
            switch (choice) {
                case 1:
                    errorMsg = assignTutor();
                    break;
                case 2:
                    errorMsg = assignTutorial();
                    break;
                case 3:
                    searchInfo();
                    break;
                case 4:
                    listingMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);
        return tutorList;
    }

    

    public String assignTutor() {
        //ask course and course typ, then tutor
        ui.clearScreen();
        String courseID;
        String tutorName;
        String courseType;
        
        System.out.println("Assigning Tutor ");
        System.out.println("-------------------------------");
        
        ui.inputCourse(courselist);// switched name i think
        System.out.println("Select Associated Course ID");
        
        courseID = ui.getString(10);
        //input and validate it exist
//        boolean i = true;
//        do{
//            courseID = ui.getString(10);
//            if (!courselist.contains(new String(courseID))) {
//                System.out.println("ID not found");
//            }else{
//                i = false;
//            }
//        }while (i);
        
        System.out.println("Select Associated Course Type (T/P/L): ");
        
        courseType = ui.getString(2);
//        i = true;
//        do{
//            courseType = ui.getString(2);
//            if (!tutorlist.contains(new String(courseID))) {
//                System.out.println("ID not found");
//            }else{
//                i = false;
//            }
//        }while (i);
        
        
        
        ui.inputTutor(tutorlist);// switched name i think
        System.out.println("Select Associated Tutor ID");
        tutorName = ui.getString(6);

        Tutor newGroup = new Tutor();
        
        //assign
        
        
        newGroup.addId(tutorList.size());
        newGroup.setcourseName(courseID);
        newGroup.setCourseType(courseType);
        newGroup.setTutor(tutorName);
        
        for (Tutor tutGrp : tutorList) {
            int tId = tutGrp.getId();
            String cType = tutGrp.getCourseType();
            String cId = tutGrp.getcourseName();
            System.out.println(tId+courseID+cId+courseType+cType);
            if (courseID.equals(cId) && courseType .equals(cType)){
                Tutor objectrefs = tutorList.getData(new Tutor(tId));
                objectrefs.setcourseName(courseID);
                objectrefs.setCourseType(courseType);
                objectrefs.setTutor(tutorName);
                break;}
        }
        
        tutorList.add(newGroup);
//        
        
        
        
        
        
        return "Sucessfully Added";
        
    }

    public String assignTutorial() {
        String cId;
        String tName;
        String cType;
        String tutId;
        String error = "";
        int id;
        
        System.out.println("Assigning Tutorial Group ");
        System.out.println("-------------------------------");
        
        ui.inputCourse(courselist);// switched name i think
        System.out.println("Select Associated Course ID");
        cId = ui.getString(10).toUpperCase();
        
        ui.inputTutor(tutorlist);// switched name i think
        System.out.println("Select Associated Tutor ID");
        tName = ui.getString(6).toUpperCase();
        
        ui.tutorialGroupDisplay(tutorialGrpList);// switched name i think
        System.out.println("Select Associated Tutorial Group");
        
        //input and validate it exist
        boolean loop = true;
        do{
            tutId = ui.getString(6).toUpperCase();
            if (!tutorialGrpList.contains(new TutorialGroup(tutId))) {
                System.out.println("ID not found");
            }else{
                loop = false;
            }
        }while (loop);
        
        for (Tutor group : tutorList) {
            String tutorID = group.getTutor();
            String courseID = group.getcourseName();
            
            if (courseID.equals(cId)&& tutorID.equals(tName)){
                String groupId = group.getcourseName();
                String tutorId = group.getTutor();
                String courseId = group.getCourseType();
                id = group.getId();
                System.out.printf(courseID+(cId)+tutorID+(tName));
                CircularListInterface<TutorialGroup> groupList = group.getGrouplist();

                
                Tutor objectrefs = tutorList.getData(new Tutor(id));
                TutorialGroup newTutorial = tutorialGrpList.getData(new TutorialGroup(tutId));
                
                if (objectrefs.getGrouplist().add(newTutorial)){
                error = "Student Added";
                }
                else error = "Nothing is removed";
                System.out.printf(error);
            }
        }
        ui.assignTutorialGroup(courselist,tutorlist, tutorList);
        
            return error;
        
    }

    public void searchInfo() {
        String error = null;
        int choice;
        do{
            ui.TutorSearchMenu(error);
            choice = ui.getChoice(3);

            
            switch(choice){
                case 1:
                    searchTutorCourse(); // course under the tutor
                    break;
                case 2:
                    searchCourseTutor(); // tutor that under P,T,L 
                    break;
                case 3:
                    break;
                default:
            }   
        }while (choice != 0);

    }
    
    public void searchTutorCourse(){
    if (!ui.searchTutor(tutorList, tutorlist)){
        System.out.printf("No Course assigned");
    }
    int choice;
    do {
            choice = ui.getChoice(0);
        } while (choice != 0);
    }
     
    public void searchCourseTutor(){
    ui.searchCourse(courselist,tutorList);
    
    int choice;
    do {
            choice = ui.getChoice(0);
        } while (choice != 0);
    }
            
    public void listingMenu(){
        String error = null;
        int choice;
        do{
            ui.listTutoringMenu(error);
            choice = ui.getChoice(3);

            switch(choice){
                case 1:
                    listTutorialGroup();
                    break;
                case 2:
                    listTutorCourse();
                    break;
                case 3:
                    break;
                default:
            }   
        }while (choice != 0);

        
    }  
    
    public void listTutorialGroup() {
        
        ui.TutorDisplay(courselist, tutorList);
        int choice;
        ui.print("0 to return to menu");
        do {
            choice = ui.getChoice(0);
        } while (choice != 0);
    }
    
    public void listTutorCourse() {
        tutorList.sort();
        ui.listTutorCourse(courselist, tutorList);
        int choice;
        ui.print("0 to return to menu");
        do {
            choice = ui.getChoice(0);
        } while (choice != 0);
    }

    
    
}
