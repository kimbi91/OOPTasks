package task4_pizzas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTaskTest {

    private static PizzaTask task;
    private static List<Pizza> pizzas;

    @BeforeAll
    static void setup() {
        task = new PizzaTask();
        pizzas = new DataHandlerTask4().getPizzas();
    }

    @Test
    void loadFile() {
        assertEquals(12, pizzas.size());
    }

    @Test
    void pizzaSizeEnumTest() {
        String[] expected = {"SMALL", "MEDIUM", "LARGE", "EXTRA_LARGE"};
        PizzaSize[] sizes = PizzaSize.values();

        assertEquals(Arrays.toString(expected), Arrays.toString(sizes));
    }

    @Test
    void pizzaClassTest() {
        String forFields = "Number of fields in class Pizza: %d";
        String text = "Is there any method? %s";

        Field[] fields = Pizza.class.getDeclaredFields();
        assertEquals(String.format(forFields, 4), String.format(forFields, fields.length));

        Method[] methods = Pizza.class.getDeclaredMethods();
        assertEquals(String.format(text, true), String.format(text, (methods.length > 0)));
    }

    @Test
    void sumPreparationTime() {
        int preparation1 = task.sumPreparationTime();
        assertEquals(0, preparation1);

        int preparation2 = task.sumPreparationTime("Mákosguba", "Kiscica", "MegaVega");
        assertEquals(10, preparation2);

        int preparation3 = task.sumPreparationTime("Kolbászos");
        assertEquals(20, preparation3);

        int preparation4 = task.sumPreparationTime("Sonkás-kukoricás", "Carbonara", "Szuprém");
        assertEquals(70, preparation4);

        int preparation5 = task.sumPreparationTime("Kolbászos", "Sonkás-kukoricás", "Carbonara", "Hagymás",
                "MegaVega", "Gyros", "Húsimádó", "Hawaii", "Farmer", "Szuprém", "Sajtimádó", "Magyaros");
        assertEquals(395, preparation5);
    }

    @Test
    void findPizzasBySize() {
        List<Pizza> pizzaSmall = task.findPizzasBySize(PizzaSize.valueOf("SMALL"));
        assertListContains(pizzaSmall, "Kolbászos", "Sonkás-kukoricás", "Carbonara", "Hagymás");

        List<Pizza> pizzaMedium = task.findPizzasBySize(PizzaSize.valueOf("MEDIUM"));
        assertListContains(pizzaMedium, "MegaVega", "Gyros", "Húsimádó", "Hawaii");

        List<Pizza> pizzaLarge = task.findPizzasBySize(PizzaSize.valueOf("LARGE"));
        assertListContains(pizzaLarge, "Farmer", "Szuprém", "Sajtimádó");

        List<Pizza> pizzaExtra = task.findPizzasBySize(PizzaSize.valueOf("EXTRA_LARGE"));
        assertListContains(pizzaExtra, "Magyaros");
    }

    @Test
    void findPizzasWithTopping() {
        List<Pizza> invalidTopping = task.findPizzasWithTopping("kiscica");
        assertListContains(invalidTopping);

        List<Pizza> cheese = task.findPizzasWithTopping("trappista");
        assertListContains(cheese, "Sajtimádó");

        List<Pizza> onion = task.findPizzasWithTopping("hagyma");
        assertListContains(onion, "Hagymás", "Szuprém", "Magyaros");
    }


    // helper methods for testing

    private void assertListContains(List<Pizza> pizzas, String... contains) {
        assertEquals(contains.length, pizzas.size());

        List<String> pizzaNames = pizzaNames(pizzas);

        if (pizzaNames != null) {
            for (String name : contains) {
                if (!pizzaNames.contains(name)) {
                    throw new RuntimeException(name + " is not in the list!");
                }
            }
        }
    }

    private List<String> pizzaNames(List<Pizza> pizzas) {
        List<String> pizzaNames = new ArrayList<>();

        for (Pizza pizza : pizzas) {
            String name = pizzaName(pizza);

            if (name == null) {
                return null;
            }

            pizzaNames.add(pizzaName(pizza));
        }

        return pizzaNames;
    }

    private String pizzaName(Pizza pizza) {
        Method getName = findGetNameMethod();

        try {
            getName.setAccessible(true);
            Object name = getName.invoke(pizza);

            return name.toString();
        } catch (NullPointerException e) {
            throw new RuntimeException("Cannot find method to get pizza's name. " +
                    "Please write a getter that returns the pizza's name as a String value.");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return null;
        }
    }

    private Method findGetNameMethod() {
        Method[] methods = Pizza.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getReturnType().equals(String.class) && !method.getName().contains("toString")) {
                return method;
            }
        }

        return null;
    }

}