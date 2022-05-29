package task1_numbers;

import java.util.*;

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
        List<Integer> numbers = dataHandler.getNumbers();

        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    /**
     * Mekkora a fájlból beolvasott számok átlaga? Számítsd ki!
     */
    public double avg() {
        List<Integer> numbers = dataHandler.getNumbers();

        int sum = sum();

        return (double) sum / numbers.size();
    }

    /**
     * Hány különböző számjegyből áll az a szám, amely a beolvasott számokat tartalmazó lista adott indexén szerepel?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDifferentDigits(int index) {
        List<Integer> numbers = dataHandler.getNumbers();
        int counter = 0;
        Integer target = 0;

        for (Integer number : numbers) {
            if (counter == index) {
                target = number;
                break;
            }
            counter++;
        }

        Set<Character> targetChars = new HashSet<>();
        char[] targetchr = target.toString().toCharArray();

        for (int i = 0; i < target.toString().length(); i++) {
            if (targetchr[i] != '-') {
                targetChars.add(targetchr[i]);
            }
        }

        return targetChars.size();
    }

    /**
     * Hányszor szerepel az adott számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public int countDigit(int digit) {
        List<Integer> numbers = dataHandler.getNumbers();

        int counter = 0;

        for (Integer number : numbers) {
            char[] temp = number.toString().toCharArray();

            for (char c : temp) {
                if (Character.getNumericValue(c) == digit) {
                    counter++;
                }
            }
        }


        return counter;
    }

    /**
     * Hányszor szerepel az összes számjegy az összes számban?
     * Számold össze, és térj vissza a megoldással!
     */
    public Map<Integer, Integer> countAllDigits() {
        List<Integer> numbers = dataHandler.getNumbers();

        Map<Integer, Integer> digitsCounted = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            digitsCounted.put(i, 0);
        }

        for (Integer number : numbers) {
            char[] temp = number.toString().toCharArray();

            for (int i = 0; i < temp.length; i++) {
                int current = Character.getNumericValue(temp[i]);
                if (temp[i] != '-') {
                    digitsCounted.replace(current, digitsCounted.get(current) + 1);
                }
            }
        }

        return digitsCounted;
    }

}
