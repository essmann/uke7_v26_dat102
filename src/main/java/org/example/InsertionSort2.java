package org.example;

public class InsertionSort2 {
    public static <T extends Comparable<? super T>> void insertionSort2(T[] a) {
        for (int i = 1; i < a.length; i += 2) {
            if (i == a.length - 1) {
                T temp = a[i];
                int j = i - 1;
                while (j >= 0 && temp.compareTo(a[j]) < 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
                break;
            }

            // ta ut to elementer
            T elem1 = a[i];
            T elem2 = a[i + 1];

            // Bestem hvilket som er minste og største
            T minste, største;
            if (elem1.compareTo(elem2) <= 0) {
                minste = elem1;
                største = elem2;
            } else {
                minste = elem2;
                største = elem1;
            }

            // Flytt elementer i sortert del to plasser til høyre
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(største) > 0) {
                a[j + 2] = a[j];
                j--;
            }

            // Sett inn største
            a[j + 2] = største;

            // Fortsett med å sette inn minste (vanlig insertion sort)
            // men bare frem til der vi satte inn største
            while (j >= 0 && a[j].compareTo(minste) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            // Sett inn minste
            a[j + 1] = minste;
        }
    }
}