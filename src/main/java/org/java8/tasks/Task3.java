package org.java8.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    private static final List<String> namesList;

    static {
        namesList = initializeList();
    }

    private static List<String> initializeList() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        return memberNames;
    }

    public static List<String> getNamesList() {
        return namesList;
    }

    public static void main(String[] args) {
        printList(filterElementsByStartingLetterAndLengthWithStream(namesList, "A", 5));
        System.out.println("\n");
        printList(sortElementsAndLowerCaseWithStream(namesList));

        boolean allMatch = doAllElementsMatchWithStream("S");
        boolean anyMatch = doesAnyElementMatchWithStream("S");
        boolean noneMatch = doNoneOfTheElementsMatchWithStream("H");

        System.out.println(allMatch);
        System.out.println(anyMatch);
        System.out.println(noneMatch);

        long namesStartingWithA = countFilteredElementsWithStream("A");
        System.out.println(namesStartingWithA);

        String firstNameWithL = findFirstFilteredElementWithStream("L");
        System.out.println(firstNameWithL);
    }

    // 6
    public static List<String> filterElementsByStartingLetterAndLengthWithStream(
            List<String> elements, String startingLetter, int length) {

        return elements.stream()
                .filter(e -> e.startsWith(startingLetter))
                .filter(e -> e.length() > length)
                .collect(Collectors.toList());
    }

    // 7
    public static List<String> sortElementsAndLowerCaseWithStream(List<String> elements) {
        return elements.stream()
                .sorted()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public static void printList(List<String> elements) {
        elements.forEach(System.out::println);
    }

    // 7
    public static boolean doNoneOfTheElementsMatchWithStream(String startsWith) {
        return namesList.stream()
                .noneMatch(e -> e.startsWith(startsWith));
    }

    // 7
    public static boolean doesAnyElementMatchWithStream(String startsWith) {
        return namesList.stream()
                .anyMatch(e -> e.startsWith(startsWith));
    }

    // 7
    public static boolean doAllElementsMatchWithStream(String startsWith) {
        return namesList.stream()
                .allMatch(e -> e.startsWith(startsWith));
    }

    // 8-9
    public static long countFilteredElementsWithStream(String startsWith) {
        return namesList.stream()
                .filter(e -> e.startsWith(startsWith))
                .count();
    }

    // 10
    public static String findFirstFilteredElementWithStream(String startsWith) {
        return namesList.stream()
                .filter(name -> name.startsWith(startsWith))
                .findFirst()
                .orElse(null);
    }
}
