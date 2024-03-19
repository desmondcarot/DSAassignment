package Entities;

public class Student {
    private int id;
    private String name;
    private String course;
    private String programme;
    private String studentClass;
    private String email;

    public Student(int id, String name, String course, String programme, String studentClass, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.programme = programme;
        this.studentClass = studentClass;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString 
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", programme='" + programme + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

