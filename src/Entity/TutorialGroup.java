package Entity;

import ADT.CLinkedList;
import ADT.CircularListInterface;

    public class TutorialGroup implements Comparable<TutorialGroup>, DataClass {
        private String id;
        private String tutor;
        private CircularListInterface<Student> studentlist = new CLinkedList<>();
        private String courseID;
        private int maxSize;

        public String toString() {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{");
            jsonBuilder.append("\"id\": \"").append(id).append("\", ");
            jsonBuilder.append("\"tutorialgrp\": \"").append(tutor).append("\", ");
            jsonBuilder.append("\"studentlist\": [");
            if (studentlist != null) {  
                jsonBuilder.append(studentlist.toJSON());
            }
            jsonBuilder.append("], ");
            jsonBuilder.append("\"courseID\": \"").append(courseID).append("\"");
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
         * @param courseID    The ID of the course to which the tutorial group belongs.
         */
        public TutorialGroup(String id, String tutor, CircularListInterface<Student> studentlist, String courseID, int maxSize) {
            this.id = id;
            this.tutor = tutor;
            this.studentlist = studentlist;
            this.courseID = courseID;
            this.maxSize = maxSize;
        }


        /**
         * Constructor for creating a TutorialGroup object.
         *
         * @param id          The ID of the tutorial group.
         * @param tutor       The name of the tutor for the tutorial group.
         * @param courseID    The ID of the course to which the tutorial group belongs.
         */
        public TutorialGroup(String id, String tutor, String courseID, int maxSize) {
            this.id = id;
            this.tutor = tutor;
            this.courseID = courseID;
            this.maxSize = maxSize;
        }


        public TutorialGroup(String id) {
            this.id = id;
            this.tutor = "unassigned";
            this.courseID = "unassigned";
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

        public String getCourseID() {
            return courseID;
        }

        public void setCourseID(String courseID) {
            this.courseID = courseID;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }
