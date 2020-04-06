import java.util.Scanner;

public class Fio {

    public static void main(String[] args) {

        Scanner personFio = new Scanner(System.in);
        System.out.println("Введите свои Имя Фамилия Отчество:");
        String inFio = personFio.nextLine().trim();

        String[] newInFio = inFio.split(",?\\s+");

        System.out.println("Фамилия: " + newInFio[0]);
        System.out.println("Имя: " + newInFio[1]);
        System.out.println("Отчество: " + newInFio[2]);
    }
}
