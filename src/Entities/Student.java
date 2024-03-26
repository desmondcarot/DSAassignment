package Entities;

//Example DATA Entity Class
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private String course;
    private String programme;
    private String studentClass;
    private String email;


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
    public Student(int id, String name, String course, String programme, String studentClass, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.programme = programme;
        this.studentClass = studentClass;
        this.email = email;
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


    // Use toString method to return JSON object string
    @Override
    public String toString() {
        return "{" +
            "\"id\":" + id + "," +
            "\"name\":\"" + name + "\"," +
            "\"course\":\"" + course + "\"," +
            "\"programme\":\"" + programme + "\"," +
            "\"studentClass\":\"" + studentClass + "\"," +
            "\"email\":\"" + email + "\"" +
            "}";
    }

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


    //getter setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCourse() {return course;}
    public void setCourse(String course) {this.course = course;}
    public String getProgramme() {return programme;}
    public void setProgramme(String programme) {this.programme = programme;}
    public String getStudentClass() {return studentClass;}
    public void setStudentClass(String studentClass) {this.studentClass = studentClass;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}

