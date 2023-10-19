package DSA_Revision.Sorting;

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
      //  bubbleSort(arr);
      //  System.out.println(Arrays.toString(arr));

        bubbleSortWithRecursion(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));

    }
    public static void bubbleSort(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;// swapping happens
                }
            }
            if(!swapped)break;// if array is sorted then why we check for next.
        }
    }

    // Same as triangle pattern printing

    static void bubbleSortWithRecursion(int[] arr, int r, int c){
        if(r == 0){
            return;
        }
        if(c < r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSortWithRecursion(arr, r, c+1);
        }else{
            bubbleSortWithRecursion(arr, r-1, 0);
        }
    }
}
