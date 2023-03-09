package org.java8.tasks;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.java8.tasks.Task3.*;

public class Task3Tests {
    private final static List<String> namesList = getNamesList();

    @Test
    public void whenFilteringStream_getNamesByLengthAndStartingLetter() {

        List<String> actualResult = filterElementsByStartingLetterAndLengthWithStream(
                namesList, "A", 5);

        List<String> expectedResult = List.of("Amitabh", "Abibaba");

        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void whenSortingStream_getNamesOrderedAndInLowercase() {

        List<String> actualResult = sortElementsAndLowerCaseWithStream(namesList);

        List<String> expectedResult = List.of("abibaba", "aman", "amitabh",
                "lokesh", "rahul", "salman", "shahrukh", "shekhar", "yana");

        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void whenApplyAllMatch_thenReturnBoolean() {

        boolean doAllElementsStartWithLetterS = doAllElementsMatchWithStream("S");

        assertFalse(doAllElementsStartWithLetterS);

    }

    @Test
    public void whenApplyAnyMatch_thenReturnBoolean() {

        boolean doesAnyElementStartWithLetterS = doesAnyElementMatchWithStream("S");

        assertTrue(doesAnyElementStartWithLetterS);

    }

    @Test
    public void whenApplyNoneMatch_thenReturnBoolean() {

        boolean doNoneOfTheElementsStartWithLetterH = doNoneOfTheElementsMatchWithStream("H");

        assertTrue(doNoneOfTheElementsStartWithLetterH);

    }

    @Test
    public void whenFilteringStream_thenCountFilteredElements() {

        long actualResult = countFilteredElementsWithStream("A");

        assertEquals(actualResult, 3);
    }

    @Test
    public void whenFilteringStream_thenReturnFirstElementMatching() {

        String actualResult = findFirstFilteredElementWithStream("L");

        String expectedResult = "Lokesh";

        assertEquals(actualResult, expectedResult);
    }
}
