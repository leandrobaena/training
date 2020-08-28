package propertiesdemo2;

import java.io.FileInputStream;
import java.util.*;

class Main {

    public static void main(String args[]) {

        FileInputStream propFile;
        Properties p = null;

        try {
            // set up new properties object
            // from file "myproperties.properties"
            propFile = new FileInputStream("myproperties.properties");
            p = new Properties(System.getProperties());
            p.load(propFile);
        } catch (Exception e) {
        }

        // set the system properties
        System.setProperties(p);

        // display new properties
        System.getProperties().list(System.out);
    }
}
