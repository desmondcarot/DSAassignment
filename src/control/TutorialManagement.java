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
}
