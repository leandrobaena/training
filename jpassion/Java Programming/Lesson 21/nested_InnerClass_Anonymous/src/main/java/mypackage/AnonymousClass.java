// This example shows the typical use for anonymous classes: creating
// Swing event listeners. Using anonymous classes to implement event
// listeners is simple and straightforward, but it shouldn’t be overused.
package mypackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnonymousClass {

    public static void main(String args[]) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(
           // An object instance of Anonymous class gets created
           // and returned
           new WindowAdapter() {
               public void windowClosed(WindowEvent e) {
                   onClose();
               }
           });
        frame.getContentPane().add(new JLabel("Press the button to close the application"), BorderLayout.CENTER);
        JButton button = new JButton("Close");

        // Use anonymous inner class
        button.addActionListener(
          // An object instance of Anonymous class, which implements
          // the ActionListener interface gets returned.  This object
          // is then attached to the button object as an ActionListener.
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Note that anonymoust class can access "frame"
                // variable.
                frame.dispose();
          }
        });

        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.show();
    }

    private static void onClose() {
        System.out.println("Application closed");
    }
}
