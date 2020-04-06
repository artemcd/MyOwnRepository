
public class Loader {




    public static void main(String[] args) {
       Cat murka = new Cat();
       murka.setName("Мурка");
       murka.setColor(Color.BROWN);

        Cat vasya = new Cat(murka);


        System.out.println(vasya.getWeight());
        System.out.println(murka.getWeight());
        System.out.println(vasya.getName());
        vasya.setName("Вася");

        System.out.println(vasya.getName());
        System.out.println(murka.getName());

     System.out.println(vasya.getColor());
     System.out.println(murka.getColor());

        vasya.feed(1000.0);

        System.out.println(vasya.getWeight());
        System.out.println(murka.getWeight());










        }
}