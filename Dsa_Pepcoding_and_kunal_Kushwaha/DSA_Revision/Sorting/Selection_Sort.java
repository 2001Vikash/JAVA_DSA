package DSA_Revision.Sorting;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
      //  selectionSortMin(arr);
      //  selectionSortWithRecursion(arr, arr.length-1, 0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int maxInd = 0; // or -> arr.length - 1 - i;
            for (int j = 0; j < arr.length-i; j++) {
                 if(arr[j] > arr[maxInd]){
                     maxInd = j;
                 }
            }
            int temp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[maxInd];
            arr[maxInd] = temp;
        }
    }
    // selection sort with minimum index

    static void selectionSortMin(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minInd = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minInd]){
                    minInd = j;
                }
            }
            if(i != minInd){
                int temp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = temp;
            }
        }
    }
    static void selectionSortWithRecursion(int[] arr, int r, int c, int maxInd){
        if(r == 0){
            return;
        }
        if(c <= r){
            if(arr[c] > arr[maxInd]) {
                selectionSortWithRecursion(arr, r, c + 1, c);
            }else{
                selectionSortWithRecursion(arr, r, c+1, maxInd);
            }
        }else{
            int temp = arr[maxInd];
            arr[maxInd] = arr[r];
            arr[r] = temp;
            selectionSortWithRecursion(arr, r-1, 0, 0);
        }
    }
}
