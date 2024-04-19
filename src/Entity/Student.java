package Entity;

import ADT.CLinkedList;
import ADT.CircularListInterface;

//Example DATA Entity Class
public class Student implements Comparable<Student>, DataClass{
    private int id;
    private String name;
    private String course;
    private String programme;
    private String studentClass;
    private CircularListInterface<Course> studentCourseList;
    private String email;
    private static int nextId = 1;


    
    // Use toString method to return JSON object string
    @Override
    public String toString() {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{");
            jsonBuilder.append("\"id\": \"").append(id).append("\", ");
            jsonBuilder.append("\"studentName\": \"").append(name).append("\", ");
            jsonBuilder.append("\"course\": \"").append(course).append("\", ");
            jsonBuilder.append("\"programme\": \"").append(programme).append("\", ");
            jsonBuilder.append("\"studentClass\": \"").append(name).append("\", ");
            jsonBuilder.append("\"studentlist\": [");
            if (studentCourseList != null) {  
                jsonBuilder.append(studentCourseList.toJSON());
            }
            jsonBuilder.append("], ");
            jsonBuilder.append("\"email\": \"").append(email).append("\"");
            jsonBuilder.append("}");
            return jsonBuilder.toString();
        }
    
    //required to enable merge sort, specifiy the field or parameter in which you would like the sort to compare
    @Override
    public int compareTo(Student other) {
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
    
    //Required to compare objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id;
    }
    
    
    
    




    /**
     * Constructs a new Student object with the provided attributes.
     * 
     * @param id the unique identifier of the student
     * @param name the name of the student
     * @param course the course the student is enrolled in
     * @param programme the programme the student is pursuing
     * @param studentClass the class or section the student belongs to
     * @param email the email address of the student
     */


    public Student(String name, String course, String programme, String studentClass, String email) {
        this.id = nextId;
        this.name = name;
        this.course = course;
        this.programme = programme;
        this.studentClass = studentClass;
        this.email = email;
        this.studentCourseList = new CLinkedList();
        nextId++;
    }
    
    
    
    
    
    

    
            public Student() {
            this.id = nextId;
            this.name = "";
            this.course = "";
            this.programme = "";
            this.studentClass = "";
            this.email = "";
            this.studentCourseList = new CLinkedList();
            nextId++;
        }
    
    
   

    


    //getter setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCourse() {return course;}
    public void setCourse(String course) {
        this.course = course;
    }
    public String getProgramme() {return programme;}
    public void setProgramme(String programme) {this.programme = programme;}
    public String getStudentClass() {return studentClass;}
    public void setStudentClass(String studentClass) {this.studentClass = studentClass;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public void addCourse(String newCourse, CircularListInterface<Course> courseProgramList){
        String[] newCourseNames = newCourse.split(",");
        // Check newcoursenzmes size
        // if size 1, means 1 course (withuut ",  ')
            // Find course ni the courseProgramList
            for(Course course : courseProgramList) {
                if(course.getCourseName().equals(newCourseNames)) {
                    this.studentCourseList.add(course);
                }
            }
        }
            
              
        
        // if more than 1, then use for loop to get coude objone by one
        
        //if 1 only,teru add into list

    public CircularListInterface<Course> getStudentCourseList() {
        return studentCourseList;
    }
        
        
        
        
        
        
    
}

