package task4_pizzas;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private List<String> toppings;
    private int timeToMake;
    private PizzaSize pizzaSize;

    public Pizza(String line) {
        String[] units = line.split(";");
        this.name = units[0];
        this.toppings = getToppingsList(units[1]);
        this.timeToMake = Integer.parseInt(units[2]);
        this.pizzaSize = PizzaSize.getPizzaSize(units[3]);
    }

    private List<String> getToppingsList(String toppings) {
        List<String> toppingList = new ArrayList<>();
        String[] toppingsArr = toppings.split(",");
        int index = 0;

        for (String topping : toppingsArr) {
            toppingList.add(toppingsArr[index]);
            index++;
        }

        return toppingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public void setTimeToMake(int timeToMake) {
        this.timeToMake = timeToMake;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
