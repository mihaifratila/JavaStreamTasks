package org.java8.tasks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task4 {

    private static final List<List<Integer>> list;
    private static final String[][] dataArray = new String[][]{{"a", "b", "c"},
            {"c", "d", "e"}, {"e", "f", "g"}, {"e", "g", "h"}};
    public static final ArrayList<Integer> numbersList =
            new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
    private static final Map<String, List<String>> peopleMap;

    static {
        list = initializeList();
        peopleMap = initializeMap();
    }

    private static List<List<Integer>> initializeList() {
       List<List<Integer>> newList = new ArrayList<>();
        newList.add(Arrays.asList(1, 2, 3));
        newList.add(Arrays.asList(4, 5, 6));
        newList.add(Arrays.asList(7, 8, 9));

        return newList;
    }

    private static Map<String, List<String>> initializeMap() {
        Map<String, List<String>> peopleMap = new HashMap<>();
        peopleMap.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
        peopleMap.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
        peopleMap.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

        return peopleMap;
    }

    public static List<List<Integer>> getList() {
        return list;
    }

    public static String[][] getDataArray() {
        return dataArray;
    }
    public static List<Integer> getNumbersList() { return numbersList; }

    public static Map<String, List<String>> getPeopleMap() {
        return peopleMap;
    }

    public static void main(String[] args) {

       List<Integer> answer = concatenateArraysUsingFlatMap(list);
       printWithStream(answer);

       List<String> answer2 = getDistinctElementsFromConcatenatedArrayUsingFlatMap(dataArray);
       printWithStream(answer2);

        List<Character> lettersList = getLettersFromMapValuesWithFlatMap(peopleMap);
        printWithStream(lettersList);

        Map<Integer, Integer> numbersMap = getMapWithNumberOfElementOccurrencesFromList(numbersList);
        numbersMap.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));
    }

    // 11
    public static List<Integer> concatenateArraysUsingFlatMap(List<List<Integer>> list) {
        return list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // 12
    public static List<String> getDistinctElementsFromConcatenatedArrayUsingFlatMap(String[][] array) {
        return Arrays.stream(array)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    // 13
    public static Map<Integer, Integer> getMapWithNumberOfElementOccurrencesFromList(List<Integer> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),  // Use the element itself as the key.
                        e -> 1,  // Map each element to 1 (to count occurrences).
                        Integer::sum  // Add values together for same keys.
                ));
    }

    // 14
    public static List<Character> getLettersFromMapValuesWithFlatMap(Map<String, List<String>> data) {
        return data.values().stream()
                .flatMap(List::stream)
                .flatMapToInt(CharSequence::chars)
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .distinct()
                .collect(Collectors.toList());
    }

    private static void printWithStream(Collection collection) {
        collection.forEach(System.out::println);
    }
}
