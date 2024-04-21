package control;
import ADT.CircularListInterface;
import Entity.*;
import UI.*;
import dao.Initializer;


/**
 * @author Desmond
 */
public class TutorialManagement {
    Initializer init = new Initializer();
    CircularListInterface<TutorialGroup> tutorialGrpList = null;
    CircularListInterface<Student> studentlist = null;
    CircularListInterface<Tutor> tutorlist = null;
    CircularListInterface<Course> courselist = null;
    CircularListInterface<Program> programlist = null;
    UI ui = new UI();


    public TutorialManagement(CircularListInterface<TutorialGroup> TG,
     CircularListInterface<Student> S, 
     CircularListInterface<Tutor> T, 
     CircularListInterface<Course> C,
     CircularListInterface<Program> P){
        studentlist = S;
        tutorialGrpList = TG;
        courselist = C;
        tutorlist = T;
        programlist = P;
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
                    errorMsg = changeGroupInformationMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        return tutorialGrpList;
    }

    public String addTutorialGroup(){
        TutorialGroup newGroup = ui.inputTutorialGroup(programlist, tutorlist);
        if (newGroup != null){
            if (tutorialGrpList.add(newGroup)){
                //add tutorial group to program
                programlist.getData(new Program(newGroup.getProgram())).getTutorialGrouplist().add(newGroup);
                return "Sucessfully Added";
            }else{
                return "Unable to add new Tutorial Group";
            }
        }

        return "unable to add new Tutorial Group";
        
    }

    public String removeTutorialGroup(){
        TutorialGroup remGroup = ui.removeTutorialGroupInput(tutorialGrpList);
        if(tutorialGrpList.contains(remGroup)){
            String program = tutorialGrpList.getData(remGroup).getProgram();
            Program programref = programlist.getData(new Program(program));
            if (tutorialGrpList.remove(remGroup)){
                programref.getTutorialGrouplist().remove(remGroup);
                return "Group "+ remGroup.getId() + " removed";
            }else{
                return "Nothing is removed";
            }
        }
        return "Nothing is removed";
    }

    public void listTutorialGroup(){
        ui.tutorialGroupDisplay(tutorialGrpList);
        int choice;
        ui.print("0 to return to menu");
        do{
            choice = ui.getChoice(0);
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
            choice = ui.getChoice(4);
            switch(choice){
                case 1: //Change ID
                    Object[] result = changeID(selectedGroup);
                    error = (String) result[0];
                    if ((String) result[1] != null){
                        selectedGroup = (String) result[1];
                    }
                    break;
                // case 2: //Change tutor
                //     error = changeTutor(selectedGroup);
                //     break;
                case 2: //Change course
                    error = changeProgram(selectedGroup);
                    break;
                case 3: //Add student
                    error = addStudent(selectedGroup);
                    break;
                case 4: //remove student
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

        if(tutorialGrpList.isEmpty()){
            return null;
        }

        if (newID == selectedGroupID){
            return new Object[]{"No changes made",newID};
        }
        
        if(tutorialGrpList.contains(new TutorialGroup(newID))){
            return new Object[]{"ID Already Exists",null};
        }

        objectrefs.setId(newID);
        return new Object[]{"ID Changed",newID};
    }

    // public String changeTutor(String selectedGroupID){
    //     TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
    //     ui.print("current tutor: " + objectrefs.getTutor());
    //     ui.print("Enter new Tutor ID: ");
    //     String newTutor = ui.getString(6);
    //     objectrefs.setTutor(newTutor);
    //     return "Sucess";
    // }

    public String changeProgram(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("=============================");
        ui.displayProgram(programlist);
        ui.print("Enter new program name: ");
        ui.print("Current program is: "+ objectrefs.getProgram());
        String newProgram = ui.getString(8);
        if(objectrefs.getProgram().equals(newProgram)){
            return "Program selected are the same. No changes made";
        }
        if(programlist.contains(new Program(newProgram))){
            programlist.getData(new Program(objectrefs.getProgram())).getTutorialGrouplist().remove(objectrefs);
            objectrefs.setProgram(newProgram);
            programlist.getData(new Program(objectrefs.getProgram())).getTutorialGrouplist().add(objectrefs);
            return "Sucess";
        }
        return "No changes made";

    }

    public String addStudent(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        //Tutorial group is full
        if (objectrefs.getStudentlist().size() >= objectrefs.getMaxSize()){
            return "Tutorial Group is full";
        }else{
            //Dispaly studentlist and allow user to add student
            ui.studentDisplay(studentlist);
            ui.print("Select new student ID");
            Student newStudent = studentlist.getData(new Student(ui.getChoice(999)));
            if (newStudent != null){
                if (objectrefs.getStudentlist().add(newStudent)){
                    return "Student Added";
                }
            }
            return "Unable to add new student";
        }
    }

    public String removeStudent(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        CircularListInterface<Student> currentStudentlist = objectrefs.getStudentlist();

        if (currentStudentlist.isEmpty()){
            return "Tutorial group is empty";
        }else{
            ui.print("Editing for:" + selectedGroupID);
            ui.studentDisplay(currentStudentlist);
            ui.print("Select student id to be removed ");
            Student remStudent = currentStudentlist.getData(new Student(ui.getChoice(999)));
            if (remStudent != null){
                if (objectrefs.getStudentlist().remove(remStudent)){
                    return "Student Removed";
                }
            }
            return "Student is not in the list";
        }
    }   


    public CircularListInterface<Program> getProgramlist() {
        return programlist;
    }
}
