/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hellocommandlinearguments;

public class HelloCommandLineArguments {

    public static void main(String[] args) {

        // Print the string "Hello, " on screen
        System.out.println("I am saying Hello to the people below.. ");

        // Check if a command line argument exists
        if (args.length == 0) {
            System.exit(0);
        }

        // Display the arguments from the command line
        for (int counter = 0; counter < args.length; counter++) {
            System.out.println("argument index " + counter + ": " + args[counter]);
        }
    }

}
