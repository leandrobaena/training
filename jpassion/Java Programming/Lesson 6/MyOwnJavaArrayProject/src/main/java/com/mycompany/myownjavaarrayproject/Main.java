package com.mycompany.myownjavaarrayproject;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String[] names = new String[3];
        String longest = "";
        for (int i = 0; i < names.length; i++) {
            names[i] = JOptionPane.showInputDialog("Ingrese el nombre " + (i + 1));
        }
        
        for (String name : names) {
            if (longest.length() < name.length()) {
                longest = name;
            }
        }
        
        System.out.println(longest + " has the longest first name");
    }
}
