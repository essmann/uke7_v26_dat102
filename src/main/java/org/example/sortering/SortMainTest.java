package org.example.sortering;

public class SortMainTest {
    public static void main(String[] args){
       Integer[] a = {1,5,10,0,3,2,15,7,7,0,2,5,1};
       QuickSort.quickSort(a, 0, a.length-1);
       for(Integer x :a){
           System.out.println(x);
       }
    }
}
