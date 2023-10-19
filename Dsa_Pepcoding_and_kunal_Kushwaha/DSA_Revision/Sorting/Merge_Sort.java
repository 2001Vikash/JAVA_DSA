package DSA_Revision.Sorting;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int s, int e){

        if(s < e){
            int m = s + (e-s) / 2;
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            Merge(arr, s, m, e);
        }

    }
    static void Merge(int[] arr, int s, int m, int e){
        int i = s;
        int j = m + 1;
        int[] a = new int[e-s+1];
        int k = 0;
        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                a[k] = arr[i];
                i++;
            }else{
                a[k] = arr[j];
                j++;
            }
            k++;
        }
        for( ; i <= m; i++){
            a[k++] = arr[i];
        }
        for( ; j <= e; j++){
            a[k++] = arr[j];
        }

        // updating the original array with same index
        k = 0;
        for (int l = s; l <= e; l++) {
            arr[l] = a[k++];
        }
    }
}

