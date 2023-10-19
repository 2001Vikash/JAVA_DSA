package DSA_Revision.Sorting;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        // insertionSort(arr);
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {// because we try to check j = i+1
            // so when we give last index then it will go for out of bound that's why put it like that
            for (int j = i+1; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else break;
            }
        }
    }
    static void insertionSort2(int[] arr){
        for(int i=1;i<arr.length;i++){// first elememtn ko sorted array ka part and baki sabhi ko unsorted
            int current=arr[i];
            int j=i-1;
            while (j>=0 && (current<arr[j])){
                arr[j+1]=arr[j];
                j--;
            }
            // System.out.println(j); jb loop chalega to j=-1 ho jayega
            // placement
            arr[j+1]=current;
        }
    }
}
