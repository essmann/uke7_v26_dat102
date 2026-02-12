package org.example.sortering;

public class MergeSort {
   public static void mergeSort(Integer[] a ){


        Integer length = a.length;
        if(length <= 1) return; //basistilfelle

        Integer middle = length / 2;

        Integer[] leftArray = new Integer[middle];
        Integer[] rightArray = new Integer[ length - middle];

        Integer i = 0; //left array
        Integer j = 0; //right array

        for(; i< length; i++){
            if(i < middle){
                leftArray[i] = a[i];

            }
            else{
                rightArray[j] = a[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);


        MergeSort.merge(leftArray, rightArray, a);

    }




    private static void merge(Integer[] leftArray, Integer[] rightArray, Integer[] array){
            Integer leftSize = array.length / 2;
            Integer rightSize = array.length - leftSize;

            Integer i = 0, l = 0, r = 0; //indices


        //[0,3,2] and //[5,1,0]
        //array = [0, 3, 2]
             //check conditions for merging
        while(l < leftSize && r < rightSize ){
            if(leftArray[l] < rightArray[r]){

                array[i] = leftArray[l];
                l++;
                i++;
            }
            else{
                array[i] = rightArray[r];
                r++;
                i++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
}
