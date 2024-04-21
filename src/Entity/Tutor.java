package Entity;



import ADT.CLinkedList;
import ADT.CircularListInterface;

    public class Tutor implements Comparable<Tutor>, DataClass {
        private int id;
        private String courseName;
        private String tutor;
        private String courseType;
        private CircularListInterface<TutorialGroup> groupList = new CLinkedList<>();
        private static int nextId = 1;
    
        
        public String toString() {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{");
            jsonBuilder.append("\"courseName\": \"").append(courseName).append("\", ");
            jsonBuilder.append("\"tutorgrp\": \"").append(tutor).append("\", ");
            jsonBuilder.append("\"studentlist\": [");
            if (groupList != null) {  
                jsonBuilder.append(groupList.toJSON());
            }
            jsonBuilder.append("], ");
            jsonBuilder.append("\"courseID\": \"").append(courseType).append("\"");
            jsonBuilder.append("}");
            return jsonBuilder.toString();
        }

        @Override
        public int compareTo(Tutor other) {
            // Handle comparison with null
            if (other == null) {
            return 1; // Current object is greater than null
        }
        // Compare IDs
        if (this.id < other.id) {
            return -1; // Current object is less than other
        } else if (this.id > other.id) {
            return 1; // Current object is greater than other
        } else {
            return 0; // IDs are equal
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
            Tutor tgroup = (Tutor) obj;
            return id == tgroup.id;
        }
        
        /**
         * Constructor for creating a TutorGroup object.
         *@param id
         * @param courseName          
         * @param tutor       
         * @param groupList 
         * @param courseType    
         */
        
        public Tutor(int id, String courseName, String tutor, String courseType, CircularListInterface<TutorialGroup> groupList) {
            this.id = id;
            this.courseName = courseName;
            this.tutor = tutor;
            this.groupList = groupList;
            this.courseType = courseType;
        }
        
        public Tutor(int id, String courseName, String tutor, String courseType) {
            this.id = id;
            this.courseName = courseName;
            this.tutor = tutor;
            this.groupList = groupList;
            this.courseType = courseType;
            nextId++;
        }
        
        public Tutor(String courseName, String tutor, String courseType, CircularListInterface<TutorialGroup> groupList) {
            this.id = nextId;
            this.courseName = courseName;
            this.tutor = tutor;
            this.groupList = groupList;
            this.courseType = courseType;
            nextId++;
        }

        public Tutor(int id) {
            this.id = id;
            
        }

        /**
         * Constructor for creating a TutorialGroup object.
         *
         * @param courseName  The Name for the course.
         * @param tutor       The name of the tutor for the tutorial group.
         * @param courseType    The ID of the course to which the tutorial group belongs.
         */
        public Tutor(String courseName, String tutor, String courseType) {
            this.courseName = courseName;
            this.tutor = tutor;
            this.courseType = courseType;
            this.id = nextId;
            nextId++;
        }


        public Tutor(String courseName, String courseType) {
            this.courseName = courseName;
            this.tutor = "";
            this.courseType = courseType;
            this.id = nextId;
            
        }
        
        
        public Tutor(String courseName) {
            this.courseName = courseName;
            this.tutor = "unassigned";
            this.courseType = "unassigned";
            this.id = nextId;
            
        }

        public Tutor() {}

        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }
        
        public void addId(int size) {
            this.id = size+1;
        }
    
        public String getcourseName() {
            return courseName;
        }

        public void setcourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getTutor() {
            return tutor;
        }

        public void setTutor(String tutor) {
            this.tutor = tutor;
        }
        
        public String getCourseType() {
            return courseType;
        }
        
        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public CircularListInterface<TutorialGroup> getGrouplist() {
            return groupList;
        }

        public void setGrouplist(CircularListInterface<TutorialGroup> groupList) {
            this.groupList = groupList;
        }


}
