/*
 * TestPassByValue.java
 *
 * Created on January 22, 2007, 1:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author sang
 */
public class TestPassByValue {

    /**
     * Creates a new instance of TestPassByValue
     */
    public TestPassByValue() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 10;
        boolean p = true;
        // Print the value of i
        System.out.println("start of the main method and i = " + i);
        System.out.println("start of the main method and p = " + p);

        // Call method test, which is defined below
        // and pass int value as a parameter.  Since
        // int is a primitive type, this parameter is passed
        // by value.
        test(i, p);

        // print the value of i. please note that  i not changed
        System.out.println("end of the main method and i = " + i);
        System.out.println("end of the main method and p = " + p);
    }

    // Another static method in the TestPassByValue class
    public static void test(int j, boolean p) {

        System.out.println("start of the test method and j = " + j);
        System.out.println("start of the test method and p = " + p);

        // change value of parameter i
        j = 33;
        p = false;

        System.out.println("end of the test method and j = " + j);
        System.out.println("end of the test method and p = " + p);
    }
}
