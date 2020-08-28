
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {

        // Gets a calendar using the default time zone and locale.
        // The Calendar returned is based on the current time in the
        // default time zone with the default locale.
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();

        // Allocates a Date object and initializes it so that it
        // represents the time at which it was allocated, measured to
        // the nearest millisecond.
        Date anInstantInTime = new Date();

        c1.setTime(anInstantInTime);
        c2.setTime(anInstantInTime);
        c3.setTime(anInstantInTime);

        // Sets the time zone with the given time zone value and display
        c1.setTimeZone(TimeZone.getTimeZone("UTC"));
        c2.setTimeZone(TimeZone.getTimeZone("America/Phoenix"));
        c3.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("c1.get(Calendar.HOUR_OF_DAY) of UTC timezone = " + c1.get(Calendar.HOUR_OF_DAY));
        System.out.println("c1.get(Calendar.HOUR_OF_DAY) of America/Phoenix timezone = " + c2.get(Calendar.HOUR_OF_DAY));
        System.out.println("c1.get(Calendar.HOUR_OF_DAY) of America/New_York timezone = " + c3.get(Calendar.HOUR_OF_DAY));

        // Make sure the our of the day's are different depending on the time zone
        assert (c1.get(Calendar.HOUR_OF_DAY) != c2.get(Calendar.HOUR_OF_DAY));

        // Returns a Date object representing this Calendar's time
        // value (millisecond offset from the Epoch").
        Date utc = c1.getTime();
        Date mst = c2.getTime();
        Date est = c3.getTime();
        System.out.println("utc = " + utc);
        System.out.println("mst = " + mst);
        System.out.println("est = " + est);
    }
}
