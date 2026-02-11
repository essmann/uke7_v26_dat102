package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random tilfeldig = new Random();
        int n =  100000;
        Integer[] tabell = new Integer[n];
        for (int i = 0; i < n; i++) tabell[i] = tilfeldig.nextInt();

        Integer[] tabellCopy = tabell.clone();
        //Third
        Integer[] tabellCopyC = tabell.clone();


        // a) Første insertion sort
        long start = System.nanoTime();
        for (int i = 1; i < tabell.length; i++) {
            int temp = tabell[i];
            int j = i - 1;
            while (j >= 0 && tabell[j] > temp) {
                tabell[j + 1] = tabell[j];
                j--;
            }
            tabell[j + 1] = temp;
        }
        long end = System.nanoTime();
        System.out.println("a) Time: " + (end - start) / 1_000_000_000.0 + " seconds");

        // b) InsertionSort2 (2 samtidig)
        start = System.nanoTime();
        InsertionSort2.insertionSort2(tabellCopy);
        end = System.nanoTime();
        System.out.println("b) Time: " + (end - start) / 1_000_000_000.0 + " seconds");

        // c) InsertionSort3 (kombinert)
        start = System.nanoTime();
        InsertionSort3.insertionSort2(tabellCopyC);
        end = System.nanoTime();
        System.out.println("c) Time: " + (end - start) / 1_000_000_000.0 + " seconds");

    }
    //Oppgave 1 a)         //For 100000 elementer tok det gjennomsnittlig 2 sekunder.
    // For 5*100000 elementer tok det nesten ett minutt. Så denne blir virkelig dårlig for store datasett.
}
