import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRouteCalculator  extends TestCase {

    StationIndex stationIndex = new StationIndex();

    Line white = new Line(1, "Белая");
    Line black = new Line(2, "Черная");
    Line brown = new Line(3, "Коричнева");

    Station a = new Station("A", black);
    Station d = new Station("D", black);
    Station m = new Station("M", black);
    Station p = new Station("P", black);
    Station e = new Station("E", black);
    Station f = new Station("F", black);

    Station c = new Station("C", brown);
    Station n = new Station("N", brown);

    Station k = new Station("K", white);
    Station g = new Station("G", white);

    Station[] listOfStations =  {a, d, m, p, e, f, c, n, k, g};

    RouteCalculator calculator = new RouteCalculator(stationIndex);
    List<Station> route;
    /**
     *                                Black = a - d - m - p - e - f
     *                                White =  d - k - g
     * a---d---m---p----e----f        Brown =  e  - c - n
     *     |           ||
     *     k           c
     *    |           ||
     *    g           n
     */

    @Override
    protected void setUp() throws Exception {
        for(int i = 0; i < 6; i++) {
            black.addStation(listOfStations[i]);
        }

        for(int i = 0; i < listOfStations.length; i++) {
            stationIndex.addStation(listOfStations[i]);
        }

        white.addStation(d);
        white.addStation(k);
        white.addStation(g);

        brown.addStation(e);
        brown.addStation(c);
        brown.addStation(n);

        stationIndex.addLine(white);
        stationIndex.addLine(black);
        stationIndex.addLine(brown);

        List<Station> connectionStations = new ArrayList<>();
        connectionStations.add(e);
        connectionStations.add(c);
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();

        connectionStations.add(d);
        connectionStations.add(k);
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();
    }

        public void testCalculateDuration () {
        Station[] arrRoutes = {g, k, d, m, p, e, c, n};
            List<Station> route = new ArrayList<>();
            route.addAll(Arrays.asList(arrRoutes));
            double actual = RouteCalculator.calculateDuration(route);
            double expected = 19.5;
            assertEquals(expected, actual);
        }

        public void testRouteOnTheLine () {
            List<Station> route = calculator.getShortestRoute(a, m);
            List<String> expected = Arrays.asList("A", "D", "M");
            assertEquals(expected, route.stream().map(s -> s.getName()).collect(Collectors.toList()));
        }

        public void testRouteWithOneConnection () {
            List<Station> route = calculator.getShortestRoute(g, d);
            List<String> expected = Arrays.asList("G", "K", "D");
            assertEquals(expected, route.stream().map(s -> s.getName()).collect(Collectors.toList()));
        }

        public void testRouteWithTwoConnections () {
            List<Station> route = calculator.getShortestRoute(g, n);
            List<String> expected = Arrays.asList("G", "K", "D", "M", "P", "E", "C", "N");
            assertEquals(expected, route.stream().map(s -> s.getName()).collect(Collectors.toList()));
        }
    }


