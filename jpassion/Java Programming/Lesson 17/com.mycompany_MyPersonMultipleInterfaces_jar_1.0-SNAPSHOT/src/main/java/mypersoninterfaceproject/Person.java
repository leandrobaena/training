package mypersoninterfaceproject;

public class Person implements PersonInterface,
        AnotherInterfaceExample, MyOwnInterface {

    int cashSaving;
    int retirementFund;
    String firstName;
    String lastName;
    AddressImpl addressImpl;

    // Constructor with arguments
    Person(int cashSaving,
            int retirementFund,
            String firstName,
            String lastName,
            int streetNumber,
            String streetName,
            String country) {
        this.cashSaving = cashSaving;
        this.retirementFund = retirementFund;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressImpl = new AddressImpl(streetNumber, streetName, country);
    }

    // Compute person's total wealth
    public int computeTotalWealth() {
        System.out.println(cashSaving + retirementFund);
        return (cashSaving + retirementFund);
    }

    // Get person's name
    public String getName() {
        return firstName + " " + lastName;
    }

    // Implement method of AnotherInterfaceExample
    public int measureIntelligence(String name) {
        if (name.startsWith("smart")) {
            return 100;
        } else {
            return 50;
        }
    }

    public AddressInterface getAddress() {
        return this.addressImpl;
    }
}
