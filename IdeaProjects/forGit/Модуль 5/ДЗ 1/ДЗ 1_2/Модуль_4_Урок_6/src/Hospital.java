import java.text.DecimalFormat;

public class Hospital {
    public static double[] temperatureOfPatient = new double[30];

    public static void temp() {
        double sum = 0;
        int sumOfHealthy = 0;
        DecimalFormat df = new DecimalFormat("#.#");

        for (int index = 0; index < temperatureOfPatient.length; index++) {
            temperatureOfPatient[index] = (Math.random() * 10) + 32;
            sum += temperatureOfPatient[index];

            if (temperatureOfPatient[index]> 36.2 && temperatureOfPatient[index] < 36.9 )   {
                sumOfHealthy++;
            }
        }
        sum = sum/temperatureOfPatient.length;

        System.out.println("Средняя температура по больнице: " + df.format(sum));
        System.out.println("Здоровых пациентов: " + sumOfHealthy);
    }

    public static void main(String[] args) {
        temp();
    }
}
