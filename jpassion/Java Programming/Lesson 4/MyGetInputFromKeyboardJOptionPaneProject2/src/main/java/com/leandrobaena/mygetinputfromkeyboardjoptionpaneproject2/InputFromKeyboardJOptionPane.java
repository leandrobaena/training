package com.leandrobaena.mygetinputfromkeyboardjoptionpaneproject2;

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
        String age = "";
        age = JOptionPane.showInputDialog("Please enter your age");
        String msg = "Hello " + name + ", you are " + (Integer.parseInt(age) > 100 ? "old" : "young") + "!";
        JOptionPane.showMessageDialog(null, msg);
    }

}
