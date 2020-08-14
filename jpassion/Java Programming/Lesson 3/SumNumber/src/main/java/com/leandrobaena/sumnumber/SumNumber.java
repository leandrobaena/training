package com.leandrobaena.sumnumber;

/**
 *
 * @author Leandro Baena
 */
public class SumNumber {

    /**
     * Creates a new instance of AverageNumber
     */
    public SumNumber() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declares the three numbers
        int num1 = 10;
        int num2 = 20;
        int num3 = 45;

        // get the sum of the three numbers
        // and saves it inside the sum variable
        int sum = num1 + num2 + num3;

        //prints the output on the screen
        System.out.println("number 1 = " + num1);
        System.out.println("number 2 = " + num2);
        System.out.println("number 3 = " + num3);
        System.out.println("Sum is = " + sum);
    }
}
