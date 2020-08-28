/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetSystemProperties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FileInputStream propFile = null;
        Properties p = null;

        // set up new properties object
        // from file "myProperties.txt"
        try {
            propFile = new FileInputStream(
                    "myProperties.txt");
            p = new Properties(System.getProperties());
            p.load(propFile);
        } catch (IOException e) {
            System.out.println(e);
        }

        // set a property through setProperty() method
        p.setProperty("myKey1", "myValue1");

        // set the system properties
        System.setProperties(p);

        // display new properties
        System.getProperties().list(System.out);
    }
}
