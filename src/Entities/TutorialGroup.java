package Entities;



import ADT.CLinkedList;
import ADT.CircularListInterface;

    public class TutorialGroup implements Comparable<TutorialGroup>, DataClass {
        private String id;
        private String tutor;
        private CircularListInterface<String> studentlist = new CLinkedList<>();
        private String courseID;

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
        public int compareTo(TutorialGroup other) {
            // Handle comparison with null
            int result = this.id.compareTo(other.getId());
            if (result == 0) {
                System.out.println("Strings are equal");
                //this is equal 2
                return 0;
            } else if (result < 0) {
                //str1 is less than str2
                return 2;
            } else {
                System.out.println("str1 is greater than str2");
                return 1;
                //this is equal 1
            }
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
        public TutorialGroup(String id, String tutor, CircularListInterface<String> studentlist, String courseID) {
            this.id = id;
            this.tutor = tutor;
            this.studentlist = studentlist;
            this.courseID = courseID;
        }


        /**
         * Constructor for creating a TutorialGroup object.
         *
         * @param id          The ID of the tutorial group.
         * @param tutor       The name of the tutor for the tutorial group.
         * @param courseID    The ID of the course to which the tutorial group belongs.
         */
        public TutorialGroup(String id, String tutor, String courseID) {
            this.id = id;
            this.tutor = tutor;
            this.courseID = courseID;
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

        public CircularListInterface<String> getStudentlist() {
            return studentlist;
        }

        public void setStudentlist(CircularListInterface<String> studentlist) {
            this.studentlist = studentlist;
        }

        public String getCourseID() {
            return courseID;
        }

        public void setCourseID(String courseID) {
            this.courseID = courseID;
        }
    }
