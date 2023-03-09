package org.java8.tasks;

import org.junit.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Task2Tests {

    private static final List<Integer> integerList = Task2.getIntegerList();
    private static final List<String> stringList = Task2.getStringList();

    @Test
    public void whenFilteringStream_thenGetEvenValuesToArray() {

        Integer[] actualResults = Task2.getEvenValuesToArrayWithStream(integerList);

        Integer[] expectedResults = new Integer[] {2, 4, 6, 8};

        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void whenFilteringStream_thenGetUppercaseReversedValues() {

        List<String> actualResults = Task2.filterElementsAndReverseOrderWithStream(stringList, "c");

        List<String> expectedResults = List.of("C2", "C1");

        assertEquals(actualResults, expectedResults);
    }

}
