package org.me.hello;

import javax.swing.JOptionPane;

public class InputFromKeyboardJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String username = "";

        username = JOptionPane.showInputDialog("Please enter your name");
        String msg = "Hello " + username + "!";
        JOptionPane.showMessageDialog(null, msg);
    }

}
