
package javaapplication12;
import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private int id;
    private String name;
    private String description;
    //aggregation
    private List<Student> enrolledStudents;
    //association
    private Teacher teacher;
    //composition
    private Schedule schedule;

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}