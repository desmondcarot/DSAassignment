package Entity;

import ADT.CLinkedList;
import ADT.CircularListInterface;

public class Program implements Comparable<Program>, DataClass {

    private String programName;
    private CircularListInterface<TutorialGroup> tutorialGroupList = new CLinkedList<>();

    public String toString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"programName\": \"").append(programName).append("\", ");
        jsonBuilder.append("\"tutorialGroupList\": ");
        if(!tutorialGroupList.isEmpty()){
            jsonBuilder.append(tutorialGroupList.toJSON());
        }else{
            jsonBuilder.append("[]");
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }


    @Override
    public int compareTo(Program other) {
        int result = this.programName.compareTo(other.getProgramName());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Program program = (Program) obj;
        return programName.equals(program.programName) ;
    }

    public Program(String programName) {
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public CircularListInterface<TutorialGroup> getTutorialGrouplist() {
        return tutorialGroupList;
    }

    public void setProgramList(CircularListInterface<TutorialGroup> tutorialGroupList) {
        this.tutorialGroupList = tutorialGroupList;
    }


}
