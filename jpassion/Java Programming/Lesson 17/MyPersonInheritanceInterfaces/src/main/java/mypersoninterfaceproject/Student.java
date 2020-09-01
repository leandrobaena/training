
package mypersoninterfaceproject;

// Note that the Student class implements all the methods defined in the StudentInterface
// interface and its parent interfaces, PersonInterface interface in this example.
public class Student implements StudentInterface {
    
    int cashSaving;
    int retirementFund;
    String firstName;
    String lastName;
    String school;
    
    // Constructor with arguments
    Student(int cashSaving,
            int retirementFund,
            String firstName,
            String lastName,
            String school){
        this.cashSaving = cashSaving;
        this.retirementFund = retirementFund;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }
    
    // Compute person's total wealth
    // Method implementation of PersonInterface interface
    public int computeTotalWealth(){
        System.out.println(cashSaving + retirementFund);
        return (cashSaving + retirementFund);
    }
    
    // Get person's name
    // Method implementation of PersonInterface interface
    public String getName(){
        return firstName + " " + lastName;
    }
    
    // Find out the school the student attends
    // Method implementation of StudentInterface interface
    public String findSchool(){
        return school;
    }
}
