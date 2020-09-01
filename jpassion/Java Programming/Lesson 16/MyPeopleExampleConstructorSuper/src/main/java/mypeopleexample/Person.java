
package mypeopleexample;

public class Person {
    
    public Person() {
        System.out.println("Person: constructor is called");
    }
    
    public Person(String name) {
        this.name = name;
        System.out.println("Person: constructor 2 is called");
    }
    
    private String name;
    private String address;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
}
