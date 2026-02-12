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

    @Test
    public void testQuickSort() {
        Integer[] arr = {5, 2, 8, 1, 9};
        Integer[] expected = {1, 2, 5, 8, 9};

        QuickSort.quickSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = {5, 2, 8, 1, 9};
        Integer[] expected = {1, 2, 5, 8, 9};

        MergeSort.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }










}