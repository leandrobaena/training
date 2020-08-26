package mypackage;

/*
 * JavaTwoDimensionArray.java
 *
 * Created on January 31, 2007, 10:11 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author sang
 */
public class JavaThreeDimensionArray {

    /**
     * Creates a new instance of JavaTwoDimensionArray
     */
    public JavaThreeDimensionArray() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declare and create two dimensional int array whose size is 10 by 5
        int[][][] ages = new int[10][5][3];

        // Display the value of each entry in the array
        int value = 1000;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages[i].length; j++) {
                for (int k = 0; k < ages[i][j].length; k++) {
                    ages[i][j][k] = value;
                    value++;
                }
            }
        }
    }
}
