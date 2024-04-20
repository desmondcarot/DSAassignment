package Entity;

import ADT.CLinkedList;
import ADT.CircularListInterface;

    public class TutorialGroup implements Comparable<TutorialGroup>, DataClass {
        private String id;
        private String tutor;
        private CircularListInterface<Student> studentlist = new CLinkedList<>();
        private String program;
        private int maxSize;

        public String toString() {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{");
            jsonBuilder.append("\"id\": \"").append(id).append("\", ");
            jsonBuilder.append("\"Tutor\": \"").append(tutor).append("\", ");
            jsonBuilder.append("\"studentlist\": [");
            if (studentlist != null) {  
                jsonBuilder.append(studentlist.toJSON());
            }
            jsonBuilder.append("], ");
            jsonBuilder.append("\"programID\": \"").append(program).append("\"");
            jsonBuilder.append("}");
            return jsonBuilder.toString();
        }

        @Override
        public int compareTo(TutorialGroup otherGroup) {
            // Extract the numeric part of the IDs
            int thisNumericPart = Integer.parseInt(this.id.substring(3));
            int otherNumericPart = Integer.parseInt(otherGroup.id.substring(3));
            
            // Compare the numeric parts
            return Integer.compare(thisNumericPart, otherNumericPart);
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TutorialGroup tgroup = (TutorialGroup) obj;
            return id.equals(tgroup.id);
        }


        /**
         * Constructor for creating a TutorialGroup object.
         *
         * @param id          The ID of the tutorial group.
         * @param tutor       The name of the tutor for the tutorial group.
         * @param studentlist The list of student IDs enrolled in the tutorial group.
         * @param programName    The name of the program to which the tutorial group belongs.
         */
        public TutorialGroup(String id, String tutor, CircularListInterface<Student> studentlist, String program, int maxSize) {
            this.id = id;
            this.tutor = tutor;
            this.studentlist = studentlist;
            this.program = program;
            this.maxSize = maxSize;
        }


        /**
         * Constructor for creating a TutorialGroup object.
         *
         * @param id          The ID of the tutorial group.
         * @param tutor       The name of the tutor for the tutorial group.
         * @param program    The name of the program to which the tutorial group belongs.
         */
        public TutorialGroup(String id, String tutor, String program, int maxSize) {
            this.id = id;
            this.tutor = tutor;
            this.program = program;
            this.maxSize = maxSize;
        }


        public TutorialGroup(String id) {
            this.id = id;
            this.tutor = "unassigned";
            this.program = "unassigned";
        }

        public TutorialGroup() {}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTutor() {
            return tutor;
        }

        public void setTutor(String tutor) {
            this.tutor = tutor;
        }

        public CircularListInterface<Student> getStudentlist() {
            return studentlist;
        }

        public void setStudentlist(CircularListInterface<Student> studentlist) {
            this.studentlist = studentlist;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }
