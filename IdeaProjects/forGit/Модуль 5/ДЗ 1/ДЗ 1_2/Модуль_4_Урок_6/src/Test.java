import java.lang.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
       String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colorOfRainbow = text.split(",?\\s+");

        for ( int index = 0; index < colorOfRainbow.length/2; index++) {
            String a = colorOfRainbow[colorOfRainbow.length - 1 - index];
            colorOfRainbow[colorOfRainbow.length - 1 - index] = colorOfRainbow[index];
            colorOfRainbow[index] = a;
        }
        System.out.println(Arrays.toString(colorOfRainbow));

        for (int i = 0; i < colorOfRainbow.length; i++)   {
            System.out.print(colorOfRainbow[i] + " ");
        }

    }
}