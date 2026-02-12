package org.example.sortering;

public class QuickSort {

    public static void quickSort(Integer[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(Integer[] array, int first, int last) {
        if (first < last) {
            int pivot = partition(array, first, last);
//            System.out.println("Pivot: " + pivot);
            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
    }

    private static int partition(Integer[] array, int first, int last) {
        int pivot = array[last];
        int i = first - 1;

        for (int j = first; j <= last - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        var tmp = array[i + 1];
        array[i + 1] = array[last];
        array[last] = tmp;

        return i + 1;
    }
}