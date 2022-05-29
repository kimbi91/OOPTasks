package task4_pizzas;

import java.util.Locale;

public enum PizzaSize {

    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE;

    public static PizzaSize getPizzaSize(String size) {
        return switch (size.toUpperCase(Locale.ROOT)) {
            case "SMALL" -> SMALL;
            case "MEDIUM" -> MEDIUM;
            case "LARGE" -> LARGE;
            case "EXTRA_LARGE" -> EXTRA_LARGE;
            default -> null;
        };
    }

}
