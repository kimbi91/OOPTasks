package task3_customers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerTask {

    private DataHandlerTask3 dataHandler;

    public CustomerTask() {
        dataHandler = new DataHandlerTask3();
    }

    /**
     * Példafeladat.
     * A fájl beolvasását végző metódus helyes megírása után a beolvasott adatok így érhetőek el.
     * A dataHandler.getCustomers() elvégzi a beolvasást, ha a lista hossza 0 - lásd ott.
     */
    public void dataFromFile() {
        List<Customer> customers = dataHandler.getCustomers();

        System.out.println("A fájl tartalma:");

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * Hány különböző országban élnek a felhasználók?
     * Számold meg!
     */
    public int countCountries() {
        List<Customer> customers = dataHandler.getCustomers();

        Set<String> customerSet = new HashSet<>();

        for (Customer customer : customers) {
            customerSet.add(customer.getCountry());
        }

        return customerSet.size();
    }

    /**
     * Mi a nevük azoknak a felhasználóknak, akik adott városban laknak?
     * Keresd meg a felhasználók között azokat, akik a metódus bemeneti paramétereként átadott városban laknak,
     * és gyűjtsd össze a nevüket!
     */
    public List<String> collectCustomerNamesByCity(String city) {
        List<Customer> customers = dataHandler.getCustomers();
        List<String> names = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getCity().equalsIgnoreCase(city)) {
                names.add(customer.getName());
            }
        }
        return names;
    }

    /**
     * Melyek azok az országok, amelyeknél az irányítószám tartalmaz betűt is?
     * Ügyelj arra, hogy a kötőjel nem minősül betűnek!
     *
     * Például:
     *      nem tartalmaz betűket:
     *          1010 (Argentina)
     *          05432-043 (Brazil), mert a kötőjel nem minősül betűnek
     *      tartalmaz betűket:
     *          WA1 1DP (UK)
     *          S-958 22 (Sweden)
     *          B-1180 (Belgium)
     */
    public Set<String> findCountriesWithNonDigitalPostalCode() {
        List<Customer> customers = dataHandler.getCustomers();
        Set<String> foundCountries = new HashSet<>();

        for (Customer customer : customers) {
            boolean isFound = false;

            for (int i = 0; i < customer.getPostalCode().length(); i++) {
                if (Character.isLetter(customer.getPostalCode().charAt(i))) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                foundCountries.add(customer.getCountry());
            }
        }
        return foundCountries;
    }

}
