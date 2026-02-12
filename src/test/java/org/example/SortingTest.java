package org.example;

import org.example.sortering.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {


    @Test
    public void testInsertionSort() {
        Integer[] arr = {5, 2, 8, 1, 9};
        Integer[] expected = {1, 2, 5, 8, 9};

        InsertionSort2.insertionSort2(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = {5, 2, 8, 1, 9};
        Integer[] expected = {1, 2, 5, 8, 9};

        SelectionSort.selectionSort(arr);

        assertArrayEquals(expected, arr);
    }

//    @Test
//    public void testQuickSort() {
//        Integer[] arr = {5, 2, 8, 1, 9};
//        Integer[] expected = {1, 2, 5, 8, 9};
//
////        QuickSort.quickSort(arr);
//
//        assertArrayEquals(expected, arr);
//    }

    @Test
    public void testMergeSort() {
        Integer[] arr = {5, 2, 8, 1, 9};
        Integer[] expected = {1, 2, 5, 8, 9};

        MergeSort.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        Integer[] arr = {};
        Integer[] expected = {};

        InsertionSort2.insertionSort2(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSingleElement() {
        Integer[] arr = {5};
        Integer[] expected = {5};

        SelectionSort.selectionSort(arr);

        assertArrayEquals(expected, arr);
    }

//    @Test
//    public void testAlreadySorted() {
//        Integer[] arr = {1, 2, 3, 4, 5};
//        Integer[] expected = {1, 2, 3, 4, 5};
//
//        QuickSort.quickSort(arr);
//
//        assertArrayEquals(expected, arr);
//    }

    @Test
    public void testReverseSorted() {
        Integer[] arr = {9, 8, 5, 2, 1};
        Integer[] expected = {1, 2, 5, 8, 9};

        MergeSort.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testDuplicates() {
        Integer[] arr = {5, 2, 5, 1, 2};
        Integer[] expected = {1, 2, 2, 5, 5};

        InsertionSort2.insertionSort2(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testNegativeNumbers() {
        Integer[] arr = {-5, 2, -8, 1, 9};
        Integer[] expected = {-8, -5, 1, 2, 9};

        SelectionSort.selectionSort(arr);

        assertArrayEquals(expected, arr);
    }
}