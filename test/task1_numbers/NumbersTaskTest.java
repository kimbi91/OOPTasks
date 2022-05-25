package task1_numbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTaskTest {

    private static NumbersTask task;
    private static List<Integer> numbers;

    @BeforeAll
    static void setup() {
        task = new NumbersTask();
        numbers = new DataHandlerTask1().getNumbers();
    }

    @Test
    void loadFile() {
        assertEquals(101, numbers.size());
    }

    @Test
    void sum() {
        int sum = task.sum();
        assertEquals(2528, sum);
    }

    @Test
    void avg() {
        double avg = task.avg();
        assertEquals(25.02970297029703, avg, 0.01);
    }

    @Test
    void countDifferentDigits() {
        if (numbers.size() == 0) {
            throw new RuntimeException("Missing list detected. Please read the file before running tests!");
        } else {
            int index0 = task.countDifferentDigits(0);
            assertEquals(3, index0);

            int index16 = task.countDifferentDigits(16);
            assertEquals(1, index16);

            int index100 = task.countDifferentDigits(100);
            assertEquals(4, index100);
        }
    }

    @Test
    void countDigit() {
        int digit0 = task.countDigit(0);
        assertEquals(31, digit0);

        int digit1 = task.countDigit(1);
        assertEquals(75, digit1);

        int digit5 = task.countDigit(5);
        assertEquals(44, digit5);
    }

    @Test
    void countAllDigits() {
        Map<Integer, Integer> digits = task.countAllDigits();

        assertDigitsOccurrence(digits, 0, 31);
        assertDigitsOccurrence(digits, 1, 75);
        assertDigitsOccurrence(digits, 2, 29);
        assertDigitsOccurrence(digits, 3, 20);
        assertDigitsOccurrence(digits, 4, 25);
        assertDigitsOccurrence(digits, 5, 44);
        assertDigitsOccurrence(digits, 6, 36);
        assertDigitsOccurrence(digits, 7, 30);
        assertDigitsOccurrence(digits, 8, 23);
        assertDigitsOccurrence(digits, 9, 18);
    }

    private void assertDigitsOccurrence(Map<Integer, Integer> digits, int key, int value) {
        try {
            int result = digits.get(key);
            assertEquals(value, result);
        } catch (Exception e) {
            throw new RuntimeException(key + " is not in the map as a key.");
        }
    }

}