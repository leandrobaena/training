
package mypeopleexample;

public class Student extends Person {
    
    public Student() {
        System.out.println("Student: constructor is called");
    }
    
    public Student(String name, String school, double grade) {
        super(name);
        this.school = school;
        this.grade = grade;
        System.out.println("Student: constructor 2 is called");
    }
    
    private String school;
    private double grade;
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    public double getGrade() {
        return grade;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
