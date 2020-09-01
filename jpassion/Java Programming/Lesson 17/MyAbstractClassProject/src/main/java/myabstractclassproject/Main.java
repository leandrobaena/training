
package myabstractclassproject;

public class Main {
    
    public static void main(String[] args) {
        
        // Create Human object instance
        // and assign it to Human type.
        Human human1 = new Human("Sang Shin");
        human1.walk();
        
        // Create Human object instance
        // and assign it to LivingThing type.
        LivingThing livingthing1 = human1;
        livingthing1.walk();    // The walk() method of the Human will be called
        
        // Create a Monkey object instance
        // and assign it to LivingThing type.
        LivingThing livingthing2 = new Monkey("MonkeyWrench");
        livingthing2.walk();    // The walk() method of the Monkey will be called
        
        // Display data from human1 and livingthing1.
        // Observe that they refer to the same object instance.
        System.out.println("human1.getName() = " + human1.getName());
        System.out.println("livingthing1.getName() = " + livingthing1.getName());
         
        // Check of object instance that is referred by x and
        // y is the same object instance.
        boolean b1 = (human1 == livingthing1);
        System.out.println("Do human1 and livingthing1 point to the same object instance? " + b1);
        
        // Compile error
        // LivingThing z = new LivingThing();
    }
    
}
