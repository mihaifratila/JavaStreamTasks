package org.java8.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    private static final List<Integer> integerList;
    private static final List<String> stringList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

    static {
        integerList = initializeIntegerList();
    }

    private static List<Integer> initializeIntegerList() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> getIntegerList() {
        return integerList;
    }

    public static List<String> getStringList() {
        return stringList;
    }

    // 4
    public static Integer[] getEvenValuesToArrayWithStream(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);
    }

    // 5
    public static List<String> filterElementsAndReverseOrderWithStream(List<String> list, String filter) {
        return list.stream()
                .filter(e -> e.contains(filter))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
