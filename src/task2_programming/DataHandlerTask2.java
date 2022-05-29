package task2_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * A programming_languages.txt fájlban szereplő adatok forrása: https://programminglanguages.info/languages-by-year/
 *
 * A programming_languages.txt fájl programozási nyelvek nevét és a megjelenésük évszámát tartalmazza.
 * Az adatok egy sorban vesszővel ( , ) vannak elválasztva.
 *
 * Olvasd be a fájl tartalmát, és tárold ebben az osztályban, a languages nevű Map-ben, méghozzá az évszám szerint
 * csoportosítva a különböző programozási nyelvek nevét!
 *
 * Ezután oldd meg a ProgrammingTask osztályban lévő feladatokat. A feladatok megoldásában használd a languages Map-et.
 *
 * Ellenőrizd a megoldásaidat a test mappában lévő tesztek futtatásával! (task2_programming.ProgrammingTaskTest)
 *
 * A már megírt programkód használható, átírása nem javasolt.
 */
public class DataHandlerTask2 {

    private static final String SEPARATOR = ",";

    private Map<Integer, List<String>> languages;

    public Map<Integer, List<String>> getLanguages() {
        if (languages == null) {
            loadData();
        }

        return languages;
    }

    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/task2_programming/programming_languages.txt"))) {
            languages = new HashMap<>();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                Integer year = Integer.parseInt(temp[1]);

                if (languages.containsKey(year)) {
                    languages.get(year).add(temp[0]);
                } else {
                    languages.put(year, new ArrayList<>());
                    languages.get(year).add(temp[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
