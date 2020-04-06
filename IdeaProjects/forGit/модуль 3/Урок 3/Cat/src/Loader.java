
public class Loader {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat vasya = new Cat();
        cat.feed(50.0);

        vasya.feed(1000000.0);
        System.out.println(vasya.getWeight());
        vasya.feed(900000000.0);
        System.out.println(vasya.getWeight());
        System.out.println("Количество котов: " + Cat.getCatCount());
    }
}