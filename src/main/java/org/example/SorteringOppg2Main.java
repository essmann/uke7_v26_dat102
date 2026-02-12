package org.example;

import org.example.sortering.*;
import java.util.Random;
import java.util.function.Consumer;

public class SorteringOppg2Main {
    public static void main(String[] args) {
        Random tilfeldig = new Random();

        // Lag test-data
        Integer[] tabell_32 = new Integer[32000];
        Integer[] tabell_64 = new Integer[64000];
        Integer[] tabell_128 = new Integer[128000];

        for (int i = 0; i < tabell_32.length; i++) tabell_32[i] = tilfeldig.nextInt();
        for (int i = 0; i < tabell_64.length; i++) tabell_64[i] = tilfeldig.nextInt();
        for (int i = 0; i < tabell_128.length; i++) tabell_128[i] = tilfeldig.nextInt();


        // Test Selection Sort
        testSort("INSERTION SORT", InsertionSort2::insertionSort2, tabell_32, tabell_64, tabell_128);

        // Test Selection Sort
        testSort("SELECTION SORT", SelectionSort::selectionSort, tabell_32, tabell_64, tabell_128);


        // Test Merge Sort
        testSort("MERGE SORT", MergeSort::mergeSort, tabell_32, tabell_64, tabell_128);
    }

    // Tester én sorteringsmetode
    static void testSort(String navn, Consumer<Integer[]> sortMetode,
                         Integer[] arr32, Integer[] arr64, Integer[] arr128) {
        System.out.println("\n======" + navn + "=======");

        double tid32 = maalTid(arr32, sortMetode);
        double c32 = tid32 / Math.pow(32000, 2);
        System.out.println("32k:  " + tid32 + " sek, c = " + c32);

        double tid64 = maalTid(arr64, sortMetode);
        double c64 = tid64 / Math.pow(64000, 2);
        System.out.println("64k:  " + tid64 + " sek, c = " + c64);

        double tid128 = maalTid(arr128, sortMetode);
        double c128 = tid128 / Math.pow(128000, 2);
        System.out.println("128k: " + tid128 + " sek, c = " + c128);

        // Gjennomsnittlig c
        double gjennomsnittC = (tid32 + tid64 + tid128) / 3;
        System.out.println("Gjennomsnitt tid = " + gjennomsnittC);
    }

    // Måler tiden for en enkel array
    static double maalTid(Integer[] array, Consumer<Integer[]> sortMetode) {
        int runs = 3;
        long totalTid = 0;

        for (int i = 0; i < runs; i++) {
            Integer[] kopi = array.clone();

            long start = System.nanoTime();
            sortMetode.accept(kopi);
            long slutt = System.nanoTime();

            totalTid += (slutt - start);
        }

        return (totalTid / 1_000_000_000.0) / runs;
    }
}