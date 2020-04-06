import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong Format. Correct format: \n" +
                    "\tadd Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!isNameValid(components[1]) || !isNameValid(components[0]))   {
            throw new IllegalArgumentException("Wrong Name Format. Correct format: \n" +
                    "\tВасилий Петров");
        }

        if (!isEmailValid(components[2])) {
            throw new IllegalArgumentException("Wrong Email Format. Correct format: \n" +
                    "\tvasily.petrov@gmail.com");
        }

        if (!isTelephoneNumberValid(components[3])) {
            throw new IllegalArgumentException("Wrong Telephone Number Format. Correct format: \n" +
                    "\t+79215637722");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }
    public boolean isNameValid(String name) {
        return name.matches("^[А-Я][а-я]+([\\-А-Я][а-я]+)?$");
    }


    public boolean isEmailValid(String email) {
        return email.matches("^([\\w-]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
    }

    public boolean isTelephoneNumberValid(String telephoneNumber) {
        return telephoneNumber.matches("^\\+\\d{11,13}$");
    }

    public void listCustomers() {
        if (storage.size() != 0) {
            storage.values().forEach(System.out::println);
        } else {
            System.out.println("Список пока пуст");
        }
    }

    public void removeCustomer(String name) {

            String[] components = name.split("\\s+");

            if (components.length != 2) {
                throw new IllegalArgumentException("Wrong Format. Correct format: \n" +
                        "\tremove Василий Петров");
            }
            if (!isNameValid(components[0]) || !isNameValid(components[1])) {
                throw new IllegalArgumentException("Wrong Name Format. Correct format: \n" +
                        "\tВасилий Петров");
            }
        if (!storage.containsKey(name)) {
            System.out.println("В списке нет клиента с таким именем");
        }
            storage.remove(name );
        System.out.println(name + " был удалён из списка.");
        }


    public int getCount()
    {
        return storage.size();
    }
}