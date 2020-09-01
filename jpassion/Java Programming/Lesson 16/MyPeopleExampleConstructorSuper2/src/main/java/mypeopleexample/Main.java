
package mypeopleexample;

public class Main {
    
    public static void main(String[] args) {
        
        // Create an object instance of
        // InternationalStudent class.
        System.out.println("---- About to create an object instance of InternationalStudent class...");
        InternationalStudent internationalStudent1 =
                new InternationalStudent("Sang Shin",   // Name
                "1 Dreamland", // Address
                4.5,           // Grade
                "Korea");      // Country
        
        System.out.println("internationalStudent1.getName() = " + internationalStudent1.getName());
        System.out.println("internationalStudent1.getAddress() = " + internationalStudent1.getAddress());
        System.out.println("internationalStudent1.getGrade() = " + internationalStudent1.getGrade());
        System.out.println("internationalStudent1.getCountry() = " + internationalStudent1.getCountry());
    }
}
