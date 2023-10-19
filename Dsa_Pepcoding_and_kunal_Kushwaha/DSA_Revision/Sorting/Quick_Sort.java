package DSA_Revision.Sorting;

import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int s, int e){
        if(s < e){
            int m = partition(arr, s, e);
            quickSort(arr, s, m-1);
            quickSort(arr, m+1, e);
        }
    }
    static int partition(int[] arr, int s, int e){
        int pivot = arr[e];
        int i = s-1;
        for (int j = s; j <= e-1; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[e];
        arr[e] = arr[i+1];
        arr[i+1] = temp;

        return i+1;
    }
}
