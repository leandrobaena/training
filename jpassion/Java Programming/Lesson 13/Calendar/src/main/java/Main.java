
import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // Gets a calendar using the default time zone and locale.
        // The Calendar returned is based on the current time in the
        // default time zone with the default locale.
        Calendar rightnow = Calendar.getInstance();

        // Observe all the fields that a Calendar object maintains
        System.out.println("Current date and time is " + rightnow.toString());

        // Display the name of the month field in a particular locale
        System.out.println("Display name of the Month field in defaule locale = " + rightnow.getDisplayName(
                Calendar.MONTH,
                Calendar.LONG,
                Locale.getDefault()));

        // Display the name of the month field in a particular locale
        System.out.println("Display name of the Month field in French = " + rightnow.getDisplayName(
                Calendar.MONTH,
                Calendar.LONG,
                Locale.FRENCH));

        System.out.println("c1.get(Calendar.HOUR_OF_DAY) = " + rightnow.get(Calendar.HOUR_OF_DAY));
        System.out.println("c1.get(Calendar.DAY_OF_MONTH) = " + rightnow.get(Calendar.DAY_OF_MONTH));
        System.out.println("c1.rightnow.get(Calendar.DAY_OF_YEAR = " + rightnow.get(Calendar.DAY_OF_YEAR));
        System.out.println("c1.get(Calendar.DAY_OF_WEEK_IN_MONTH) = " + rightnow.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("c1.get(Calendar.DATE) = " + rightnow.get(Calendar.DATE));
        System.out.println("c1.get(Calendar.HOUR) = " + rightnow.get(Calendar.HOUR));
        System.out.println("c1.get(Calendar.MONTH) = " + rightnow.get(Calendar.MONTH));
    }
}
