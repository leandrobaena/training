
package myoverridingmethodsexample;

public class OverridingMethods {
    
    public static void main(String[] args) {
        
        // Create object instance of Animal
        Animal myAnimal1 = new Animal();
        Animal.testClassMethod();
        myAnimal1.testInstanceMethod();
        
        // Create object instance of Cat.
        Cat myCat = new Cat();
        Cat.testClassMethod();
        myCat.testInstanceMethod();
        
        // Invoke methods through Animal object instance.
        Animal myAnimal2 = myCat;
        Animal.testClassMethod();
        myAnimal2.testInstanceMethod();
    }
    
}
