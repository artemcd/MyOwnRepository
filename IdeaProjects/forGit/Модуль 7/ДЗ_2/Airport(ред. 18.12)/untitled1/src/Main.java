import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws ParseException {
        Airport airport = Airport.getInstance();
        List<Flight> flightsList = new ArrayList<>();

        for (int i = 0; i < airport.getTerminals().size(); i++) {
            for (int x = 0; x < airport.getTerminals().get(i).getFlights().size(); x++) {
                flightsList.add(airport.getTerminals().get(i).getFlights().get(x));
            }
        }

        Calendar cal = Calendar.getInstance();
        Date timeNow = cal.getTime();
        cal.add(Calendar.HOUR_OF_DAY, 2);
        Date timePlus2Hour = cal.getTime();



       flightsList.stream().filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL))
                .filter(flight -> flight.getDate().before(timePlus2Hour) && flight.getDate().after(timeNow))
                .collect(Collectors.toList()).forEach(System.out::println);
        }
    }

