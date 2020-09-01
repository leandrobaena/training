
package myabstractclassproject;

// The LivingThing class is an abstract class because
// some methods in it are declared as abstract methods.
public abstract class LivingThing {
    
    private String name;
    
    public LivingThing(String name){
        this.name = name;
    }
    
    public void breath(){
        System.out.println("Living Thing breathing...");
    }
    
    public void eat(){
        System.out.println("Living Thing eating...");
    }
    
    /**
     * Abstract method walk()
     * We want this method to be implemented by subclasses of
     * LivingThing
     */
    public abstract void walk();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
