import java.text.SimpleDateFormat;
import java.util.*;


public class DateForm {
    public static void dayOfWeek(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY - EEEE");
        int n = 0;
        for (int x = year; x <= 2019; x++, n++) {

            calendar.set(x, month, date);
            String myString = format.format(calendar.getTime());
            System.out.println(n + " - " + myString);  // + (new SimpleDateFormat("EEEE").format(myString))
        }
    }
    public static void main(String[] args) {
dayOfWeek(1998,9,20);

    }
}
