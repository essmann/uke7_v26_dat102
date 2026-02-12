package org.example.sortering;

public class InsertionSort3 {

    public static <T extends Comparable<? super T>> void insertionSort2(T[] a) {

        int n = a.length;
        if (n < 2) return;

        for (int i = n - 1; i > 0; i--) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                T temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }

        int i = 2;

        for (; i < n - 1; i += 2) {

            T elem1 = a[i];
            T elem2 = a[i + 1];

            T minste, største;

            if (elem1.compareTo(elem2) <= 0) {
                minste = elem1;
                største = elem2;
            } else {
                minste = elem2;
                største = elem1;
            }

            int j = i - 1;

            while (a[j].compareTo(største) > 0) {
                a[j + 2] = a[j];
                j--;
            }
            a[j + 2] = største;

            while (a[j].compareTo(minste) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = minste;
        }

        if (i == n - 1) {
            T temp = a[i];
            int j = i - 1;

            while (a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }
}
