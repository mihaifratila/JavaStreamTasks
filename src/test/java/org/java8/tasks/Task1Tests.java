package org.java8.tasks;


import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Task1Tests {
    private static final List<Integer> testValues = Task1.getValues();

    @Test
    public void whenFilteringStream_thenGetEvenValues() {

        List<Integer> actualValues = Task1.getEvenNumbersWithStream(testValues);

        List<Integer> expectedValues = List.of(2, 4, 6, 8);

        assertEquals(expectedValues, actualValues);
    }
}
