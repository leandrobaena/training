package com.leandrobaena.myconditionaloperatorproject;

/**
 *
 * @author Leandro Baena
 */
public class ConditionalOperator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize two variables, one String type variable
        // called status and the other int primitive type variable called
        // grade.
        String status = "";
        int grade = 80;
        int salary = 100000;

        // Get status of the student.
        //status = (grade >= 60) ? "Passed" : "Fail";
        status = (salary >= 50000) ? "You are rich!" : "You are poor!";

        // Print status.
        System.out.println(status);
    }
}
