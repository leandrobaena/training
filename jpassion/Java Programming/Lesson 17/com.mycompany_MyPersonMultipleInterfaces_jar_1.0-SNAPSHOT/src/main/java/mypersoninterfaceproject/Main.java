package mypersoninterfaceproject;

public class Main {

    public static void main(String[] args) {

        // Create an object instance of Person class.
        Person person1 = new Person(10000, 20000, "Sang", "Shin", 59, "60 sur", "Colombia");

        // You can assign the object instance to
        // PersonInterface type.
        PersonInterface personinterface1 = person1;

        // Display data from person1 and personinterface1.
        // Observe that they refer to the same object instance.
        System.out.println("person1.getName() = " + person1.getName() + ","
                + " person1.computeTotalWealth() = " + person1.computeTotalWealth() + ","
                + " person1.measureIntelligence() = " + person1.measureIntelligence(person1.getName()));

        System.out.println("personinterface1.getName() = " + personinterface1.getName() + ","
                + " personinterface1.computeTotalWealth() = " + personinterface1.computeTotalWealth());

        personinterface1.computeTotalWealth();

        // Compile error is expected on the following line of code because the measureIntelligence(..)
        // method is defined in the newly added AnotherInterfaceExample interface not in the PersionInterface
        // interface.
        //personinterface1.measureIntelligence(personinterface1.getName());
        // You can assign the object instance to the newly added AnotherInterfaceExample type.
        AnotherInterfaceExample anotherinterfaceexample1 = person1;

        // Check of object instance that is referred by personinterface1 and 
        // anotherinterfaceexample1 is the same object instance.
        boolean b1 = (personinterface1 == anotherinterfaceexample1);
        System.out.println("Do personinterface1 and anotherinterfaceexample1 point to the same object instance? " + b1);

        System.out.println("Address: " + person1.getAddress().getStreetNumber() + " "
                + person1.getAddress().getStreetName() + " " + person1.getAddress().getCountry());
    }

}
