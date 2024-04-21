package control;

import javax.print.attribute.standard.Sides;

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
            CircularListInterface<Program> P) {
        studentlist = S;
        tutorialGrpList = TG;
        courselist = C;
        tutorlist = T;
        programlist = P;
    }

    public CircularListInterface<TutorialGroup> runTutorial() {
        int choice = 0;
        String errorMsg = null;

        do {
            ui.tutorialMenuDisplay(errorMsg);
            choice = ui.getChoice(5);
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
                case 5:
                    tutorialReport();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 0);

        return tutorialGrpList;
    }

    public String addTutorialGroup() {
        TutorialGroup newGroup = ui.inputTutorialGroup(programlist, tutorlist);
        if (newGroup != null) {
            if (tutorialGrpList.add(newGroup)) {
                // add tutorial group to program
                programlist.getData(new Program(newGroup.getProgram())).getTutorialGrouplist().add(newGroup);
                return "Sucessfully Added";
            } else {
                return "Unable to add new Tutorial Group";
            }
        }

        return "unable to add new Tutorial Group";

    }

    public String removeTutorialGroup() {
        TutorialGroup remGroup = ui.removeTutorialGroupInput(tutorialGrpList);
        if (tutorialGrpList.contains(remGroup)) {
            String program = tutorialGrpList.getData(remGroup).getProgram();
            Program programref = programlist.getData(new Program(program));
            if (tutorialGrpList.remove(remGroup)) {
                programref.getTutorialGrouplist().remove(remGroup);
                return "Group " + remGroup.getId() + " removed";
            } else {
                return "Nothing is removed";
            }
        }
        return "Nothing is removed";
    }

    public void listTutorialGroup() {
        ui.tutorialGroupDisplay(tutorialGrpList);
        int choice;
        ui.print("0 to return to menu");
        do {
            choice = ui.getChoice(0);
        } while (choice != 0);
    }

    public String changeGroupInformationMenu() {
        String selectedGroup = null;
        String error = null;
        int choice = 0;
        ui.tutorialGroupDisplay(tutorialGrpList);
        ui.print("Please Select the group you want to edit");
        selectedGroup = ui.getString(5);
        if (!tutorialGrpList.contains(new TutorialGroup(selectedGroup))) {
            return "Group ID not found";
        }
        do {
            ui.editGrpInformation(error, selectedGroup);
            choice = ui.getChoice(6);
            switch (choice) {
                case 1: // Change ID
                    Object[] result = changeID(selectedGroup);
                    error = (String) result[0];
                    if ((String) result[1] != null) {
                        selectedGroup = (String) result[1];
                        tutorialGrpList.sort();
                    }
                    break;
                case 2: // Change course
                    error = changeProgram(selectedGroup);
                    break;
                case 3: // Add student
                    error = addStudent(selectedGroup);
                    break;
                case 4: // remove student
                    error = removeStudent(selectedGroup);
                    break;
                case 5:
                    error = mergeGroup(selectedGroup);
                    break;
                case 6:
                    error = changesize(selectedGroup);
                default:
                    break;
            }
        } while (choice != 0);
        return null;
    }

    public Object[] changeID(String selectedGroupID) {
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new ID: ");
        String newID = ui.getString(5);

        if (tutorialGrpList.isEmpty()) {
            return null;
        }

        if (newID == selectedGroupID) {
            return new Object[] { "No changes made", newID };
        }

        if (tutorialGrpList.contains(new TutorialGroup(newID))) {
            return new Object[] { "ID Already Exists", null };
        }

        objectrefs.setId(newID);
        return new Object[] { "ID Changed", newID };
    }

    public String changeProgram(String selectedGroupID) {
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("=============================");
        ui.displayProgram(programlist);
        ui.print("Enter new program name: ");
        ui.print("Current program is: " + objectrefs.getProgram());
        String newProgram = ui.getString(8);
        if (objectrefs.getProgram().equals(newProgram)) {
            return "Program selected are the same. No changes made";
        }
        if (programlist.contains(new Program(newProgram))) {
            programlist.getData(new Program(objectrefs.getProgram())).getTutorialGrouplist().remove(objectrefs);
            objectrefs.setProgram(newProgram);
            programlist.getData(new Program(objectrefs.getProgram())).getTutorialGrouplist().add(objectrefs);
            return "Sucess";
        }
        return "No changes made";

    }

    public String addStudent(String selectedGroupID) {
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        // Tutorial group is full
        if (objectrefs.getStudentlist().size() >= objectrefs.getMaxSize()) {
            return "Tutorial Group is full";
        } else {
            // Dispaly studentlist and allow user to add student
            ui.tgStudentListDisplay(studentlist);
            ui.print("Select new student ID");
            Student newStudent = studentlist.getData(new Student(ui.getChoice(999)));
            if (newStudent != null) {
                if (objectrefs.getStudentlist().add(newStudent)) {
                    return "Student Added";
                }
            }
            return "Unable to add new student";
        }
    }

    public String removeStudent(String selectedGroupID) {
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        CircularListInterface<Student> currentStudentlist = objectrefs.getStudentlist();

        if (currentStudentlist.isEmpty()) {
            return "Tutorial group is empty";
        } else {
            ui.print("Editing for:" + selectedGroupID);
            ui.tgStudentListDisplay(currentStudentlist);
            ui.print("Select student id to be removed ");
            Student remStudent = currentStudentlist.getData(new Student(ui.getChoice(999)));
            if (remStudent != null) {
                if (objectrefs.getStudentlist().remove(remStudent)) {
                    return "Student Removed";
                }
            }
            return "Student is not in the list";
        }
    }

    public String mergeGroup(String selectedGroupID) {
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        String secondgroupstring;
        UI.clearScreen();
        ui.tutorialGroupDisplay(tutorialGrpList);
        ui.print("Enter the tutorial group ID you want to merge with:");
        secondgroupstring = ui.getString(6);
        if (selectedGroupID.equals(secondgroupstring)){
            return "Warning! Can't merge with the same group";
        }
        if (tutorialGrpList.contains(new TutorialGroup(secondgroupstring))) {
            TutorialGroup secondGroup = tutorialGrpList.getData(new TutorialGroup(secondgroupstring));
            if (objectrefs.getStudentlist().size() + secondGroup.getStudentlist().size() <= objectrefs.getMaxSize()) {
                objectrefs.getStudentlist().merge(secondGroup.getStudentlist());
                secondGroup.getStudentlist().clear();

                // remove the merged group from tutorialgrouplist and programme list
                String program = secondGroup.getProgram();
                Program programref = programlist.getData(new Program(program));
                if (tutorialGrpList.remove(secondGroup)) {
                    programref.getTutorialGrouplist().remove(secondGroup);
                }
                return "Sucessfully merged " + selectedGroupID + " with " + secondgroupstring;
            } else {
                return "Can't merge groups, as the student size exceeds the maximum allowed in this tutorial group";
            }
        }
        return null;
    }

    public String changesize(String selectedGroupID){
        TutorialGroup objectrefs = tutorialGrpList.getData(new TutorialGroup(selectedGroupID));
        ui.print("Enter new size of the group");
        int newSize = ui.getChoice(999);
        if(objectrefs.getMaxSize() == newSize){
            return "The new group size is same as before, no changes made";
        }

        objectrefs.setMaxSize(newSize);
        return "Change group size to " + newSize;
    }

    public CircularListInterface<Program> getProgramlist() {
        return programlist;
    }

    public void tutorialReport() {
        String errMsg = null;
        int choice = 0;
        do {
            UI.clearScreen();
            ui.tutorialReportMenu(errMsg);
            choice = ui.getChoice(6);
            switch (choice) {
                case 1:
                    UI.clearScreen();
                    listAllGroup(tutorialGrpList);
                    ui.getString(999);
                    break;
                case 2:
                    listEmptyGroup();
                    break;
                case 3:
                    listFullGroup();
                    break;
                case 4:
                    listAvailableGroup();
                    break;
                case 5:
                    errMsg = DetailedGroupReport();
                    break;
                case 6:
                    errMsg = getTutorialGroupByProgramme();
                default:
                    break;
            }
        } while (choice != 0);
    }

    public void listAllGroup(CircularListInterface<TutorialGroup> t) {
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID", "Program", "Students");
        for (TutorialGroup item : t) {
            ui.print("=".repeat(45));
            System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(), item.getProgram(),
                    item.getStudentlist().size(), item.getMaxSize());
            ui.print("=".repeat(45));
            if (item.getStudentlist().size() != 0) {
                for (Student student : item.getStudentlist()) {
                    System.out.printf("%-10d %-10s %-20s\n", student.getId(), student.getName(), student.getEmail());
                }
            } else {
                ui.print("No student.");
            }
            x++;
        }
    }

    public void listEmptyGroup() {
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID", "Program", "Students");
        for (TutorialGroup item : tutorialGrpList) {
            if (item.getStudentlist().size() == 0) {
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(),
                        item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(5);
    }

    public void listFullGroup() {
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID", "Program", "Students");
        for (TutorialGroup item : tutorialGrpList) {
            if (item.getStudentlist().size() >= item.getMaxSize()) {
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(),
                        item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(5);
    }

    public void listAvailableGroup() {
        UI.clearScreen();
        int x = 1;
        System.out.printf("%-4s %-10s %-10s %-10s %-8s\n", "No ", "GRPID", "TutorID", "Program", "Students");
        for (TutorialGroup item : tutorialGrpList) {
            int size = item.getStudentlist().size();
            int maxSize = item.getMaxSize();
            if (size < maxSize) {
                ui.print("=".repeat(45));
                System.out.printf("%-4d %-10s %-10s %-10s %3d/%-3d\n", x, item.getId(), item.getTutor(),
                        item.getProgram(), item.getStudentlist().size(), item.getMaxSize());
                ui.print("=".repeat(45));
                x++;
            }
        }
        ui.getString(999);
    }

    public String DetailedGroupReport() {
        UI.clearScreen();
        ui.tutorialGroupDisplay(tutorialGrpList);
        ui.print("Select the Group to view their details: ");
        String selectedGroup = ui.getString(6);

        if (tutorialGrpList.contains(new TutorialGroup(selectedGroup))) {
            UI.clearScreen();
            TutorialGroup TG = tutorialGrpList.getData(new TutorialGroup(selectedGroup));
            CircularListInterface<Student> stdlist = TG.getStudentlist();
            ui.print("=".repeat(45));
            System.out.printf("%-3s %-10s %-10s %-10s %3d/%-3d\n", "No.", TG.getId(), TG.getTutor(), TG.getProgram(),
                    TG.getStudentlist().size(), TG.getMaxSize());
            ui.print("=".repeat(45));
            int x = 1;
            for (Student student : stdlist) {
                System.out.printf("%3d. %-10d %-10s %-20s\n", x, student.getId(), student.getName(),
                        student.getEmail());
                x++;
            }
            ui.getString(999);
            return null;
        } else {
            return "Group selected is invalid";
        }
    }

    public String getTutorialGroupByProgramme() {
        UI.clearScreen();
        ui.displayProgram(programlist);
        ui.print("Enter program name to show its tutorial group");
        String s = ui.getString(3);

        if (programlist.contains(new Program(s))) {
            Program programrefs = programlist.getData(new Program(s));
            CircularListInterface<TutorialGroup> tgList = programrefs.getTutorialGrouplist();
            if (tgList.size() == 0) {
                return "Program has no tutorial Group assigned";
            }
            UI.clearScreen();
            System.out.printf("Program : %s, No of Groups: %d\n", programrefs.getProgramName(), tgList.size());
            System.out.print("=".repeat(45) + "\n");
            listAllGroup(tgList);

            ui.print("enter '1' to output the list to JSON, '0' to return: ");
            if (ui.getChoice(1) == 1) {
                UI.clearScreen();
                ui.print(programrefs.toString());
                ui.getString(999);
            }
            return null;
        }

        return "program not found";
    }
}
