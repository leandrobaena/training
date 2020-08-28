
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Returns the number of milliseconds since January 1, 1970, 00:00:00
        // GMT represented by this Date object.
        Date d1 = new Date();
        System.out.println("Current date and time is " + d1.getTime());

        // "toSring()" converts Date object into Calendar internally
        // using default local time zone and locale.  It displays it
        // using "dow mon dd hh:mm:ss zzz yyyy" format.
        System.out.println("Current date and time is " + d1.toString());

        Date d2 = new Date();
        long elapsed_time = d2.getTime() - d1.getTime();
        System.out.println("It took " + elapsed_time
                + " milliseconds");
    }
}
