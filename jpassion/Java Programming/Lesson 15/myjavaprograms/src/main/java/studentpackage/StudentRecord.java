// This class now belongs to studentpackage package.
package studentpackage;

// Import packages
import anotherpackage.*;

public class StudentRecord {
   
    // Declare instance variables.
    private String name;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
   
    // Declare static variables.
    private static int studentCount = 0;
   
    public String getName(){
        DummyClass dummy = new DummyClass();
        System.out.println(dummy.sayHello(name));
        return name;
    }
   
    public void setName(String temp ){
        name =temp;
    }
   
    public static int getStudentCount(){
        return studentCount;
    }
   
    public static void increaseStudentCount(){
        studentCount++;
    }
   
}