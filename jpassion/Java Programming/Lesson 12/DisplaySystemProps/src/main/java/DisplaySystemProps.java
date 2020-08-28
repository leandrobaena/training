
import java.util.Properties;

public class DisplaySystemProps {

    public static void main(String[] args) {

        // Get all system properties and display them.
        Properties p1 = System.getProperties();
        p1.list(System.out);
    }
}
