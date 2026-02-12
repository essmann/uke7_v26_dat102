package org.example.sortering;

public class SortMainTest {
    public static void main(String[] args){
       Integer[] a = {1,5,10,0,3,2,15,7,7,0,2,5,1};
       a.clone();
        SelectionSort.selectionSort(a.clone());
        Integer[] a_clone = a.clone();
        MergeSort.mergeSort(a_clone);
       for(Integer x : a_clone){
           System.out.println(x);
       }
    }
}
