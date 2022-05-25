package task2_programming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammingTaskTest {

    private static ProgrammingTask task;
    private static Map<Integer, List<String>> languages;

    @BeforeAll
    static void setup() {
        task = new ProgrammingTask();
        languages = new DataHandlerTask2().getLanguages();
    }

    @Test
    void loadFile() {
        if (languages == null) {
            throw new RuntimeException("No data loaded. Check loadFile() method!");
        }

        assertEquals(76, languages.size());
    }

    @Test
    void findYearWithMaxLanguages() {
        int result = task.findYearWithMaxLanguages();
        assertEquals(1996, result);
    }

    @Test
    void findLanguageYear() {
        int kitten = task.findLanguageYear("kiscica");
        assertEquals(-1, kitten);

        int cPlus = task.findLanguageYear("C+");
        assertEquals(-1, cPlus);

        int java = task.findLanguageYear("java");
        assertEquals(-1, java);

        int Java = task.findLanguageYear("Java");
        assertEquals(1995, Java);

        int tepl = task.findLanguageYear("Text Executive Programming Language");
        assertEquals(1979, tepl);

        int go = task.findLanguageYear("Go");
        assertEquals(2009, go);
    }

    @Test
    void searchForLanguages() {
        List<String> empty = task.searchForLanguages("xxx");
        assertResult(empty, 0);

        List<String> empty2 = task.searchForLanguages("c ++");
        assertResult(empty2, 0);

        List<String> ibm = task.searchForLanguages("ibm");
        System.out.println(ibm);
        assertResult(ibm, 6, "IBM Advanced BASIC", "IBM BASIC", "IBM Informix-4GL", "IBM PL/S",
                "IBM RPG II", "IBM RPG III");

        List<String> basic = task.searchForLanguages("basic");
        assertResult(basic, 45, "Altair BASIC", "IBM BASIC", "Integer BASIC", "WordBASIC", "Visual Basic .NET");

        List<String> godot = task.searchForLanguages("Godot");
        assertResult(godot, 1, "Godot");
    }

    private void assertResult(List<String> result, int expectedSize, String... contains) {
        if (result == null) {
            throw new RuntimeException("Empty result list!");
        }

        assertEquals(expectedSize, result.size());

        for (String lang : contains) {
            if (!result.contains(lang)) {
                throw new RuntimeException(lang + " is not in the result list, but should be.");
            }
        }
    }

    @Test
    void countLanguagesWithOneLetterName() {
        int result = task.countLanguagesWithOneLetterName();
        assertEquals(13, result);
    }

    @Test
    void findLongestNamedLanguage() {
        String result = task.findLongestNamedLanguage();
        assertEquals("Allgemeiner Berichts Aufbereitungs Prozessor", result);
    }

}