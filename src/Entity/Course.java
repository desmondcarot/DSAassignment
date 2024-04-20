package Entity;

import ADT.CLinkedList;
import ADT.CircularListInterface;

public class Course implements Comparable<Course>, DataClass {

    private static int courseIntId = 1;

    private int coursePrice;
    private String courseId;
    private String courseName;
    private String programName;
    private String courseDetails;
    private String semesterName;
    private String facultyName;
    private CLinkedList<Student> registerStudent;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public String toString() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"courseId\": \"").append(courseId).append("\", ");
        jsonBuilder.append("\"courseName\": \"").append(courseName).append("\", ");
        jsonBuilder.append("\"courseDetails\": \"").append(courseDetails).append("\", ");
        jsonBuilder.append("\"programName\": \"").append(programName).append("\", ");
        jsonBuilder.append("\"semesterName\": \"").append(semesterName).append("\", ");
        jsonBuilder.append("\"facultyName\": \"").append(facultyName).append("\" ");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    @Override
    public int compareTo(Course other) {
        if (this.courseIntId == other.courseIntId) {
            System.out.println("Course Id are equal");
            return 0;
        } else if (this.courseIntId < Course.courseIntId) {
            System.out.println("This course name is less than the other course name");
            return -1;
        } else {
            System.out.println("This course name is greater than the other course name");
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId.equals(course.courseId) ;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public static int getCourseIntId() {
        return courseIntId;
    }

    public static void setCourseIntId(int courseIntId) {
        Course.courseIntId = courseIntId;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Course(String courseName, String programName, String courseDetails, String semesterName, String facultyName, int coursePrice) {
        String id = Integer.toString(courseIntId);
        this.courseId = id;
        this.courseName = courseName;
        this.programName = programName;
        this.courseDetails = courseDetails;
        this.semesterName = semesterName;
        this.facultyName = facultyName;
        this.coursePrice = coursePrice;
        this.registerStudent = new CLinkedList<Student>();
        courseIntId++;

    }

    public Course() {
        String id = Integer.toString(courseIntId);
        this.courseId = id;
        this.courseName = " ";
        this.programName =  " ";
        this.courseDetails =  " ";
        this.semesterName =  " ";
        this.facultyName =  " ";
        this.coursePrice = 0;
        courseIntId++;
    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public CLinkedList<Student> studentlist() {
        return registerStudent;
    }


}