package task3_customers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A fájlban szereplő adatok forrása: https://docs.yugabyte.com/preview/sample-data/northwind/
 *
 * A customers.txt fájl regisztrált felhasználók néhány adatát tartalmazza. Az adatok vesszővel ( , ) vannak elválasztva.
 * A fájl az alábbi adatokat tartalmazza egy-egy felhasználóról:
 *      egyedi azonosító (egész szám)
 *      név
 *      postai irányítószám (nem csak számokat tartalmazhat!)
 *      ország neve
 *      város neve
 *
 * Valósítsd meg a Customer osztályt! Hozd létre a megfelelő fieldeket, konstruktorokat, gettereket, settereket,
 * hogy a fájlban lévő sorokat objektumként tudd kezelni.
 * Az egyedi azonosító kivételével minden adatot tárolj String-ként.
 *
 * Olvasd be a fájl tartalmát, és a fájl soraiból létrehozott Customer objektumokat tárold ebben az osztályban,
 * a customers nevű listában!
 *
 * Ezután oldd meg a CustomerTask osztályban lévő feladatokat. A feladatok megoldásában használd a customers listát.
 *
 * Ellenőrizd a megoldásaidat a test mappában lévő tesztek futtatásával! (task3_customers.CustomerTaskTest)
 *
 * A már megírt programkód használható, átírása nem javasolt.
 */
public class DataHandlerTask3 {

    private static final String SEPARATOR = ",";

    private List<Customer> customers;

    public DataHandlerTask3() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        if (customers.size() == 0) {
            loadFromFile();
        }

        return customers;
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/task3_customers/customers.txt"))) {
            String line;

            customers = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                customers.add(new Customer(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
