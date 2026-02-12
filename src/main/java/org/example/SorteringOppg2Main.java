package org.example;

import org.example.sortering.*;
import java.util.Random;
import java.util.function.Consumer;

public class SorteringOppg2Main {
    public static void main(String[] args) {
        Random tilfeldig = new Random();

        // Testdata
        Integer[] tabell_32 = new Integer[32000];
        Integer[] tabell_64 = new Integer[64000];
        Integer[] tabell_128 = new Integer[128000];

        for (int i = 0; i < tabell_32.length; i++) tabell_32[i] = tilfeldig.nextInt();
        for (int i = 0; i < tabell_64.length; i++) tabell_64[i] = tilfeldig.nextInt();
        for (int i = 0; i < tabell_128.length; i++) tabell_128[i] = tilfeldig.nextInt();

        // Test Insertion Sort
        testSort("INSERTION SORT", InsertionSort2::insertionSort2, tabell_32, tabell_64, tabell_128, 2);

        // Test Selection Sort
        testSort("SELECTION SORT", SelectionSort::selectionSort, tabell_32, tabell_64, tabell_128, 2);

        // Test Merge Sort (O(n log n))
        testSort("MERGE SORT", MergeSort::mergeSort, tabell_32, tabell_64, tabell_128, 1);

        // Test Quick Sort (O(n log n))
        testSort("QUICK SORT", QuickSort::quickSort, tabell_32, tabell_64, tabell_128, 1);

        //Oppgave 2 b) Prøv å sortere en tabell der alle elementene er like med Quicksort og mål tiden. Forklar hva som skjer og
        //hvorfor det skjer?

        Integer[] testArray = new Integer[100000]; //Alle er 0
        for(int i = 0; i<testArray.length; i++){
            testArray[i] = 5;
        }
       double tid = maalTid(testArray, QuickSort::quickSort);
        System.out.println("Alle elementer er like. Tid: " + tid);

        //Det som skjer her er Stackoverflow error. Den gjør for mange recursive calls.


    }

    // Tester én sorteringsmetode
    static void testSort(String navn, Consumer<Integer[]> sortMetode,
                         Integer[] arr32, Integer[] arr64, Integer[] arr128, int complexityType) {
        System.out.println("\n====== " + navn + " =======");

        //Typer
        // for O(n^2): complexityType = 2
        // for O(n log n) algorithms: complexityType = 1

        double tid32 = maalTid(arr32, sortMetode);
        double fn32 = (complexityType == 2) ? Math.pow(32000, 2) : 32000 * Math.log(32000);
        double c32 = tid32 / fn32;
        System.out.printf("32k:  %.4f sek, c = %.2e, c*f(n) = %.4f%n", tid32, c32, fn32 * c32);

        double tid64 = maalTid(arr64, sortMetode);
        double fn64 = (complexityType == 2) ? Math.pow(64000, 2) : 64000 * Math.log(64000);
        double c64 = tid64 / fn64;
        System.out.printf("64k:  %.4f sek, c = %.2e, c*f(n) = %.4f%n", tid64, c64, fn64 * c64);

        double tid128 = maalTid(arr128, sortMetode);
        double fn128 = (complexityType == 2) ? Math.pow(128000, 2) : 128000 * Math.log(128000);
        double c128 = tid128 / fn128;
        System.out.printf("128k: %.4f sek, c = %.2e, c*f(n) = %.4f%n", tid128, c128, fn128 * c128);

        double gjennomsnittC = (c32 + c64 + c128) / 3;
        System.out.printf("Gjennomsnitt c = %.2e%n", gjennomsnittC);

        System.out.printf("Gjennomsnitt tid = %.4f sek%n", (tid32 + tid64 + tid128) / 3);
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