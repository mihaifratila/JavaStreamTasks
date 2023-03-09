package org.java8.tasks;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.java8.tasks.Task4.*;
import static org.testng.Assert.assertEquals;

public class Task4Tests {

    private static final List<List<Integer>> integerData = getList();
    private static final String[][] stringData = getDataArray();
    private static final List<Integer> numbersListData = getNumbersList();
    private static final Map<String, List<String>> mapData = getPeopleMap();


    @Test
    public void whenFlatMapComplexList_thenReturnConcatenatedResult() {

        List<Integer> actualResult = concatenateArraysUsingFlatMap(integerData);

        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void whenFlatMapMatrix_thenReturnDistinctConcatenatedResult() {

        List<String> actualResult = getDistinctElementsFromConcatenatedArrayUsingFlatMap(stringData);

        List<String> expectedResult = List.of("a", "b", "c", "d", "e", "f", "g", "h");

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void whenCollectingToMapFromList_thenReturnNumberOfOccurrencesAsValues() {

        Map<Integer, Integer> actualResult = getMapWithNumberOfElementOccurrencesFromList(numbersListData);

        Map<Integer, Integer> expectedResult = Map.of(1, 2, 2, 1, 3, 3, 4,
                                                      1, 5, 1, 6, 3, 7, 1);

        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void whenFlatMapComplexMap_thenReturnLettersInValues() {

        List<Character> actualResult = getLettersFromMapValuesWithFlatMap(mapData);

        List<Character> expectedResult = List.of('d', 's', 'a', 'z');

        assertEquals(actualResult, expectedResult);
    }
}
