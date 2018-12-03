package exercises.otherides;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.Ignore;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This set of exercises covers new default methods on
 * the Collections and related APIs.
 */
public class C_DefaultMethods {

    /**
     * Given a list of StringBuilders, modify each StringBuilder
     * in-place by appending the string "new" to each one.
     */
    @Test @Ignore
    public void c01_appendNew() {
        List<StringBuilder> sbList = Arrays.asList(
            new StringBuilder("alfa"),
            new StringBuilder("bravo"),
            new StringBuilder("charlie"));

        // TODO write code to modify sbList

        assertEquals(Arrays.asList("alfanew", "bravonew", "charlienew"),
                sbList.stream()
                      .map(StringBuilder::toString)
                      .collect(Collectors.toList()));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Iterable.forEach().
    // </editor-fold>


    /**
     * Remove the words that have odd lengths from the list.
     */
    @Test @Ignore
    public void c02_removeOddLengthWords() {
        List<String> list = new ArrayList<>(Arrays.asList(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));

        // TODO write code to modify list

        assertEquals(Arrays.asList("alfa", "echo"), list);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Collection.removeIf().
    // </editor-fold>


    /**
     * Replace every word in the list with its upper case equivalent.
     */
    @Test @Ignore
    public void c03_upcaseAllWords() {
        List<String> list = Arrays.asList(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        // TODO code to modify list

        assertEquals(Arrays.asList("ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT"),
                     list);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use List.replaceAll().
    // </editor-fold>


    /**
     * Given a map whose keys are Integers and whose values are StringBuilders,
     * append to each StringBuilder the string representation of its corresponding
     * Integer key. This should mutate each StringBuilder value in-place.
     */
    @Test @Ignore
    public void c04_appendToMapValues() {
        Map<Integer, StringBuilder> map = new TreeMap<>();
        map.put(1, new StringBuilder("alfa"));
        map.put(2, new StringBuilder("bravo"));
        map.put(3, new StringBuilder("charlie"));

        // TODO write code to modify map

        assertEquals(3, map.size());
        assertTrue(map.values().stream().allMatch(x -> x instanceof StringBuilder));
        assertEquals("alfa1",    map.get(1).toString());
        assertEquals("bravo2",   map.get(2).toString());
        assertEquals("charlie3", map.get(3).toString());
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.forEach().
    // </editor-fold>


    /**
     * Given a map whose keys are Integers and whose values are Strings,
     * append to each String the string representation of its corresponding
     * Integer key.
     */
    @Test @Ignore
    public void c05_replaceMapValues() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "alfa");
        map.put(2, "bravo");
        map.put(3, "charlie");

        // TODO write code to modify map

        assertEquals(3, map.size());
        assertEquals("alfa1",    map.get(1));
        assertEquals("bravo2",   map.get(2));
        assertEquals("charlie3", map.get(3));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.replaceAll().
    // </editor-fold>


    /**
     * Given a list of words, populate a map whose keys are the lengths of
     * each word, and whose values are list of words with that length.
     */
    @Test @Ignore
    public void c06_mapOfListOfStringsByLength() {
        List<String> list = Arrays.asList(
            "aardvark", "bison", "capybara",
            "alligator", "bushbaby", "chimpanzee",
            "avocet", "bustard", "capuchin");
        Map<Integer, List<String>> result = new TreeMap<>();

        // TODO write code to populate result

        assertEquals(Arrays.asList(5, 6, 7, 8, 9, 10), new ArrayList<>(result.keySet()));
        assertEquals(Arrays.asList("bison"), result.get(5));
        assertEquals(Arrays.asList("avocet"), result.get(6));
        assertEquals(Arrays.asList("bustard"), result.get(7));
        assertEquals(Arrays.asList("aardvark", "capybara", "bushbaby", "capuchin"), result.get(8));
        assertEquals(Arrays.asList("alligator"), result.get(9));
        assertEquals(Arrays.asList("chimpanzee"), result.get(10));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.computeIfAbsent() within Iterable.forEach().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the initial characters of
     * each word, and whose values are the concatenation of the words with that
     * initial character. When concatenating the words, they should be
     * separated by a colon (':').
     */
    @Test @Ignore
    public void c07_mapOfStringByInitialCharacter() {
        List<String> list = Arrays.asList(
            "aardvark", "bison", "capybara",
            "alligator", "bushbaby", "chimpanzee",
            "avocet", "bustard", "capuchin");
        Map<Character, String> result = new TreeMap<>();

        // TODO write code to populate result

        assertEquals(Arrays.asList('a', 'b', 'c'), new ArrayList<>(result.keySet()));
        assertEquals("aardvark:alligator:avocet",    result.get('a'));
        assertEquals("bison:bushbaby:bustard",       result.get('b'));
        assertEquals("capybara:chimpanzee:capuchin", result.get('c'));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.merge() within Iterable.forEach().
    // </editor-fold>


    /**
     * For some reason the provided map doesn't have mappings for all the keys. This
     * is a problem, because if we call get() on a key that isn't present, it returns
     * null, and we need to add checks to protect against NullPointerException.
     * Write code to ensure that all missing keys are mapped to the empty string.
     */
    @Test @Ignore
    public void c08_mapWithMissingValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");

        // TODO write code to fix the map

        Assertions.assertThat(map).containsOnly(
                new AbstractMap.SimpleEntry<>("a", "alfa"),
                new AbstractMap.SimpleEntry<>("b", "bravo"),
                new AbstractMap.SimpleEntry<>("c", "charlie"),
                new AbstractMap.SimpleEntry<>("d", "delta"),
                new AbstractMap.SimpleEntry<>("e", ""),
                new AbstractMap.SimpleEntry<>("f", ""),
                new AbstractMap.SimpleEntry<>("g", ""));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.putIfAbsent() default method.
    // </editor-fold>


    /**
     * In the previous example, we added map entries that had a default value.
     * We've now determined that's incorrect, and we want to undo that. This
     * time, we want to remove the entry if the value is the empty string.
     */
    @Test @Ignore
    public void c09_mapRemoveEntriesWithEmptyValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code to fix the map

        Assertions.assertThat(map).containsOnly(
                new AbstractMap.SimpleEntry<>("a", "alfa"),
                new AbstractMap.SimpleEntry<>("b", "bravo"),
                new AbstractMap.SimpleEntry<>("c", "charlie"),
                new AbstractMap.SimpleEntry<>("d", "delta"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the two-arg Map.remove() default method.
    // </editor-fold>


    /**
     * We need another way to deal with the problem of the previous example.
     * Instead of removing entries whose value is the empty string, we want
     * to replace the empty-string values with a value that's the key itself.
     * Write the code to do that.
     */
    @Test @Ignore
    public void c10_mapReplaceEmptyValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code to fix the map

        Assertions.assertThat(map).containsOnly(
                new AbstractMap.SimpleEntry<>("a", "alfa"),
                new AbstractMap.SimpleEntry<>("b", "bravo"),
                new AbstractMap.SimpleEntry<>("c", "charlie"),
                new AbstractMap.SimpleEntry<>("d", "delta"),
                new AbstractMap.SimpleEntry<>("e", "e"),
                new AbstractMap.SimpleEntry<>("f", "f"),
                new AbstractMap.SimpleEntry<>("g", "g"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.replace() default method that takes 3 arguments.
    // </editor-fold>


    /**
     * We are still dealing with a map with missing entries. For entries that
     * are present, we want to convert the value to upper case; and for keys
     * that are not present, we want to add an entry where the value is the
     * same as the key.
     */
    @Test @Ignore
    public void c11_computeWithMissingEntries() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");

        // TODO write code transform the map

        Assertions.assertThat(map).containsOnly(
                new AbstractMap.SimpleEntry<>("a", "ALFA"),
                new AbstractMap.SimpleEntry<>("b", "BRAVO"),
                new AbstractMap.SimpleEntry<>("c", "CHARLIE"),
                new AbstractMap.SimpleEntry<>("d", "DELTA"),
                new AbstractMap.SimpleEntry<>("e", "e"),
                new AbstractMap.SimpleEntry<>("f", "f"),
                new AbstractMap.SimpleEntry<>("g", "g"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.compute() default method, and read the Javadoc carefully
    // regarding the mappings that aren't present.
    // </editor-fold>


    /**
     * The map now has several entries, some with valid values, and some
     * with values that are the empty string. This time, we want to convert
     * the non-empty values to upper case, but we want to remove the entries
     * for which the values are the empty string.
     */
    @Test @Ignore
    public void c12_computeAndRemoveSomeEntries() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        // TODO write code transform the map

        Assertions.assertThat(map).containsOnly(
                new AbstractMap.SimpleEntry<>("a", "ALFA"),
                new AbstractMap.SimpleEntry<>("b", "BRAVO"),
                new AbstractMap.SimpleEntry<>("c", "CHARLIE"),
                new AbstractMap.SimpleEntry<>("d", "DELTA"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.compute() default method, read the Javadoc carefully
    // for the handling of null values returned from the function.
    // </editor-fold>
}
