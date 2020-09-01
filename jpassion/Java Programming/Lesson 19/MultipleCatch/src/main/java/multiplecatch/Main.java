package multiplecatch;

import javax.swing.JOptionPane;

public class Main {
   
    public static void main(String[] args) {

        // Enter the following values and see what exception is caught.
        //    0, 4, character, <no value>
        try {

            String value = JOptionPane.showInputDialog(null, "Enter value:");
           
            // Non-numerical value will result an NumberFormatException
            int divisor = Integer.parseInt(value);
           
            // If the divisor is 0, it will result in ArithmetricException
            System.out.println(3/divisor);

        } catch (NumberFormatException nfe){
            System.out.println("Exception caught by this program: Enter numeric value. " + nfe);
        } catch (ArithmeticException exc) {
            System.out.println("Exception caught by this program: Divisor was 0. " + exc);
        }
        System.out.println("After exception.");
    }
   
}
