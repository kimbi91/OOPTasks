package task3_customers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTaskTest {

    private static CustomerTask task;
    private static List<Customer> customers;

    @BeforeAll
    static void setup() {
        task = new CustomerTask();
        customers = new DataHandlerTask3().getCustomers();
    }

    @Test
    void loadFile() {
        assertEquals(50, customers.size());
    }

    @Test
    void countCountries() {
        int result = task.countCountries();
        assertEquals(17, result);
    }

    @Test
    void collectCustomerNamesByCity() {
        List<String> noValid = task.collectCustomerNamesByCity("Kiscica");
        assertContains(noValid);

        List<String> cork = task.collectCustomerNamesByCity("Cork");
        assertContains(cork, "Hungry Owl All-Night Grocers");

        List<String> mexico = task.collectCustomerNamesByCity("México D.F.");
        assertContains(mexico, "Ana Trujillo Emparedados y helados", "Antonio Moreno Taquería", "Centro comercial Moctezuma");

        List<String> london = task.collectCustomerNamesByCity("London");
        assertContains(london, "Around the Horn", "B's Beverages", "Consolidated Holdings", "Eastern Connection");
    }

    @Test
    void findCountriesWithNonDigitalPostalCode() {
        Set<String> result = task.findCountriesWithNonDigitalPostalCode();
        assertContains(result, "Canada", "Sweden", "UK", "Belgium", "Ireland");
    }

    private void assertContains(Collection<String> collection, String... contains) {
        assertEquals(contains.length, collection.size());

        for (String s : contains) {
            if (!collection.contains(s)) {
                throw new RuntimeException(s + " is not in the collection!");
            }
        }
    }

}