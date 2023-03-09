package org.java8.tasks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    private static final List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static List<Integer> getValues() {
        return values;
    }

    public static void main(String[] args) {
        printValuesWithStream(values);

        printRandomNumbersWithStream();

        getEvenNumbersWithStream(values).forEach(System.out::println);
    }

    // 1
    public static void printValuesWithStream(List<Integer> values) {

        Stream<Integer> stream = values.stream();
        stream.forEach(System.out::println);
    }

    // 2
    public static void printRandomNumbersWithStream() {
        Stream.generate(Math::random)
                .limit(20)
                .forEach(System.out::println);
    }

    // 3
    public static List<Integer> getEvenNumbersWithStream(List<Integer> values) {

        return values.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

}
