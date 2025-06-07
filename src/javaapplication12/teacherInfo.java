package javaapplication12;


public class teacherInfo extends Person {
    private double salary;
    private String subject;
    private String password;

    public teacherInfo(int id, String name, int age, String email) {
        super(id, name, age, email);
    }

    public teacherInfo() {
    }
    

    public teacherInfo(int id, String name, int age, double salary, String subject, String email) {
        super(id, name, age, email);
        this.salary = salary;
        this.subject = subject;
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    

   
    
    

    @Override
    public String toString() {
        return super.toString() + " - Salary: " + salary + " - Subject: " + subject;
    }
}