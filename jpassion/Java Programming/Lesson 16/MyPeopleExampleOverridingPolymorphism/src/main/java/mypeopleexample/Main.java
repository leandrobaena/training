
package mypeopleexample;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("---- Observe overriding method behavior ----");
        
        Person person1 = new Person();
        person1.myMethod("test1");
        
        Student student1 = new Student();
        student1.myMethod("test2");
        
        InternationalStudent internationalStudent1 =
                new InternationalStudent();
        internationalStudent1.myMethod("test3");
        
        // Polymorphic behavior
        System.out.println("---- Observe polymorphic behavior ----");
        
        Person person2 = new Student();
        person2.myMethod("test4");
        
        Person person3 = new InternationalStudent();
        person3.myMethod("test5");
        
        Student student2 = new InternationalStudent();
        student2.myMethod("test6");
        
    }
}
