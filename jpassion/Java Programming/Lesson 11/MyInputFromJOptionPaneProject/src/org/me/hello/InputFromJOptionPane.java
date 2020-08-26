package org.me.hello;

import javax.swing.JOptionPane;

public class InputFromJOptionPane {

	public static void main(String[] args) {

		String name = "";

		name = JOptionPane.showInputDialog("Please enter your name");
		String msg = "Hello " + name + "!";
		JOptionPane.showMessageDialog(null, msg);
		System.out.println();
	}
}
