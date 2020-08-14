package com.leandrobaena.mygreatestvalueproject2;

/**
 *
 * @author Leandro Baena
 */
public class GreatestValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declare the numbers
        int num1 = 10;
        int num2 = 23;
        int num3 = 5;
        int min = 0;

        // Determines the highest number
        min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;

        //prints the output on the screen
        System.out.println("number 1 = " + num1);
        System.out.println("number 2 = " + num2);
        System.out.println("number 3 = " + num3);
        System.out.println("The smallest number is = " + min);
        System.out.println(min < 10 ? "The smallest number is less than 10!" : "The smallest number is greater than or equal to 10!");
    }
}
