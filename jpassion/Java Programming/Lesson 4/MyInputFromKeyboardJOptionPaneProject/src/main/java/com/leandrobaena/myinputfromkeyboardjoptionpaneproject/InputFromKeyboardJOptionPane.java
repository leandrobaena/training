package com.leandrobaena.myinputfromkeyboardjoptionpaneproject;

import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Baena
 */
public class InputFromKeyboardJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = "";
        name = JOptionPane.showInputDialog("Please enter your name");
        String msg = "Hello " + name + "!";
        JOptionPane.showMessageDialog(null, msg);
    }

}
