
package mypersoninterfaceproject;

public class Main {
   
    public static void main(String[] args) {
       
        // Create an object instance of Student class.
        Student student1 = new Student(10000, 20000, "Sang", "Shin", "Good School");
       
        // You can assign the object instance to
        // StudentInterface type.
        StudentInterface studentinterface1 = student1;
       
        // Display data from student1 and studentinterface1.
        // Observe that they refer to the same object instance.
        System.out.println("student1.getName() = " + student1.getName() + "," +
                " student1.computeTotalWealth() = " + student1.computeTotalWealth()+ "," +
                " student1.findSchool() = " + student1.findSchool());
       
        System.out.println("studentinterface1.getName() = " + studentinterface1.getName() + "," +
                " studentinterface1.computeTotalWealth() = " + studentinterface1.computeTotalWealth()+ "," +
                " studentinterface1.findSchool() = " + studentinterface1.findSchool());
       
        // Check of object instance that is referred by student1 and
        // studentinterface1 is the same object instance.
        boolean b1 = (student1 == studentinterface1);
        System.out.println("Do student1 and studentinterface1 point to the same object instance? " + b1);
        
    }
   
}