// This class now belongs to studentpackage  package.
package studentpackage;

public class StudentRecordExample {
   
    public static void main(String[] args) {
       
        // Create an object instance of StudentRecord class.
        StudentRecord annaRecord =new StudentRecord();
       
        // Increament the studentCount by invoking a static method.
        StudentRecord.increaseStudentCount();
       
        // Create another object instance of StudentRecord class.
        StudentRecord beahRecord =new StudentRecord();
       
        // Increament the studentCount by invoking a static method.
        StudentRecord.increaseStudentCount();
       
        // Create the 3rd object instance of StudentRecord class.
        StudentRecord crisRecord =new StudentRecord();
       
        // Increament the studentCount by invoking a static method.
        StudentRecord.increaseStudentCount();
       
        // Set the names of the students.
        annaRecord.setName("Anna");
        beahRecord.setName("Beah");
        crisRecord.setName("Cris");
       
        // Print anna's name.
        System.out.println("Name = " + annaRecord.getName());
       
        // Print number of students.
        System.out.println("Student Count = "+StudentRecord.getStudentCount());
       
    }
   
}