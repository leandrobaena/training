
package myabstractclassproject;

public class Monkey extends LivingThing {
    
    public Monkey(String name){
        super(name);
    }
    
    // Implement the abstract method
    public void walk(){
        System.out.println("Monkey " + getName() + " also walks...");
    }
}
