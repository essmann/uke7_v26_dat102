package org.example.sortering;

public class SelectionSort {

    public static void selectionSort(Integer[] a){
        for(int i = 0; i<a.length; i++){
            int minimum = a[i];


            for(int j = i+1; j<a.length; j++ ){
                if(a[j] < minimum){

                    a[i] = a[j];
                    a[j] = minimum;
                    minimum = a[i];
                }
            }

        }
    }
}
