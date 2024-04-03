package control;
import ADT.CircularListInterface;
import Entities.TutorialGroup;
import UI.*;
import dao.Initializer;

public class TutorialManagement {
    Initializer init = new Initializer();
    CircularListInterface<TutorialGroup> tutorialGrpList = init.tutorialGroupListInit();
    CircularListInterface<String> studentlist = init.studentInitString();
    CircularListInterface<String> tutorlist = init.tutorlistinit();
    CircularListInterface<String> courselist = init.courseListInit();
    UI ui = new UI();


    public TutorialManagement(CircularListInterface<TutorialGroup> TG,
     CircularListInterface<String> S, 
     CircularListInterface<String> T, 
     CircularListInterface<String> C){
        studentlist = S;
        tutorialGrpList = TG;
        courselist = C;
        tutorlist = T;
     }

    public CircularListInterface<TutorialGroup> runTutorial(){
        int choice = 0;
        String errorMsg = null;
        
        do {
            ui.tutorialMenuDisplay(errorMsg);
            choice = ui.getChoice(4);
            // Process the user's choice 
            switch (choice) {
                case 1:
                    errorMsg = addTutorialGroup();
                    break;
                case 2:
                    listTutorialGroup();
                    break;
                case 3:
                    errorMsg = removeTutorialGroup();
                    break;
                case 4:
                    editTutorialGroupMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        return tutorialGrpList;
    }

    public String addTutorialGroup(){
        if (tutorialGrpList.add(ui.inputTutorialGroup(courselist, tutorlist))){
            return "Sucessfully Added";
        }else{
            return "Unable to add new Tutorial Group";
        }
    }

    public String removeTutorialGroup(){
        if (tutorialGrpList.remove(ui.removeInput(tutorialGrpList))){
            return "Sucessfully Removed";
        }else{
            return "Nothing is removed";
        }
    }

    public void listTutorialGroup(){
        ui.tutorialGroupDisplay(tutorialGrpList);
        int choice;
        ui.print("0 to return to menu");
        do{
            choice = ui.getChoice(0);
        }while (choice != 0);
    }

    public void editTutorialGroupMenu(){
        String error = null;
        int choice;
        do{
            ui.editGrpMenuDisplay(error);
            choice = ui.getChoice(3);

            switch(choice){
                case 1:
                    error = changeGroupInformationMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
            }   

        }while (choice != 0);

        
    }

    public String changeGroupInformationMenu(){
        String selectedGroup = null;
        String error = null;
        int choice = 0;
        ui.tutorialGroupDisplay(tutorialGrpList);
        ui.print("Please Select the group you want to edit");
        selectedGroup = ui.getString(5);
        if (!tutorialGrpList.contains(new TutorialGroup(selectedGroup))){
            return "Group ID not found";
        }
        do{
            ui.editGrpInformation(error, selectedGroup);
            choice = ui.getChoice(5);
            switch(choice){
                case 1: //Change ID
                    Object[] result = changeID(selectedGroup);
                    error = (String) result[0];
                    if ((String) result[1] != null){
                        selectedGroup = (String) result[1];
                    }
                    break;
                case 2: //Change tutor
                    error = changeTutor(selectedGroup);
                    break;
                case 3: //Change course
                    error = changeCourse(selectedGroup);
                    break;
                case 4: //Add student
                    error = addStudent(selectedGroup);
                    break;
                case 5: //remove student
                    error = removeStudent(selectedGroup);
                    break;
                default: 
            }
        }while(choice != 0);
        
        tutorialGrpList.sort();
        return null;
    }


    public Object[] changeID(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new ID: ");
        String newID = ui.getString(5);

        if (newID == selectedGroupID){
            return new Object[]{"No changes made",newID};
        }
        
        if(tutorialGrpList.contains(new TutorialGroup(newID))){
            return new Object[]{"ID Already Exists",null};
        }

        objectrefs.setId(newID);
        return new Object[]{"ID Changed",newID};
    }

    public String changeTutor(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new Tutor ID: ");
        String newTutor = ui.getString(6);
        objectrefs.setTutor(newTutor);
        return "Sucess";
    }

    public String changeCourse(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new Tutor ID: ");
        String newCourse = ui.getString(6);
        objectrefs.setCourseID(newCourse);
        return "Sucess";
    }

    public String addStudent(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new student Name ID: ");
        String newStudent = ui.getString(10);
        if (objectrefs.getStudentlist().add(newStudent)){
            return "Student Added";
        }
        return "Unable to add new student";
    }

    public String removeStudent(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new student Name ID: ");
        String remStudent = ui.getString(5);
        if (objectrefs.getStudentlist().remove(remStudent)){
            return "Student Removed";
        }
        return "Unable to remove student";
    }   
    
}
