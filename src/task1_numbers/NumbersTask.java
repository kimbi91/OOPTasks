package task1_numbers;

import java.util.List;
import java.util.Map;

public class NumbersTask {

    private DataHandlerTask1 dataHandler;

    public NumbersTask() {
        dataHandler = new DataHandlerTask1();
    }

    /**
     * Példafeladat.
     * A fájl beolvasását végző metódus helyes megírása után a beolvasott adatok így érhetőek el.
     * A dataHandler.getNumbers() elvégzi a beolvasást, ha a lista még üres - lásd ott.
     */
    public void numbersFromFile() {
        List<Integer> numbers = dataHandler.getNumbers();

        System.out.println("A fájl tartalma:");

        int i = 0;
        for (; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }

        System.out.println(numbers.get(i));
    }

    /**
     * Add össze a fájlból beolvasott számokat!
     */
    public int sum() {
        // TODO
        return -1;
    }

    /**
     * Mekkora a fájlból beolvasott számok átlaga? Számítsd ki!
     */
    public double avg() {
        // TODO
        return 0.0;
    }

    /**
     * Hány különböző számjegyből áll az a szám, amely a beolvasott számokat tartalmazó lista adott indexén szerepel?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDifferentDigits(int index) {
        // TODO
        return -1;
    }

    /**
     * Hányszor szerepel az adott számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDigit(int digit) {
        // TODO
        return -1;
    }

    /**
     * Hányszor szerepel az összes számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public Map<Integer, Integer> countAllDigits() {
        // TODO
        return null;
    }

}
